package com.example.demo;

public class Email implements Transmit {

	@Override
	public void transmit(String status) {
		System.out.println("Transmitted via Email");
	}

}
