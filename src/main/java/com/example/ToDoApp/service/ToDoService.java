package com.example.ToDoApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoApp.Model.ToDo;
import com.example.ToDoApp.repo.IToDoRepo;

@Service
public class ToDoService {
	
	@Autowired
	IToDoRepo repo;
	public List<ToDo>getAllToDoItems(){
		ArrayList<ToDo> todoList = new ArrayList<>();	
		repo.findAll().forEach(todo-> todoList.add(todo));
		return todoList;
	}
	public ToDo  getToDoItemById(Long id){
		return repo.findById(id).get();
	}
	
	public boolean updateStatus(Long id){
		ToDo todo =  getToDoItemById(id); //calling object
		todo.setStatus("completed");
		
		return saveOrUpdateToDoItem(todo); // calling method
	}
	
	public boolean saveOrUpdateToDoItem(ToDo todo){      //receiving ToDo object
		ToDo updatedObj = repo.save(todo);                 //we have method name save ,and entity is todo. also returns an object(updatedObj)
		
		if(getToDoItemById(updatedObj.getId())!=null){
			return true;
		}
	return false;
	}
		
	public boolean deleteToDoItem(Long id){
		repo.deleteById(id);                          
		
		if(getToDoItemById(id) == null) {

			return true;
}
		return false;
}
	
	
}