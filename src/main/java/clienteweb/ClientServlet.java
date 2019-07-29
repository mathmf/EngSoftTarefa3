package clienteweb;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.lang.Object.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ClienteService;



	@WebServlet(urlPatterns = {"/usuario"})
	public class ClientServlet extends HttpServlet {

	ClienteService clienteService;
	
	public void init() throws ServletException{
		clienteService = new ClienteService();
		super.init();
	}
	
	  @Override
	  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
	          throws ServletException, IOException {
	      System.out.println("Comando Put");
	      int userId = retrieveUserid(req);
	      String body = inputStreamToString(req.getInputStream());
	      System.out.println("corpo do HTML: " + body);
	      //UserDataService.Instance.saveUserById(userId, body);
	  }
	  @Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub

		}

	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	          throws ServletException, IOException {
		  
		  String i = req.getParameter("i");
		  if(i!="" && i!= null) {
			  clienteService.delUsuario(Integer.parseInt(i));
		  }
	      
		  RequestDispatcher dispatcher = req.getRequestDispatcher("usuario.jsp");
			    
			    
		  Gson gson = new Gson();
		  String list = gson.toJson(clienteService.getTodos());
		  req.setAttribute("Mapa",list );
			    
		  dispatcher.forward(req, resp);
			  
	  }
	  
	  @Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		  int userId = Integer.parseInt(req.getParameter("userId"));
		  String nome = req.getParameter("name");
		  String email = req.getParameter("email");
		  String senha = req.getParameter("senha");
		  String status = req.getParameter("status");
		  User user = new User (userId,nome,email,senha,status);
		  
		  clienteService.addUsuario(user);

	      resp.sendRedirect("usuario");
	      //resp.setCharacterEncoding("UTF-8");
	      //resp.getWriter().print("POST enviou usuário : " + user.toString());

		}

	  private static int retrieveUserid(HttpServletRequest req) {
	      String pathInfo = req.getPathInfo();
	      if (pathInfo.startsWith("/")) {
	          pathInfo = pathInfo.substring(1);
	      }
	      return Integer.parseInt(pathInfo);
	  }

	  private static String inputStreamToString(InputStream inputStream) {
	      Scanner scanner = new Scanner(inputStream, "UTF-8");
	      return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
	  }
	  
}
