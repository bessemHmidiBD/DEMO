package com.bdtn.todos.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bdtn.todos.domain.Todos;

@Path("/TODOS")
@SessionScoped
public class TodosEndPoint implements Serializable{

	List<Todos> allTodos;
	
	
	@PostConstruct
	public void init(){
		allTodos=new ArrayList<>(Arrays.asList(new Todos("tache1"),new Todos("tache2")));
		
	}
	
	@GET @Produces(MediaType.APPLICATION_JSON)
	public List<Todos> getAll(){
		return allTodos;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Todos todos){
		allTodos.add(todos);
	}
	
	
}
