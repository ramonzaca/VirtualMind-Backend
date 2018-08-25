package com.restful.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.backend.cotizacion.*;

/**
 * Controlador de cotizaciones
 * @author Agustín Dye
 */

@RestController
public class CotizacionController 
{
	private Cotizacion cotizador;
	
	/**
	 * DCotización de las diferentes monedas.
	 * @param MONEDA Moneda a cotizar en AR$.
	 * @return Cotización en AR$ de la MONEDA ingresada como parámetro.
	 */
	@GetMapping("/{MONEDA}/quote")
	public String cotizar(@PathVariable(value = "MONEDA") String MONEDA)
	{
		if(MONEDA.equals("Dolar"))
		{
			cotizador = new CotizacionDolar();
		}
		else if(MONEDA.equals("Pesos"))
		{
			cotizador = new CotizacionPeso();
		}
		else if(MONEDA.equals("Real"))
		{
			cotizador = new CotizacionReal();
		}
		
		return cotizador.cotizar();
	}
}
