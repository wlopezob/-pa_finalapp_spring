package com.example.appDemo.criptoMensaje;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import com.example.appDemo.models.Token;

public class RSAKeyGenerator {

	private PrivateKey privateKey;
	private PublicKey publicKey;

	public RSAKeyGenerator() throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024);
		KeyPair pair = keyGen.generateKeyPair();
		this.privateKey = pair.getPrivate();
		this.publicKey = pair.getPublic();
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}
	public Token generarToken() throws NoSuchAlgorithmException, IOException {
		RSAKeyGenerator keyPairGenerator = new RSAKeyGenerator();
		Token token = new Token();
		token.setPublico(Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded()));
		token.setPrivado(Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded()));
		token.setEjecutado(false);
		return token;
	}

}
