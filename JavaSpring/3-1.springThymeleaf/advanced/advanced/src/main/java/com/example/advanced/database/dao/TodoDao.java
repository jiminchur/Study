package com.example.advanced.database.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.database.repository.TodoRepository;
import com.example.advanced.model.entity.TodoEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoDao {
    
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> selectTodoAll(){
        
        log.info("[TodoDao][selectTodoAll]Start!!");
        
        List<TodoEntity> todoList = todoRepository.findAll();
        
        log.info("todoList "+todoList.size());
        
        return todoList;
    }

    public void insertTodo(TodoEntity todo){
        
        log.info("[TodoDao][insertTodo]Start!!");
        
        todo.setStatus("flase");
        todoRepository.save(todo);
    }

    public void updateTodo(TodoEntity todo){
        
        log.info("[TodoDao][updateTodo]Start!!");
        
        TodoEntity savedTodo = todoRepository.getReferenceById(todo.getId());
        
        if(todo.getStatus() != null){
            savedTodo.setStatus(todo.getStatus());
        }

        todoRepository.save(savedTodo);
    }

    public void deleteTodo(TodoEntity todo){
        
        log.info("[TodoDao][deleteTodo]Start!!");
        
        TodoEntity savedTodo = todoRepository.getReferenceById(todo.getId());

        todoRepository.delete(savedTodo);
    }
}
