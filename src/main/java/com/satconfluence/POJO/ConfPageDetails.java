package com.satconfluence.POJO;

public class ConfPageDetails {
	
	private String spaceKey;
	private String query;
	public String getSpaceKey() {
		return spaceKey;
	}
	public void setSpaceKey(String spaceKey) {
		this.spaceKey = spaceKey;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	@Override
	public String toString() {
		return "ConfPageDetails [spaceKey=" + spaceKey + ", query=" + query + "]";
	}
	

}
