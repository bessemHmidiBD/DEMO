package com.bdtn.todos.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bdtn.todos.domain.Todos;
import com.bdtn.todos.service.TodosEndPoint;
 
@RunWith(CdiRunner.class)
public class TodosTest {  

	//comment
	@Inject
	TodosEndPoint todosEndPoint;
	 
	@Test
	public void testGetAllTodos() {
		List<Todos> result=todosEndPoint.getAll();
		
		assertEquals(2, result.size());
	}

}
