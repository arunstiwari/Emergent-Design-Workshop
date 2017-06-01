package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {
	
	@Autowired
	private Chip chip;
	
	@Autowired
	private ConfigFactory config;

	@Test
	public void getChipStatusAndEncryptWithPGP64AndSendViaTCPIP() throws Exception {
		Encrypt encryptor = config.getEncryptor(EncryptorType.PGP64);
		TCPIP transmittor = new TCPIP();
		chip.setEncryptor(encryptor);
		chip.setTransmittor(transmittor);
		String status = chip.getAndSendStatus();
		assertEquals("PGP64 Encryption",status);
	}

}
