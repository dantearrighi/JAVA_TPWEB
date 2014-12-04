package negocio;

import java.util.ArrayList;

import datos.CatalogoElectrodomestico;
import datos.CatalogoLavarropas;
import datos.CatalogoTelevisor;
import models.*;

public class ControladorLavarropasNegocio extends ControladorElectrodomesticoNegocio
{
	CatalogoLavarropas catLava = new CatalogoLavarropas();
	
			protected float precioFinal(char pConsumo, float pPeso, float pPrecioBase, float pCarga)
			{
				float PrecFinal = super.precioFinal(pConsumo, pPeso, pPrecioBase);
				
				
				if(30<pCarga)
				{
					PrecFinal+=50;
				}
							
				
				return PrecFinal;
			}
			
			public int AddLavarropa(float pPrecio,float pPeso, String pColor, char pConsumo, String pDescripcion, float pCarga)
			{
					
				

				 String pColorOK = this.comprobarColor(pColor);
				 char pConsumoOK = this.comprobarConsumoEnergetico((char)pConsumo);
				 float pPrecioOK = this.precioFinal(pConsumo, pPeso, pPrecio);
				  
								 
				 if(pPrecio==0 && pPeso==0 && pConsumo ==' '  && pColor=="")
				 {
						 
					 Lavarropas LavaModel = new Lavarropas();
				 int iDElectro = catLava.AddElectro(LavaModel);
				 
				 return iDElectro;
				 }else if(pPrecio!=0 && pPeso!=0 && pConsumo ==' '  && pColor=="")
				 {
					 Lavarropas LavaModel = new Lavarropas(pPrecioOK, pPeso);
					 int iDElectro = catLava.AddElectro(LavaModel);
					 
					 return iDElectro;}
				 else
				 {
					 Lavarropas LavaModel = new Lavarropas(pPrecioOK, pPeso, pConsumoOK, pColorOK, pCarga, pDescripcion);
					 int iDElectro = catLava.AddElectro(LavaModel);
					 
					 return iDElectro;
				 }
				
			}
	
			public void DeleteLavarropa(int idElectro)
			{
							
				catLava.DeleteElectro(idElectro);
				
			}

			public Lavarropas getOne(int idElectro)
			{
				Lavarropas LavaModel = new Lavarropas();
				LavaModel = catLava.GetOne(idElectro);
				return LavaModel;
				
			}
			
			public boolean isLava (int idElectro)
			{

				Lavarropas LavaModel = new Lavarropas();
				LavaModel = catLava.GetOne(idElectro);
				float carga = 0;
				if(Float.compare(LavaModel.getCarga(), carga)==0) {
					return false;
				} else {
					return true;
				}	
				
				
			}
			
			public void UpdateElectro(int pIdLava, float pPrecio, float pPeso, String pColor, char pConsumo,float pCarga, String pDescripcion)
			{
				/*String pColorOk = this.comprobarColor(pColor);*/
				char pConsumoOk = this.comprobarConsumoEnergetico(pConsumo);
				float pPrecioOk = this.precioFinal(pConsumo, pPeso, pPrecio);
				Lavarropas LavaModel = new Lavarropas(pPrecioOk, pPeso, pConsumoOk, pColor, pCarga, pDescripcion);
				LavaModel.setIdElect(pIdLava);
				catLava.UpdateElect(LavaModel);
				
			}

			public ArrayList<Lavarropas> GetAllLa()
			{
		
			
			ArrayList<Lavarropas> AllElectroDat = new ArrayList<Lavarropas>();
			AllElectroDat = catLava.GetAllLava();
			
			return AllElectroDat;
			
			}
			
			public ArrayList<Lavarropas> GetXConsumoLava(char cConsumo)
			{
		
			
			ArrayList<Lavarropas> AllElectroDat = new ArrayList<Lavarropas>();
			AllElectroDat = catLava.GetXConsumoLava(cConsumo);
			
			return AllElectroDat;
			
			}

			public ArrayList<Lavarropas> GetxPreciosLava(float pMin, float pMax)
		{

		
		ArrayList<Lavarropas> AllElectroDat = new ArrayList<Lavarropas>();
		AllElectroDat = catLava.GetXPreciosLava(pMin, pMax);
		
		return AllElectroDat;
		
		}
			
			public ArrayList<Lavarropas> GetxConsumoyPrecLava(float pMin, float pMax, char cConsumo)
		{

		
		ArrayList<Lavarropas> AllElectroDat = new ArrayList<Lavarropas>();
		AllElectroDat = catLava.GetxPrecioYConsumoLava(pMin, pMax, cConsumo);
		
		return AllElectroDat;
		
		}

}
