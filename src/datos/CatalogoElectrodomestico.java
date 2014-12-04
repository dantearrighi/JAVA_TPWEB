package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Electrodomestico;


public class CatalogoElectrodomestico {
	
	
	

	/*SQL Region*/
public int AddElectro(Electrodomestico Electro)
{
	try{
	String SQLCons= "INSERT INTO Electrodomestico (descripcion, color_elect, consumo_elect, peso_elect ,precio_elect)"+ " VALUES (?, ?, ?,?,?)" ;/* +pDescripcion+","+ pColor +","+ pConsumo + "," + pPeso+ "," + pPrecio; */
ConexionBD conecta = new ConexionBD();
conecta.OpenConection();
PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
stmt.setString(1,Electro.getDescripcion());
stmt.setString(2, Electro.getColor());
stmt.setFloat(5, Electro.getPreciobase());
stmt.setFloat(4, Electro.getPeso());
stmt.setObject(3, Electro.getConsumoEnergetico(),java.sql.Types.CHAR);



	stmt.execute(); 
	conecta.CloseConnection();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return Statement.RETURN_GENERATED_KEYS;
}
public void DeleteElectro(int pIdElec)
{
	String SQLCons= "DELETE FROM Electrodomestico where ?= id_electro";
	try {
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setInt(1, pIdElec);
		int rta = stmt.executeUpdate();
		
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
public int UpdateElect (Electrodomestico Electro)
{
	String SQLCons= "UPDATE Electrodomestico SET color_elect=? , consumo_elect=?, precio_elect=?, peso_elect=?, descripcion=? WHERE ?=id_electro";
	try{
		
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setString(1, Electro.getColor());
	stmt.setObject(2, Electro.getConsumoEnergetico(),java.sql.Types.CHAR);
	stmt.setFloat(3, Electro.getPreciobase());
	stmt.setFloat(4, Electro.getPeso());
	stmt.setString(5, Electro.getDescripcion());
	stmt.setInt(6, Electro.getIdElect());
	int rta = stmt.executeUpdate();
	}		
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Statement.RETURN_GENERATED_KEYS;
}


public ArrayList<Electrodomestico> GetAll()
{
ArrayList<Electrodomestico> ElectroDevArray = new ArrayList<Electrodomestico>();
	
	try {
		String SQLCons= "Select id_electro, descripcion, color_elect, consumo_elect, peso_elect, precio_elect FROM Electrodomestico WHERE (carga_lava is null AND Resol_tele is null) ORDER BY descripcion";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		ResultSet rta = stmt.executeQuery();
		 	while(rta.next())
					{		Electrodomestico ElectroDev = new Electrodomestico();
				 			ElectroDev.setDescripcion(rta.getString("descripcion"));
							ElectroDev.setColor(rta.getString("color_elect"));						
							ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
							ElectroDev.setIdElect(rta.getInt("id_electro")); 
							ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
							ElectroDev.setPeso(rta.getFloat("peso_elect"));
							ElectroDevArray.add(ElectroDev);
							
			}
	}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return ElectroDevArray;
}



public Electrodomestico GetOne(int pId)
{
	
	Electrodomestico ElectroDev = new Electrodomestico();
	try{
		
	 
	
	String SQLCons= "SELECT * FROM Electrodomestico WHERE Electrodomestico.id_electro=?";
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setInt(1, pId);		
	ResultSet rta = stmt.executeQuery();
	while(rta.next())
	{
					ElectroDev.setDescripcion(rta.getString("descripcion"));
				    ElectroDev.setColor(rta.getString("color_elect"));
					ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
					ElectroDev.setIdElect(rta.getInt("id_electro"));
					ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
					ElectroDev.setPeso(rta.getFloat("peso_elect"));
	}
				rta.close();
				stmt.close();
					
					
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
							}
	return ElectroDev;
}
public ArrayList<Electrodomestico> GetxConsumo (char pConsumo)
{
	
	ArrayList<Electrodomestico> ElectroDevArray = new ArrayList<Electrodomestico>();
	
	try {
		String SQLCons= "Select id_electro, descripcion, color_elect, consumo_elect, peso_elect, precio_elect FROM Electrodomestico WHERE (consumo_elect=? AND carga_lava is null AND Resol_tele is null) ORDER BY descripcion";
		ConexionBD conecta = new ConexionBD();
		conecta.OpenConection();
		PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
		stmt.setString(1, Character.toString(pConsumo));
		ResultSet rta = stmt.executeQuery();
		 	while(rta.next())
					{		Electrodomestico ElectroDev = new Electrodomestico();
				 			ElectroDev.setDescripcion(rta.getString("descripcion"));
							ElectroDev.setColor(rta.getString("color_elect"));						
							ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
							ElectroDev.setIdElect(rta.getInt("id_electro")); 
							ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
							ElectroDev.setPeso(rta.getFloat("peso_elect"));
							ElectroDevArray.add(ElectroDev);
							
			}
	}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return ElectroDevArray;
}
public ArrayList<Electrodomestico> GetxPrecios(float pMin, float pMax)
				{
	
				
				ArrayList<Electrodomestico> ElectroDevArray = new ArrayList<Electrodomestico>();
				try {
				String SQLCons= "Select id_electro, descripcion, color_elect, consumo_elect, peso_elect, precio_elect FROM Electrodomestico WHERE (precio_elect>=? AND precio_elect<=? )ORDER BY descripcion";
				ConexionBD conecta = new ConexionBD();
				conecta.OpenConection();
				PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
				stmt.setFloat(1, pMin);
				stmt.setFloat(2, pMax);
				ResultSet rta = stmt.executeQuery();
				
				while(rta.next())
				{
					Electrodomestico ElectroDev = new Electrodomestico();
										ElectroDev.setDescripcion(rta.getString("descripcion"));
										ElectroDev.setColor(rta.getString("color_elect"));							
										ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
										ElectroDev.setIdElect(rta.getInt("id_electro")); 
										ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
										ElectroDev.setPeso(rta.getFloat("peso_elect"));
										ElectroDevArray.add(ElectroDev);
					}
										} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							return ElectroDevArray;	}
						
public ArrayList<Electrodomestico> GetxPrecioYConsumo(float pMin, float pMax, char pConsumo)
	{
	
	
	ArrayList<Electrodomestico> ElectroDevArray = new ArrayList<Electrodomestico>();
	try {
	String SQLCons= "Select id_electro, descripcion, color_elect, consumo_elect, peso_elect, precio_elect FROM Electrodomestico WHERE (precio>=? AND precio<=? AND consumo_elect=? )ORDER BY descripcion";
	ConexionBD conecta = new ConexionBD();
	conecta.OpenConection();
	PreparedStatement stmt = conecta.Cone.prepareStatement(SQLCons);
	stmt.setFloat(1, pMin);
	stmt.setFloat(2, pMax);
	stmt.setString(3, Character.toString(pConsumo));
	ResultSet rta = stmt.executeQuery();
	
	while(rta.next())
	{
		Electrodomestico ElectroDev = new Electrodomestico();
							ElectroDev.setDescripcion(rta.getNString("descripcion"));
							ElectroDev.setColor(rta.getNString("color_elect"));							
							ElectroDev.setConsumoEnergetico(rta.getString("consumo_elect").charAt(0));
							ElectroDev.setIdElect(rta.getInt("id_electro")); 
							ElectroDev.setPreciobase(rta.getFloat("precio_elect"));
							ElectroDev.setPeso(rta.getFloat("peso_elect"));
							ElectroDevArray.add(ElectroDev);
		}
							} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				return ElectroDevArray;	}
}

	
	
	
	