package com.example.restservice.service;

import java.util.ArrayList;
import java.util.List;

import com.example.restservice.pojo.Endpoint;
import com.example.restservice.pojo.Service;

public class FakeServiceManager implements IServiceManager {
    public List<Service> getServices(){
        List<Service> fakeServices = new ArrayList();
		fakeServices.add(new Service(5, "Insitution", "Institution Service", "Common Institution Course API", "v1.2.1"));
		fakeServices.add(new Service(6, "Course", "Course Service", "Common Institution Course API", "v1.2.1"));
        fakeServices.add(new Service(7, "Student", "Student Service", "Common Institution Course API", "v1.2.1"));
		return fakeServices;
    }

    public Service getService(int serviceId){
        Service fakeService = new Service(5, "Insitution", "Institution Service", "Common Institution Course API", "v1.2.1");
        fakeService.setEndpoints(getEndpoints(serviceId));
		return fakeService;
    }

    public List<Endpoint> getEndpoints(int serviceId) {
        List<Endpoint> fakeEndpoints = new ArrayList();
        fakeEndpoints.add(new Endpoint(47, 5, "api//v1//Insitutions", "GET", false, false));
        fakeEndpoints.add(new Endpoint(48, 5, "api//v1//Insitutions/{d}", "GET", true, true));
        fakeEndpoints.add(new Endpoint(49, 5, "api//v1//Insitutions/{d}/courses", "GET", true, true));
        fakeEndpoints.add(new Endpoint(50, 5, "api//v1//Insitutions/{d}/students", "GET", true, true));
        return fakeEndpoints;
    }

    public void generateDemoData() {}
}