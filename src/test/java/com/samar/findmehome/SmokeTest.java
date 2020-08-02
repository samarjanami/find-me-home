package com.samar.findmehome;

import com.samar.findmehome.controller.ViewController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTest {

	@Autowired
	private ViewController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
