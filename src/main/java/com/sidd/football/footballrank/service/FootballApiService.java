package com.sidd.football.footballrank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidd.football.footballrank.config.AppConfig;
import com.sidd.football.footballrank.delegate.FootballApiLeagueDetailsDelegate;
import com.sidd.football.footballrank.delegate.FootballApiStandingsDelegate;
import com.sidd.football.footballrank.model.FootballApiRequestParam;
import com.sidd.football.footballrank.model.FootballApiResponse;
import com.sidd.football.footballrank.model.LeagueDetails;

@Service
public class FootballApiService {
	
	@Autowired
	private AppConfig appConfig;
	
	@Autowired
	private FootballApiStandingsDelegate footballApiDelegate;
	
	@Autowired
	private FootballApiLeagueDetailsDelegate leagueDetailsDelegate;

	public List<FootballApiResponse> getFootballServiceResponse(FootballApiRequestParam footballApiRequest) {
		List<FootballApiResponse> standingsResponse = new ArrayList<>();
		List<FootballApiResponse> responseFiltered =  new ArrayList<>();
		String leagueUrl =  appConfig.footballApiUrl + "?action=get_leagues&APIkey=" + appConfig.apiKey ;
		
		List<LeagueDetails> leagueDetailList = leagueDetailsDelegate.getLeagueDetails(leagueUrl);
		
		if(leagueDetailList!= null) {
			List<LeagueDetails> matchList = new ArrayList<LeagueDetails>();
			List<LeagueDetails> matchList1 = new ArrayList<LeagueDetails>();
			List<LeagueDetails> matchList2 = new ArrayList<LeagueDetails>();
			if(footballApiRequest.getCountryName()!=null) {
				matchList1 = leagueDetailList.stream().filter(leaguedetail -> leaguedetail.getCountryName().equalsIgnoreCase(footballApiRequest.getCountryName()))
						.collect(Collectors.toList());
				matchList = matchList1;
			}
			
			if(footballApiRequest.getLeagueName()!=null) {
				matchList2 = matchList1.stream().filter(leaguedetail -> leaguedetail.getLeagueName().equalsIgnoreCase(footballApiRequest.getLeagueName()))
						.collect(Collectors.toList());
				matchList = matchList2;
			}
		
			if(!matchList.isEmpty()) {
				String url = appConfig.footballApiUrl + "?action=get_standings&APIkey=" + appConfig.apiKey + "&league_id=" + matchList.get(0).getLeagueId() ;

				standingsResponse = footballApiDelegate.getLeagueStandings(url);
			}
			
			if(footballApiRequest.getTeamName()!=null) {
				responseFiltered = standingsResponse.stream().filter(standings -> standings.getTeamName().equalsIgnoreCase(footballApiRequest.getTeamName()))
						.collect(Collectors.toList());
				standingsResponse = responseFiltered;
			}

		}
		return standingsResponse;
	}
}
