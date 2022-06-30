package com.buk.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.buk.data.service.KosisApiService;

@SpringBootTest
class DataApplicationTests {
	@Autowired
	private KosisApiService kosisApiService;

	@Test
	void contextLoads() throws Exception {
		kosisApiService.kosisApi();
	}

}
