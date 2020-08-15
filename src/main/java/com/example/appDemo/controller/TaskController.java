package com.example.appDemo.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appDemo.Dto.ResultDto;
import com.example.appDemo.Dto.VentaDto;
import com.example.appDemo.criptoMensaje.RSAKeyGenerator;
import com.example.appDemo.criptoMensaje.RSATool;
import com.example.appDemo.models.Token;
import com.example.appDemo.models.Venta;
import com.example.appDemo.services.ITokenService;
import com.example.appDemo.services.IVentaService;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {

	@Autowired
	ITokenService tokenService;
	
	@Autowired
	IVentaService ventaService;
	
	@PostMapping("/guardar")
	public ResponseEntity<ResultDto> guardar(@RequestBody VentaDto venta, HttpServletRequest request) throws NoSuchAlgorithmException, Exception{
		ResultDto resultDto = new ResultDto();
		RSAKeyGenerator rsaKeyGenerator = new RSAKeyGenerator();
		Token token = rsaKeyGenerator.generarToken();
		tokenService.Guardar(token);
		
		Venta mventa = new Venta();
		mventa.setTokenId(token.getId());
		
		String cuentaBancaria = Base64.getEncoder().encodeToString(RSATool.encrypt(venta.getCuentaBancaria(), token.getPublico()));
		String precio = Base64.getEncoder().encodeToString(RSATool.encrypt(venta.getPrecio(), token.getPublico()));
		
		mventa.setCuentaBancaria(cuentaBancaria);
		mventa.setPrecio(precio);
		this.ventaService.guardar(mventa);
		
		resultDto.setExito(true);
		resultDto.setMensaje("Venta exitosa");
		
		return ResponseEntity.ok(resultDto);
		
	}
	@GetMapping("/listar")
	public ResponseEntity<List<VentaDto>> listar() throws NoSuchAlgorithmException, Exception{
		List<Venta> lista = this.ventaService.listar();
		List<VentaDto> listDto = lista.stream().map(item -> {
			String cuentaBancaria = "";
			String precio = "";
			try {
				Token token = tokenService.findById(item.getTokenId());
				cuentaBancaria = RSATool.decrypt(item.getCuentaBancaria(), token.getPrivado());
				precio = RSATool.decrypt(item.getPrecio(), token.getPrivado());
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return new VentaDto(cuentaBancaria, precio);
		}).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}
}
