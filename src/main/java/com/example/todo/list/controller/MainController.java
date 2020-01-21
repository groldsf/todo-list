package com.example.todo.list.controller;

import com.example.todo.list.entity.Message;
import com.example.todo.list.repository.MessageRepository;
import com.example.todo.list.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    private final MessageService messageService;

    public MainController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping
    public String index(Map<String,Object> model){
        model.put("messages", messageService.getAll());
        return "index";
    }

    @GetMapping(params = {"search"})
    public String index(Map<String,Object> model, @RequestParam String search){
        model.put("messages", messageService.search(search));
        return "index";
    }
    @PostMapping
    public String addTodoMessage(String author, Map<String,Object> model, String text){
        messageService.add(new Message(author,text));
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTodoMessage(Map<String,Object> model, Message message){
        messageService.delete(message);
        return "redirect:/";
    }
}
