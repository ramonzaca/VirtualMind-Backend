package com.restful.backend.cotizacion;

/**
 * Implementación cotización dolar
 * @author Agustín Dye
 */

import org.json.JSONArray;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CotizacionDolar implements Cotizacion
{
	public String cotizar()
	{		
		JSONArray response;
		try {
			response = Unirest.get("https://www.bancoprovincia.com.ar/Principal/Dolar").asJson().getBody().getArray();
			return ("Compra: "+response.getString(0)+ System.lineSeparator() +"Venta: "+response.getString(1)+ System.lineSeparator() +response.getString(2));
		} catch (UnirestException e) {
			e.printStackTrace();
			return ("\"https://www.bancoprovincia.com.ar/Principal/Dolar\" no se encuentra disponible.");
		}		
	}
}
