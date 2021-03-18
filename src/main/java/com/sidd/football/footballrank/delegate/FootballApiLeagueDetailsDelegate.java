package com.sidd.football.footballrank.delegate;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sidd.football.footballrank.model.LeagueDetails;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FootballApiLeagueDetailsDelegate {


	
	public List<LeagueDetails> getLeagueDetails(String url) {
		try {
			log.info("uri : " + url);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<LeagueDetails>> leagueDetailsApiResponse = restTemplate.exchange(url, HttpMethod.GET, null,  new ParameterizedTypeReference<List<LeagueDetails>>() {});
		ObjectMapper obj = new ObjectMapper();
//		log.info(obj.writeValueAsString(leagueDetailsApiResponse.getBody()));
		
		return leagueDetailsApiResponse.getBody();
		} catch (Exception ex) {
			log.error("Exception calling Client : " + ex.getMessage() + url);
			return null;
		}
	}
}