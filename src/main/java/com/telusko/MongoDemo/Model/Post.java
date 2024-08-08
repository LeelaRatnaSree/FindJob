package com.telusko.MongoDemo.Model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "JobList")
public class Post {
	

	private String profile;
	private String desc;
	private int exp;
	private String tech[];
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String[] getTech() {
		return tech;
	}
	public void setTech(String[] tech) {
		this.tech = tech;
	}
	public Post(String profile, String desc, int exp, String[] tech) {
		super();
		this.profile = profile;
		this.desc = desc;
		this.exp = exp;
		this.tech = tech;
	}
	
	

}
