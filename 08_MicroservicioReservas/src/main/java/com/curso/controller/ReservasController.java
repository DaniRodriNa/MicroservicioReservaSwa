package com.curso.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.ReservaConPlazas;
import com.curso.service.ReservasService;

import io.swagger.annotations.ApiOperation;
/**
 * Clase controlador: ReservasController
 * @author Daniel Rodriguez
 * @version 1.0.0 02-06-2023
 */

@RestController
public class ReservasController {
	@Autowired
	ReservasService service;
	/**
	 * GetMapping que devuelve las reservas
	 * @return Lista de reservas almacenadas
	 */
	@ApiOperation(value="Devuelve las listas de las reservas")
	@GetMapping(value="reservas")
	public List<String> listaReser(){
		return service.listaReservas();
	}
	/**
	 * PostMapping que hace reservas<s
	 * @param reserva Parametro de objeto ReservasConPlazas que recoge los valores del Body de JSON
	 */
	@ApiOperation(value="Registra una reserva")
	@PostMapping(value="reserva",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void reservar(@RequestBody ReservaConPlazas reserva) {
		service.reservar(reserva);
	}
}
