package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.ControladorElectrodomesticoNegocio;
import negocio.ControladorUsuario;
import negocio.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ControladorUsuario controladorUsuario = new ControladorUsuario();
		ControladorElectrodomesticoNegocio controladorElectro= new ControladorElectrodomesticoNegocio();
		
		Usuario vUsuario;
		HttpSession session= request.getSession(true);
		
	    
		String vUsername =request.getParameter("username");
	    
		String vPassword =request.getParameter("password");
	    try{
	    vUsuario=controladorUsuario.getUsuario(vUsername, vPassword);
	    
	    if(vUsuario!=null){
	   
		session.setAttribute("usuario",vUsername);
		session.setAttribute("controladorUsuario",controladorUsuario);
		session.setAttribute("controladorElectro",controladorElectro);
		session.setAttribute("pass", vPassword);
		request.getRequestDispatcher("/MenuElectro.jsp").forward(request, response);
	    }}
	   catch(Exception e){
		   session.setAttribute("error", e);
		   response.sendRedirect("/ErrorLogin.jsp");  
	   }
	    	
		
	}

}
