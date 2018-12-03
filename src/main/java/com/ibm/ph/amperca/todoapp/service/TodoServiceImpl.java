package com.ibm.ph.amperca.todoapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.ph.amperca.todoapp.model.Todo;

@Service
public class TodoServiceImpl implements TodoService {
	
	private static List<Todo> todoList = new ArrayList<>();
	
	private int countId = 3;
	
	static {
		todoList.add(new Todo(1,"Learn Angular",new Date(),new Date(), true));
		todoList.add(new Todo(2,"Learn Spring MVC",new Date(),new Date(), false));
		todoList.add(new Todo(3,"Learn Linux",new Date(),new Date(), true));
	}

	@Override
	public void addTodo(Todo todo) {
		todo.setId(++countId);
		todo.setActive(true);
		todo.setCreatedDate(new Date());
		todoList.add(todo);
	}

	@Override
	public void deleteTodo(int id) {
		
		for(Todo todo : todoList) {
			if(todo.getId() == id) {
				todoList.remove(todo);
				return;
			}
		}

	}

	@Override
	public Todo getTodo(int id) {
		
		for(Todo todo : todoList) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		
		return null;
	}
	
	
	@Override
	public void updateTodo(Todo todo) {
		
		Todo todoDb = getTodo(todo.getId());
		// update
		todoDb.setDescription(todo.getDescription());
		
	}

	@Override
	public List<Todo> showAllTodo() {
		return todoList;
	}

	@Override
	public void showActiveTodo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showCompletedTodo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setActive(Todo todo) {
		// TODO Auto-generated method stub

	}



}
