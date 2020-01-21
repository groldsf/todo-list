package com.example.todo.list.service;

import com.example.todo.list.entity.Message;
import com.example.todo.list.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements com.example.todo.list.service.MessageService {

    private final
    MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void add(Message message) {
        messageRepository.save(message);
    }

    @Override
    public Iterable<Message> search(String text) {
        return messageRepository.findByTextContainingOrAuthorContaining(text,text);
    }

    @Override
    public Iterable<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public void delete(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public Message edit(Message message) {
        return null;
    }

}
