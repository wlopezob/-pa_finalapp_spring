package com.example.appDemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appDemo.models.Token;
import com.example.appDemo.repository.ITokenRepository;

@Service
public class TokenService implements ITokenService {

	@Autowired
	ITokenRepository tokenRepository;
	
	@Override
	public Token Guardar(Token token) {
		this.tokenRepository.save(token);
		return token;
	}

	@Override
	public Token findByPublico(String publico) {
		return this.tokenRepository.findByPublico(publico);
	}

	@Override
	public Token findById(Long id) {
		return this.tokenRepository.findById(id).orElse(new Token());
	}

}
