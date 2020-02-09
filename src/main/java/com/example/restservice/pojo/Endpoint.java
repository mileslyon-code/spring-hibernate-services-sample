package com.example.restservice.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Endpoint")
public class Endpoint {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "ServiceID")
    private int serviceId;
    @Column(name = "URL")
    private String url;
    @Column(name = "CRUDVerb")
    private String verb;
    @Column(name = "OAuth2Support")
    private boolean oAuth2Support;
    @Column(name = "OAuth1ASupport")
	private boolean oAuth1ASupport;

	public Endpoint(){}

	public Endpoint(int id, int serviceId, String url, String verb, boolean oAuth2Support, boolean oAuth1ASupport) {
        this.id = id;
        this.serviceId = serviceId;
		this.url = url;
		this.verb = verb;
		this.oAuth2Support = oAuth2Support;
		this.oAuth1ASupport = oAuth1ASupport;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
    }
    
    public int getServiceId() {
		return serviceId;
	}
	
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getVerb() {
		return verb;
	}
	
	public void setVerb(String verb) {
		this.verb = verb;
	}
    
	public boolean getOAuth2Support() {
		return oAuth2Support;
	}
	
	public void setOAuth2Support(boolean oAuth2Support) {
		this.oAuth2Support = oAuth2Support;
	}
	
	public boolean getOAuth1ASupport() {
		return oAuth1ASupport;
	}
	
	public void setOAuth1ASupport(boolean oAuth1ASupport) {
		this.oAuth1ASupport = oAuth1ASupport;
	}
}