package com.example.backEnd.todolist;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListServiceImplementation implements ToDoListService {
    private final ToDoListRepository toDoListRepository;

    public ToDoListServiceImplementation(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public ToDoList saveToDoList(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    @Override
    public List<ToDoList> getAllToDoLists() {
        return toDoListRepository.findAll();
    }

    @Override
    public ToDoList findById(Long toDoListId) {
        return toDoListRepository.findById(toDoListId).orElse(null);
    }
}
