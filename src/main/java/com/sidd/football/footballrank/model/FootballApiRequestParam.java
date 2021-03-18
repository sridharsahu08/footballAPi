package com.sidd.football.footballrank.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FootballApiRequestParam {

	private String countryName;
	private String leagueName;
	private String teamName;
	private String overallLeaguePosition;
}
