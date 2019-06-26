package com.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



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
	
	

	
}
