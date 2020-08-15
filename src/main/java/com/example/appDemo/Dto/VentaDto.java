package com.example.appDemo.Dto;

public class VentaDto {

	private String cuentaBancaria;
	private String precio;
	
	public VentaDto(String cuentaBancaria, String precio) {
		this.cuentaBancaria = cuentaBancaria;
		this.precio = precio;
	}
	public VentaDto() {
		
	}

	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	
}
