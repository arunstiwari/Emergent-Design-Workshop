package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {
	
	private Chip chip;
	
	@Autowired
	private ConfigFactory config;
	
	private Encrypt NO_ENCRYPTOR;

	private Transmit EMAIL_TRANSMITTOR;

	private Encrypt PGP128;

	private Encrypt PGP64;

	private Transmit TCPIP_TRANSMITTOR;
	
	@Before
	public void setup(){
		EncryptorType noEncryption = EncryptorType.NO_ENCRYPTION;
		TransmitType email = TransmitType.EMAIL;
		NO_ENCRYPTOR = config.getEncryptor(noEncryption);
		PGP128 = config.getEncryptor(EncryptorType.PGP128);
		PGP64 = config.getEncryptor(EncryptorType.PGP64);
		EMAIL_TRANSMITTOR = config.getTransmittor(email);
		TCPIP_TRANSMITTOR = config.getTransmittor(TransmitType.TCPIP);
	}

	@Test
	public void getChipStatusAndEncryptWithPGP64AndSendViaTCPIP() throws Exception {
		chip = getChip(PGP64,TCPIP_TRANSMITTOR);
		String status = new Hardware(chip).getAndSendStatus();
		assertEquals("PGP64 Encryption",status);
	}
	
	@Test
	public void getChipStatusAndEncryptWithPGP128AndSendViaTCPIP() throws Exception {
		chip = getChip(PGP128, TCPIP_TRANSMITTOR);
		String status = new Hardware(chip).getAndSendStatus();
		assertEquals("PGP128 Encryption",status);
	}
	
	@Test
	public void getChipStatusAndEncryptWithNoEncryptionAndSendViaTCPIP() throws Exception {
		chip = getChip(NO_ENCRYPTOR, TCPIP_TRANSMITTOR);
		String status = new Hardware(chip).getAndSendStatus();
		assertEquals("No Encryption",status);
	}
	
	@Test
	public void getChipStatusAndEncryptWithPGP64AndSendViaEmail() throws Exception {
		Chip chip = getChip(PGP64,EMAIL_TRANSMITTOR);
		String status = new Hardware(chip).getAndSendStatus();
		assertEquals("PGP64 Encryption",status);
	}
	
	@Test
	public void getChipStatusAndEncryptWithPGP128AndSendViaEmail() throws Exception {
		Chip chip = getChip(PGP128,EMAIL_TRANSMITTOR);
		String status = new Hardware(chip).getAndSendStatus();
		assertEquals("PGP128 Encryption",status);
	}
	
	@Test
	public void getChipStatusAndEncryptWithNoEncryptionAndSendViaEmail() throws Exception {
		Chip chip = getChip(NO_ENCRYPTOR, EMAIL_TRANSMITTOR);
		String status = new Hardware(chip).getAndSendStatus();
		assertEquals("No Encryption",status);
	}

	private Chip getChip(Encrypt encryptor, Transmit transmittor) {
		Chip chip = new Chip();
		chip.setEncryptor(encryptor);
		chip.setTransmittor(transmittor);
		return chip;
	}

}
