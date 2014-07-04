package com.devsar.ejemplomundial;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Match {
	private String location;
	private String datetime;
	private Team home_team;
	private Team away_team;
	private int match_number;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public Team getHome_team() {
		return home_team;
	}
	public void setHome_team(Team home_team) {
		this.home_team = home_team;
	}
	public Team getAway_team() {
		return away_team;
	}
	public void setAway_team(Team away_team) {
		this.away_team = away_team;
	}
	
	public int getMatch_number() {
		return match_number;
	}
	public void setMatch_number(int match_number) {
		this.match_number = match_number;
	}
	
	public Match(int match_number,String location, String datetime, Team home_team, Team away_team){
		this.location = location;
		this.datetime = datetime;
		this.home_team = home_team;
		this.away_team = away_team;
		this.match_number = match_number;
	}
	
	public static Match dehydrateMatch(JSONObject jsonObject) throws JSONException{
		String location = jsonObject.getString("location");
		String datetime = jsonObject.getString("datetime");
		int match_number = jsonObject.getInt("match_number");
		Team home_team = Team.dehydrate(jsonObject.getJSONObject("home_team"));
		Team away_team = Team.dehydrate(jsonObject.getJSONObject("away_team"));
		return new Match(match_number, location,datetime,home_team,away_team);
	
	}
	
	public static List<Match> dehydrateMatchs(JSONArray jsonArray) throws JSONException{
		List<Match> result = new ArrayList<Match>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonMatch = (JSONObject) jsonArray.get(i);
			result.add(Match.dehydrateMatch(jsonMatch));
			
		}
		return result;
	}
	
}
