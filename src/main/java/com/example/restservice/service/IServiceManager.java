package com.example.restservice.service;

import java.util.List;

import com.example.restservice.pojo.Endpoint;
import com.example.restservice.pojo.Service;

public interface IServiceManager {
    public List<Service> getServices();
    public Service getService(int serviceId);
    public List<Endpoint> getEndpoints(int serviceId);
    public void generateDemoData();
}