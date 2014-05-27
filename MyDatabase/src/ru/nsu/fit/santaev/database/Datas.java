package ru.nsu.fit.santaev.database;

import java.util.HashMap;
import java.util.Map;

public class Datas {

	private Map<String, Integer> contructionTypes = new HashMap<String, Integer>();
	private Map<String, Integer> sportTypes = new HashMap<String, Integer>();
	private Map<String, Integer> coachs = new HashMap<String, Integer>();
	private Map<String, Integer> sportsmens = new HashMap<String, Integer>();
	private Map<String, Integer> contests = new HashMap<String, Integer>();
	private Map<String, Integer> sportConstr = new HashMap<String, Integer>();
	//private Map<Integer, String> contructionTypes = new HashMap<Integer, String>();

	public Map<String, Integer> getContructionTypes() {
		return contructionTypes;
	}

	public void setContructionTypes(Map<String, Integer> contructionTypes) {
		this.contructionTypes = contructionTypes;
	}

	public Map<String, Integer> getSportTypes() {
		return sportTypes;
	}

	public void setSportTypes(Map<String, Integer> sportTypes) {
		this.sportTypes = sportTypes;
	}

	public Map<String, Integer> getCoachs() {
		return coachs;
	}

	public void setCoachs(Map<String, Integer> coachs) {
		this.coachs = coachs;
	}

	public Map<String, Integer> getSportsmens() {
		return sportsmens;
	}

	public void setSportsmens(Map<String, Integer> sportsmens) {
		this.sportsmens = sportsmens;
	}

	public Map<String, Integer> getContests() {
		return contests;
	}

	public void setContests(Map<String, Integer> contests) {
		this.contests = contests;
	}

	public Map<String, Integer> getSportConstr() {
		return sportConstr;
	}

	public void setSportConstr(Map<String, Integer> sportConstr) {
		this.sportConstr = sportConstr;
	}
	
}
