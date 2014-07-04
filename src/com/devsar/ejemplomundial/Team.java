package com.devsar.ejemplomundial;

import org.json.JSONException;
import org.json.JSONObject;

public class Team {
	private String country;
	private String code;
	private int goals;
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	
	public Team(String country, String code, int goals){
		this.country = country;
		this.code = code;
		this.goals = goals;
	}
	
	public static Team dehydrate(JSONObject jsonObject){
		
		String country="";
		String code ="";
		int goals =0;
		
		try {
			country = jsonObject.getString("country");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			code = jsonObject.getString("code");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			goals = jsonObject.getInt("goals");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Team(country,code,goals);
	}
	
}
