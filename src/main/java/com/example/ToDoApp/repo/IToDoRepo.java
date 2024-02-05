package com.example.ToDoApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDoApp.Model.ToDo;
@Repository
public interface IToDoRepo  extends JpaRepository<ToDo,Long>{

}
