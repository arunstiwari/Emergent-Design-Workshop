package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Chip {

	private String status;
	private PGP64Encryptor encryptor;
	private TCPIP transmittor;

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
	
	public void setEncryptor(PGP64Encryptor encryptor) {
		this.encryptor = encryptor;
	}
	
	public void setTransmittor(TCPIP transmittor) {
		this.transmittor = transmittor;
	}

}
