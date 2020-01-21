package com.example.todo.list.repository;

import com.example.todo.list.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Long> {

    Iterable<Message> findByTextContainingOrAuthorContaining(String param1, String param2);


}
