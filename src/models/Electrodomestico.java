package models;

public class Electrodomestico {

	/*Attributes of the laundry machine*/
	private float preciobase;
	private String color ;
	protected char consumoEnergetico ;
	private float peso; 
	/*public enum consumo {A,B,C,D,E,F};*/ 
	private int IdElect;
	private String descripcion;
	
	private static String colorDefault = "BLANCO";
	private static float precioDefault = 10;
	private static float pesoDefault= 5;
	private static char consumoDefault = 'F';
	
	
	
	/*Fin variables*/

	public float getPreciobase() {
		return preciobase;
	}
	public void setPreciobase(float preciobase) {
		this.preciobase = preciobase;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}
	public void setConsumoEnergetico(char consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	/*Default constructor*/
	public Electrodomestico()
	{
		this.setColor(colorDefault);
		this.setConsumoEnergetico(consumoDefault);
		this.setPeso(pesoDefault);
		this.setPreciobase(precioDefault);
		this.setDescripcion(descripcion);
	}
	public int getIdElect() {
		return IdElect;
	}
	public void setIdElect(int idElect) {
		IdElect = idElect;
	}
	/* Constructor whit price y weight*/
	public Electrodomestico(float pPrecio, float pPeso)	
	{
	this();
	this.setPreciobase(pPrecio);
	this.setPeso(pPeso);
	}
	
	/*Constructor all attributes*/
	public Electrodomestico(float pPrecio, float pPeso,String pColor, char pConsumo, String pDescripcion)
	{	this();
		this.setDescripcion(pDescripcion);
		this.setColor(pColor);
		this.setConsumoEnergetico(pConsumo);
		this.setPeso(pPeso);
		this.setPreciobase(pPrecio);
	}

	
}
