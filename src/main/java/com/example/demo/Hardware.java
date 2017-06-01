package com.example.demo;

public class Hardware {

	private IHardware hardware;

	public Hardware(IHardware hardware) {
		this.hardware = hardware;
	}

	public String getAndSendStatus() {
		return hardware.getAndSendStatus();
	}

}