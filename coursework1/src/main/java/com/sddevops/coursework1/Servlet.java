package com.sddevops.coursework1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sddevops.coursework1.Crud;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private Crud userCrud;
	private LoginCrud loginCrud;
	
	public void init() {
		userCrud = new Crud();
		loginCrud = new LoginCrud();
	}
       
    public Servlet() {
        super();
    }

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/newItem":
                    showNewItemForm(request, response);
                    break;
                case "/insertItem":
                    insertItem(request, response);
                    break;
                case "/deleteItem":
                    deleteItem(request, response);
                    break;
                case "/editItem":
                    showEditItemForm(request, response);
                    break;
                case "/updateItem":
                    updateItem(request, response);
                    break;
                case "/listItem":
                	listItem(request,response);
                case "/list":
                	listUser(request, response);
                default:
                    login(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
		
	}
	

	private void login(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);

        try {
            if (loginCrud.validate(admin)) {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
            	dispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();         
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
	}
	

	private void listUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < User > listUser = userCrud.selectAllUsers();
		        request.setAttribute("listUser", listUser);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("list-user.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        User existingUser = userCrud.selectUser(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		        request.setAttribute("user", existingUser);
		        dispatcher.forward(request, response);

		    }
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String name = request.getParameter("name");
		        String email = request.getParameter("email");
		        String address = request.getParameter("address");
		        User newUser = new User(name, email, address);
		        userCrud.insertUser(newUser);
		        response.sendRedirect("list");
		    }
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        String email = request.getParameter("email");
		        String address = request.getParameter("address");

		        User book = new User(id, name, email, address);
		        userCrud.updateUser(book);
		        response.sendRedirect("list");
		    }
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        userCrud.deleteUser(id);
		        response.sendRedirect("list");

		    }
	
	private void listItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Items > listItem = userCrud.selectAllItems();
		        request.setAttribute("listItem", listItem);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("list-item.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showNewItemForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("item-form.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showEditItemForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Items existingItem = userCrud.selectItem(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("item-form.jsp");
		        request.setAttribute("item", existingItem);
		        dispatcher.forward(request, response);

		    }
	
	private void insertItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String itemName = request.getParameter("itemName");
		        int quantity = Integer.parseInt(request.getParameter("quantity"));
		        //String quantity = request.getParameter("quantity");
		        double price = Double.parseDouble(request.getParameter("price"));
		        //String price = request.getParameter("price");
		        Items newItem = new Items(itemName, quantity, price);
		        userCrud.insertItem(newItem);
		        response.sendRedirect("listItem");
		    }
	
	private void updateItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String itemName = request.getParameter("itemName");
		        int quantity = Integer.parseInt(request.getParameter("quantity"));
		        double price = Double.parseDouble(request.getParameter("price"));

		        Items book2 = new Items(id, itemName, quantity, price);
		        userCrud.updateItem(book2);
		        response.sendRedirect("listItem");
		    }
	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        userCrud.deleteItem(id);
		        response.sendRedirect("listItem");

		    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
