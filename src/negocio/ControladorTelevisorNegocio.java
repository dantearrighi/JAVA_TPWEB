package negocio;

import java.util.ArrayList;

import datos.CatalogoElectrodomestico;
import datos.CatalogoLavarropas;
import datos.CatalogoTelevisor;
import models.Televisor;

public class ControladorTelevisorNegocio extends ControladorElectrodomesticoNegocio{
	
	private CatalogoTelevisor catTele = new CatalogoTelevisor();

	protected float precioFinal(char pConsumo, float pPeso, float pPrecioBase, int pPulgadas, boolean pSintoniz)
	{
		float precFinal = super.precioFinal(pConsumo, pPeso, pPrecioBase);
				if(pPulgadas>40)
				{
					precFinal= precFinal*(13/10);
					
				}
				
				if(pSintoniz==true)
				{
					precFinal+=50;	
				}
	return precFinal;
	}
	
	public int AddTelevisor(float pPrecio,float pPeso, String pColor, char pConsumo, String pDescripcion, int pResolucion, boolean pSintoniz)
	{
		

		 String pColorOK = this.comprobarColor(pColor);
		 char pConsumoOK = this.comprobarConsumoEnergetico((char)pConsumo);
		 float pPrecioOK = this.precioFinal(pConsumo, pPeso, pPrecio);
		 
		 if(pPrecio==0 && pPeso==0 && pConsumo ==' '  && pColor=="")
		 {
		
			 Televisor modelTele = new Televisor();
			 int iDElectro = catTele.AddTelev(modelTele);
		 
		 return iDElectro;
		 }
		 
		 else if(pPrecio!=0 && pPeso!=0 && pConsumo ==' '  && pColor=="")
		 {
			 Televisor modelTele = new Televisor(pPrecioOK, pPeso);
			 int iDElectro = catTele.AddTelev(modelTele);
			 
			 return iDElectro;
		 } else
		 {
			 Televisor modelTele = new Televisor(pPrecioOK, pPeso, pConsumoOK, pColorOK, pSintoniz, pResolucion);
			 int iDElectro = catTele.AddTelev(modelTele);
			 
			 return iDElectro;
		 }
		 
	}
	
	public Televisor getOne(int idElectro)
	{
		
		Televisor TeleModel = new Televisor();
		TeleModel= catTele.GetOne(idElectro);
		return TeleModel;
		
	}

	public boolean isTele (int idElectro)
	{
		Televisor TeleModel = new Televisor();
		TeleModel = catTele.GetOne(idElectro);
		if(Integer.compare(TeleModel.getPulgadas(), 0)==0) {
			return false;
		} else {
			return true;
		}	
		
		
	}

	public void DeleteTelev(int idElectro)
	{
			
		catTele.DeleteTelev(idElectro);
		
	}

	public Televisor UpdateElectro(int idTv, float pPrecio, float pPeso, String pColor, char pConsumo, int pResolucion, boolean pSintoniz, String pDescripcion)
	{
		String pColorOk = this.comprobarColor(pColor);
		char pConsumoOk = this.comprobarConsumoEnergetico(pConsumo);
		float pPrecioOk = this.precioFinal(pConsumo, pPeso, pPrecio);
		Televisor TeleModel = new Televisor(pPrecioOk, pPeso, pConsumoOk, pColorOk, pSintoniz, pResolucion);
		TeleModel.setIdElect(idTv);
		catTele.UpdateTelev(TeleModel);
		return TeleModel;
	}
	
	public ArrayList<Televisor> GetAllTe()
	{

	
	ArrayList<Televisor> AllElectroDat = new ArrayList<Televisor>();
	AllElectroDat = catTele.GetAllTele();
	return AllElectroDat;
	
	}
	
	public ArrayList<Televisor> GetXConsumoTele(char cConsumo)
	{

	
	ArrayList<Televisor> AllElectroDat = new ArrayList<Televisor>();
	AllElectroDat = catTele.GetXConsumoTele(cConsumo);
	
	return AllElectroDat;
	
	}

	
	
	public ArrayList<Televisor> GetxPreciosTele(float pMin, float pMax)
{

	
	ArrayList<Televisor> AllElectroDat = new ArrayList<Televisor>();
	AllElectroDat = catTele.GetXPreciosTele(pMin, pMax);
	
	return AllElectroDat;

}
	
	public ArrayList<Televisor> GetxConsumoyPrecTele(float pMin, float pMax, char cConsumo)
{

	
	ArrayList<Televisor> AllElectroDat = new ArrayList<Televisor>();
	AllElectroDat = catTele.GetxPrecioYConsumoTele(pMin, pMax, cConsumo);
	
	
	return AllElectroDat;

}
}
