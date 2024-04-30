package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.springex.dto.TodoDTO;

@Controller
@Log4j2
@RequestMapping("/todo")
public class TodoController {
    //localhost:8080/todo/list
    @RequestMapping("/list")
    public void list() {
        log.info("list");
    }
    //localhost:8080/todo/register (get)
    @GetMapping("/register")
    public void registerGet() {
        log.info("register get method");
    }
    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO) {
        log.info("register post method");
        log.info("todoDTO: " + todoDTO);
    }
}
