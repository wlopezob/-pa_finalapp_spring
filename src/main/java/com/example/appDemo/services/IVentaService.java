package com.example.appDemo.services;

import java.util.List;

import com.example.appDemo.models.Venta;

public interface IVentaService {
	public Venta guardar(Venta venta);
	public List<Venta> listar();
}
