package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        log.info("hello...");
        return "hello2";
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1...");
        //파라미터를 변수로 쉽게 받음
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name",defaultValue = "AAA") String name,
                    @RequestParam(name = "age",defaultValue = "22") int age) {
        log.info("ex2...");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3...");
        log.info("dueDate: " + dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("-------ex4--------------");
        model.addAttribute("message", "Hello World");
    }

    @GetMapping("/ex4_1")
    public void ex4Extra(TodoDTO todoDTO, Model model) {
        log.info("todoDTO: " + todoDTO);
        model.addAttribute("todoDTO", todoDTO);
    }

    @GetMapping("/ex4_2")
    public void ex4_2(@ModelAttribute("dto") TodoDTO todoDTO) {
        //@ModelAttribute 는 모델객체 없이 객체를 뷰(jsp)에 전달함
        log.info("todoDTO: " + todoDTO);
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        //리다이렉트(새로운 요청)에 데이터를 전달한다.
        //포워드(기본)은 request, model 에 데이터를 전달가능하지만 redirect 는 기존요청으로 전달되지 않음.
        redirectAttributes.addAttribute("name", "ABC"); //쿼리스트링
        redirectAttributes.addFlashAttribute("result", "success"); //1회용

        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6() {
        log.info("ex6...");
    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2) {
        log.info("p1 : " + p1);
        log.info("p2: " + p2);
    }
}
