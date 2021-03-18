package com.sidd.football.footballrank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sidd.football.footballrank.model.FootballApiRequestParam;
import com.sidd.football.footballrank.model.FootballApiResponse;
import com.sidd.football.footballrank.model.StandingsResponse;
import com.sidd.football.footballrank.service.FootballApiService;

@RestController
public class FootballApiController {
	
	@Autowired
	private FootballApiService footballApiService;
	
	@GetMapping(value="/footballApi")
	public ResponseEntity<?> getFootBaallApiResponse(@RequestParam(value="countryName", required = false) String countryName, 
			@RequestParam(value="leagueName", required = false) String leagueName, 
			@RequestParam(value="teamName", required = false) String teamName) {
		
		FootballApiRequestParam footballApiRequestParam = new FootballApiRequestParam();
		footballApiRequestParam.setCountryName(countryName);
		footballApiRequestParam.setLeagueName(leagueName);
		footballApiRequestParam.setTeamName(teamName);
		
		List<FootballApiResponse>  response = footballApiService.getFootballServiceResponse(footballApiRequestParam);
		StandingsResponse standingsResponse = new StandingsResponse();
		if(response.isEmpty()) {
			standingsResponse.setErrorCode(HttpStatus.NOT_FOUND.toString());
			standingsResponse.setErrorMessage("No Matching standings found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standingsResponse);
		} else {
			standingsResponse.setFootballApiResponse(response);
			return ResponseEntity.ok(standingsResponse);
		}
	}
	
}
