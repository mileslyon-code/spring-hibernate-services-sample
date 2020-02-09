package com.example.restservice.service;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import com.example.restservice.HibernateUtil;
import com.example.restservice.pojo.Endpoint;
import com.example.restservice.pojo.Service;

public class ServiceManager implements IServiceManager {
    public List<Service> getServices(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Service> services = session.createCriteria(Service.class).list();
        for(int i = 0;i < services.size(); i++){
            services.get(i).setEndpoints(getEndpoints(services.get(i).getId()));
        }
        session.close();

		return services;
    }

    public Service getService(int serviceId){
        Service service = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        service = (Service) session.get(Service.class, serviceId);
        session.close();

        if(service != null){
            service.setEndpoints(getEndpoints(serviceId));
        }

        return service;
    }

    public List<Endpoint> getEndpoints(int serviceId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Endpoint> endpoints = session.createCriteria(Endpoint.class).add(Restrictions.eq("serviceId",serviceId)).list();
        session.close();

		return endpoints;
    }

    public void generateDemoData() {
        if(!checkDemoData()){
            generateServices();
            generateEndpoints();
        }
    }

    private boolean checkDemoData(){
        Service service = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        service = (Service) session.get(Service.class, 5);
        session.close();

        return (service != null);
    }

    private void generateServices(){
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();

        session.save(new Service(5, "Insitution", "Institution Service", "Common Institution Course API", "v1.2.1"));
        session.save(new Service(6, "Course", "Course Service", "Common Institution Course API", "v1.2.1"));
        session.save(new Service(7, "Student", "Student Service", "Common Institution Course API", "v1.2.1"));

        session.getTransaction().commit();
        session.close();
    }

    private void generateEndpoints(){
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();

        session.save(new Endpoint(47, 5, "api/v1/institutions", "GET", false, false));
        session.save(new Endpoint(48, 5, "api/v1/institutions/{d}", "GET", true, true));
        session.save(new Endpoint(49, 5, "api/v1/institutions/{d}/courses", "GET", true, true));
        session.save(new Endpoint(50, 5, "api/v1/institutions/{d}/students", "GET", true, true));

        session.save(new Endpoint(91, 6, "api/v1/courses", "GET", true, false));
        session.save(new Endpoint(92, 6, "api/v1/courses/{d}", "GET", false, true));
        session.save(new Endpoint(93, 6, "api/v1/courses/{d}/students", "GET", false, true));

        session.save(new Endpoint(117, 7, "api/v1/students", "GET", true, true));
        session.save(new Endpoint(118, 7, "api/v1/students", "POST", true, true));
        session.save(new Endpoint(119, 7, "api/v1/students{d}", "GET", true, true));
        session.save(new Endpoint(120, 7, "api/v1/students{d}", "PUT", true, true));
        session.save(new Endpoint(121, 7, "api/v1/students{d}", "DELETE", true, true));

        session.getTransaction().commit();
        session.close();
    }
}