package com.example.advanced.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advanced.database.dao.TodoDao;
import com.example.advanced.model.dto.TodoDto;
import com.example.advanced.model.entity.TodoEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {
    
    @Autowired
    private TodoDao todoDao;

    public List<TodoDto> selectAll() throws Exception {
        List<TodoEntity> entityList = todoDao.selectAll();

        List<TodoDto> todoDtos = new ArrayList<>();
        for(TodoEntity entity:entityList){
            TodoDto dto = new TodoDto(entity.getId(), entity.getName(), entity.getStatus()
            , entity.getProgressPercentage(), entity.getDuDate());

            todoDtos.add(dto);
        }
        return todoDtos;
    }

    public void insertTodo(String name){
        TodoEntity entity = new TodoEntity();
        
        entity.setName(name);
        entity.setStatus(false);
        entity.setProgressPercentage(0);
        
        LocalDate now = LocalDate().now();
        entity.setDuDate(null);
        todoDao.insertTodo(entity);
    }

    public void updateTodo(Long id){
        TodoEntity entity = new TodoEntity();

        entity.setId(id);
        entity.setStatus(false);

        todoDao.updateTodo(entity);
    }

    public void deleteTodo(Long id){
        todoDao.deleteTodo(id);
    }
}
