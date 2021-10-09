package com.sddevops.coursework1;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrudTest {
	
  
    private Crud crud;
    private User u1;
    private Items item1;
    
    @BeforeEach
    void setUp() throws Exception {
    	crud = new Crud();
    	
    }
    

	@Test
	void testInsertUser() throws SQLException {
		
		u1 = new User("Anna", "anna@example.com", "456 HJK St 45");
		crud.insertUser(u1);
		List<User> testInsert = crud.selectAllUsers();
		assertEquals(testInsert.size(), 3);
		
	}

	
	@Test
	void testSelectUser() {
		
		User u2 = crud.selectUser(15);
		String name = "John";
		
		assertEquals(u2.getName(), name);
		
	}
	
	
	@Test
	void testSelectAllUsers() {
		
		List<User> testSelect = crud.selectAllUsers();
		assertEquals(testSelect.size(), 3);
	}
	
	
	@Test
	void testDeleteUser() throws SQLException {
		List<User> testDelete = crud.selectAllUsers();
		u1 = new User("Eric", "eric@example.com" ,"345 JUY St 34");
		crud.insertUser(u1);
		
		User u2 = testDelete.get(testDelete.size() -1);
		crud.deleteUser(u2.getId());
		
		assertEquals(testDelete.size(), 3);
		
		
	}
	

	@Test
	void testUpdateUser() throws SQLException {
		User u1 = crud.selectUser(3);
		u1.setName("Raymond");
		crud.updateUser(u1);
		
		assertEquals(u1.getName(), "Raymond");
		
	}
	
	
	@Test
	void testInsertItem() throws SQLException {
		item1 = new Items("brocoli", 10, 2.50);
		crud.insertItem(item1);
		List<Items> testInsert = crud.selectAllItems();
		assertEquals(testInsert.size(), 4);
	}

	@Test
	void testSelectItem() {
		Items item1 = crud.selectItem(7);
		String name = "Grape";
		
		assertEquals(item1.getitemName(), name);
	}

	@Test
	void testSelectAllItems() {
		List<Items> testSelect = crud.selectAllItems();
		assertEquals(testSelect.size(), 4);
	}

	@Test
	void testDeleteItem() throws SQLException {
		List<Items> testDelete = crud.selectAllItems();
		item1 = new Items("banana", 15, 3.50);
		crud.insertItem(item1);
		
		Items item2 = testDelete.get(testDelete.size() -1);
		crud.deleteItem(item2.getId());
		
		assertEquals(testDelete.size(), 4);
	}

	@Test
	void testUpdateItem() throws SQLException {
		Items item1 = crud.selectItem(6);
		item1.setitemName("Orange");
		crud.updateItem(item1);
		
		assertEquals(item1.getitemName(), "Orange");
	}
	

}
