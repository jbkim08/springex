package org.zerock.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import javax.validation.Valid;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    //localhost:8080/todo/list
    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO,
                     BindingResult bindingResult, Model model) {
        log.info(pageRequestDTO);
        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build(); //기본 세팅 1page 화면당 10개
        }
        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);
    }
    //localhost:8080/todo/register (get)
    @GetMapping("/register")
    public void registerGet() {
        log.info("register get method");
    }
    //유저가 할일 입력하고 submit 버튼을 누르면 /todo/register post
    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("register post method");

        if (bindingResult.hasErrors()) {
            log.info("유효성 검증 에러발생!");
            return "redirect:/todo/register"; //검증실패시 다시 register 로 돌아감.
        }
        // 검증 성공 DB에 새 할일 저장
        log.info("todoDTO: " + todoDTO);
        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    //한개의 할일을 DB 에서 읽어와서 표시하기
    @GetMapping({"/read","/modify"})
    public void read(Long tno, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info("todoDTO: " + todoDTO);
        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes) {
        log.info("remove method");
        log.info("tno: " + tno);
        todoService.remove(tno); //삭제
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("수정내용이 형식에 맞지않음...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify"; // 실패시 다시 수정페이지로 돌아감
        }
        log.info("todoDTO: " + todoDTO);
        todoService.modify(todoDTO); //수정하기

        return "redirect:/todo/list";
    }

}
