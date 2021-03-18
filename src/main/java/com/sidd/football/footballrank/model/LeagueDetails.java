package com.sidd.football.footballrank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeagueDetails {

	@JsonProperty("country_id")
	private String countryId;
	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("league_id")
	private String leagueId;
	@JsonProperty("league_name")
	private String leagueName;
	
}
