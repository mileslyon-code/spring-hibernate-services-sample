package com.example.restservice.utility;

import com.example.restservice.service.FakeServiceManager;
import com.example.restservice.service.IServiceManager;
import com.example.restservice.service.ServiceManager;

//Some faux dependency injection to partition our services from data.
public class ServiceLocator {
    public static IServiceManager serviceManager;

    public static void SetFake(){
        serviceManager = new FakeServiceManager();
    }

    public static void SetReal(){
        serviceManager = new ServiceManager();
    }

    public static IServiceManager getServiceManager() {
        if(serviceManager == null){
            SetFake();
        }
        return serviceManager;
    }
}