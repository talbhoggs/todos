package com.ibm.ph.amperca.todoapp.service;
import java.util.List;

import com.ibm.ph.amperca.todoapp.model.Todo;

public interface TodoService {
	void addTodo(Todo todo);
	void deleteTodo(int id);
	Todo getTodo(int id);
	void updateTodo(Todo todo);
	List<Todo> showAllTodo();
	void showActiveTodo();
	void showCompletedTodo();
	void setActive(Todo todo);
}
