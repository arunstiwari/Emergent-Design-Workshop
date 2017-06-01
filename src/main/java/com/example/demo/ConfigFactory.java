package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class ConfigFactory {

	public Encrypt getEncryptor(EncryptorType type) {
		return new PGP64Encryptor();
	}

}
