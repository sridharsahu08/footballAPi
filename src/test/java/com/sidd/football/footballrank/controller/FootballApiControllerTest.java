package com.sidd.football.footballrank.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sidd.football.footballrank.model.StandingsResponse;
import com.sidd.football.footballrank.service.FootballApiService;
import com.sidd.football.footballrank.util.FileConversionToPojo;

@RunWith(MockitoJUnitRunnerhttp://marketplace.eclipse.org/marketplace-client-intro?mpc_install=1294474.class)
//@WebMvcTest(FootballApiController.class)
public class FootballApiControllerTest {
	
	@InjectMocks
	private FootballApiController mockFootballApiController;
	
	@Mock
	private FootballApiService footballApiService;
	
	@Autowired
	private MockMvc mockMvc;
	

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(mockFootballApiController).build();
	}
	
	@Test
	public void testRequest() {
		StandingsResponse standingsResponse = new StandingsResponse();
		String str;
//		JsonParser jsonParse = 
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
		    standingsResponse = objectMapper.readValue(FileConversionToPojo.convertToString("response/controllerResponse.json"), StandingsResponse.class);
		    System.out.println(standingsResponse.getFootballApiResponse().get(0).getCountryName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		assertNotNull(standingsResponse);
	}

}
