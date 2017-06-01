package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Chip {

	private String status;
	private Encrypt encryptor;
	private Transmit transmittor;

	public String getAndSendStatus() {
		encrypt();
		transmit();
		return status;
	}

	private void transmit() {
		transmittor.transmit(status);
	}

	private void encrypt() {
		this.status = encryptor.encrypt(status);
	}
	
	public void setEncryptor(Encrypt encryptor) {
		this.encryptor = encryptor;
	}
	
	public void setTransmittor(Transmit transmittor) {
		this.transmittor = transmittor;
	}

}
