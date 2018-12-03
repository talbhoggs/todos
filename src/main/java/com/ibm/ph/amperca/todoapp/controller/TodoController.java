package com.ibm.ph.amperca.todoapp.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.ph.amperca.todoapp.model.Todo;
import com.ibm.ph.amperca.todoapp.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping("/all")
	public String showAll(ModelMap model) {		
		model.put("action", "all");
		model.put("todos", todoService.showAllTodo());
		return "todos";
	}
	
	@RequestMapping("/active")
	public String showActive(ModelMap model) {		
		model.put("action", "active");
		model.put("todos", todoService.showAllTodo());
		return "todos";
	}
	
	@RequestMapping("/completed")
	public String showCompleted(ModelMap model) {	
		model.put("action", "completed");
		model.put("todos", todoService.showAllTodo());
		return "todos";
	}
	
	@RequestMapping("/delete")
	public String deleteTodo(@RequestParam String id) {
		todoService.deleteTodo(Integer.valueOf(id));
		return "redirect:/all";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/add")
	public String showAddTodoPage(ModelMap model) {
		model.put("todo", new Todo(0,"Test Todo",new Date(), null, true));
		return "todos-add";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/add")
	public String addTodo(@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todos-add";
		}
		todoService.addTodo(todo);
		return "redirect:/all";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/update")	
	public String showUpdateTodoPage(@RequestParam String id, ModelMap model) {
		model.put("todo", todoService.getTodo(Integer.valueOf(id)));
		return "todos-update";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update")
	public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "todos-update";
		}
		todoService.updateTodo(todo);
		return "redirect:/all";
	}
	
	// ALL
	// Active Task
	// Completed Task
	
	public String showActive() {
		return "active";
	}
	
	public String showCompleted() {
		return "completed";
	}

}
