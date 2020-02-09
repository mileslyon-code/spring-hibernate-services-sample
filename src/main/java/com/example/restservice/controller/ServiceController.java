package com.example.restservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.example.restservice.pojo.Service;
import com.example.restservice.utility.ServiceLocator;

@RestController
public class ServiceController {

	@GetMapping("api/v1/services")
	public List<Service> servicesAll(@RequestParam(value = "name", defaultValue = "World") String name) {
		return ServiceLocator.getServiceManager().getServices();
	}
	
	@GetMapping("api/v1/services/{serviceId}")
	public Service serviceById(HttpServletResponse res, @PathVariable("serviceId") int serviceId) {
		Service service = ServiceLocator.getServiceManager().getService(serviceId);
		if(service == null){
			res.setStatus(404);
		}
		return service;
	}
}