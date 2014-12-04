package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Usuario;

public class CatalogoUsuarios {




	public Usuario GetOne(String pUsername, String pPassword)
	{
		
		Usuario userBD = new Usuario();
		try{
			
		 
		
		String SQLCons= "SELECT * FROM Usuarios WHERE idUsuario=?";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1, pUsername);		
		ResultSet rta = stmt.executeQuery();
		while(rta.next())
		{
						
						userBD.setUsername(rta.getString("idUsuario"));
		}
					rta.close();
					stmt.close();
						
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
								}
		return userBD;
	}


}


