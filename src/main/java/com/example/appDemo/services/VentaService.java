package com.example.appDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appDemo.models.Venta;
import com.example.appDemo.repository.IVentaRepository;

@Service
public class VentaService implements IVentaService {

	@Autowired
	IVentaRepository ventaRepository;
	
	@Override
	public Venta guardar(Venta venta) {
		this.ventaRepository.save(venta);
		return venta;
	}

	@Override
	public List<Venta> listar() {
		return   (List<Venta>) this.ventaRepository.findAll();
	}

}
