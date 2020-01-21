package com.example.todo.list.service;

import com.example.todo.list.entity.Message;

public interface MessageService {


    void add(Message message);
    Iterable<Message> search(String text);
    Iterable<Message> getAll();
    void delete(Message message);
    Message edit(Message message);

}
