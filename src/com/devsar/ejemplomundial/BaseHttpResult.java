package com.devsar.ejemplomundial;

import java.util.List;

public class BaseHttpResult {

	private Boolean success;
	private String message;
	private List<Match> matchs;
	
	public BaseHttpResult(Boolean success, String message, List<Match> matchs){
		this.success = success;
		this.message = message;
		this.matchs = matchs;
	}
	
	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}