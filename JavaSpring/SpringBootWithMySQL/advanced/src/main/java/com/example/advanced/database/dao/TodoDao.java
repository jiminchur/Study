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

    public List<TodoEntity> selectAll() throws Exception {
        log.info("[TodoDao][selectAll] Start!!");
        
        return todoRepository.findAll();
    }

    public void insertTodo(TodoEntity entity) throws Exception {
        log.info("[TodoDao][insertTodo] Start!!");
        
        todoRepository.save(entity);
    }

    public void updateTodo(TodoEntity entity) throws Exception {
        log.info("[TodoDao][updateTodo] Start!!");

        TodoEntity savedEntity = todoRepository.getReferenceById(entity.getId());
        if(entity.getStatus().equals(true)){
            savedEntity.setStatus(entity.getStatus());
        }
        if(entity.getProgressPercentage() > 0){
            savedEntity.setProgressPercentage(entity.getProgressPercentage());
        }
        if(entity.getDuDate() != null){
            savedEntity.setDuDate(entity.getDuDate());
        }

        todoRepository.save(savedEntity);
    }

    public void deleteTodo(Long id) throws Exception {
        todoRepository.deleteById(id);
    }
}
