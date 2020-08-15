package com.example.appDemo.services;

import com.example.appDemo.models.Token;

public interface ITokenService {
	Token Guardar(Token token);
	Token findByPublico(String publico);
	Token findById(Long id);
}
