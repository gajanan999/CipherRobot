package com.cipher;

import static org.junit.Assert.assertEquals;

import java.util.Base64;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cipher.vo.EncryptDecryptRequest;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MainCipherControllerTest extends AbstractTest {


	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	/**
	 * This is the One Unit Test case to see the the getData Functionality works
	 * @throws Exception
	 */
	@Test
	public void getDataEntitiesTest() throws Exception {
		String uri = "/api/getData";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	/*
	 * @Test public void createProduct() throws Exception { String uri =
	 * "/api/getEncyption"; EncryptDecryptRequest request = new
	 * EncryptDecryptRequest(); request.setAlgorithm("AES");
	 * request.setKey("gajanan"); request.setText("Hello"); String token = new
	 * String(Base64.getEncoder().encode( ("admin" + ":" + "password").getBytes()));
	 * 
	 * String inputJson = super.mapToJson(request); MvcResult mvcResult =
	 * mvc.perform(MockMvcRequestBuilders.post(uri).header("Authorization", "Basic "
	 * + token)
	 * .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(
	 * );
	 * 
	 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
	 * String content = mvcResult.getResponse().getContentAsString();
	 * assertEquals(content,
	 * "Text Successfully encrypted and added to the database"); }
	 */

	
}
