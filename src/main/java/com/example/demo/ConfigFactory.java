package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class ConfigFactory {

	public Encrypt getEncryptor(EncryptorType type) {
		switch(type){
			case PGP64:
				return new PGP64Encryptor();
			case PGP128:
				return new PGP128Encryptor();
			case NO_ENCRYPTION:
				return new NOEncryptor();
			default:
				return null;
		}
		
		
	}

	public Transmit getTransmittor(TransmitType type) {
		switch(type){
			case TCPIP:
				return new TCPIP();
			case EMAIL:
				return new Email();
			default:
				return null;
		}
		
	}

}
