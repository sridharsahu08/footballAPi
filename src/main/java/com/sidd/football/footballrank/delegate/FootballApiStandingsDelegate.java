package com.sidd.football.footballrank.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sidd.football.footballrank.model.FootballApiResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FootballApiStandingsDelegate {
	

	public List<FootballApiResponse> getLeagueStandings(String url) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			log.info("uri : " + url);
		ResponseEntity<List<FootballApiResponse>> footballApiResponse = restTemplate.exchange(url, HttpMethod.GET, null,new ParameterizedTypeReference<List<FootballApiResponse>>() {});
		return footballApiResponse.getBody();
		} catch (Exception ex) {
			log.error("Exception calling Client : " + ex.getMessage() + url);
			return null;
		}
	}
}
