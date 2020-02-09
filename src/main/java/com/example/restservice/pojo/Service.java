package com.example.restservice.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Service")
public class Service {

	@Id
    @Column(name = "ID")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Description")
	private String description;
	@Column(name = "SpecificationName")
	private String specificationName;
	@Column(name = "SpecificationVersion")
	private String specificationVersion;
	@Transient
	private List<Endpoint> endpoints;

	public Service(){}

	public Service(int id, String name, String description, String specificationName, String specificationVersion) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.specificationName = specificationName;
		this.specificationVersion = specificationVersion;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSpecificationName() {
		return specificationName;
	}
	
	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}
	
	public String getSpecificationVersion() {
		return specificationVersion;
	}
	
	public void setSpecificationVersion(String specificationVersion) {
		this.specificationVersion = specificationVersion;
	}

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}
	
	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}
}