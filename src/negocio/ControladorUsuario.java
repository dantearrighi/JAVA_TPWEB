package negocio;

import java.util.ArrayList;

import javax.swing.JOptionPane; 

public class ControladorUsuario {
	

datos.CatalogoUsuarios catUsuarios;
Usuario user;	


public ControladorUsuario(){
 
 catUsuarios =new datos.CatalogoUsuarios();

}


public Usuario getUsuario(String pUsername, String pPassword) throws Exception{
	
	user =catUsuarios.GetOne(pUsername, pPassword);
	
	return(user);	
	
	}
	

}


