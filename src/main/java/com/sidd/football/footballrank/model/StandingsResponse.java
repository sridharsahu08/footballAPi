package com.sidd.football.footballrank.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class StandingsResponse {
	
	private List<FootballApiResponse> footballApiResponse;
	
	private String errorMessage;
	
	private String errorCode;

}
