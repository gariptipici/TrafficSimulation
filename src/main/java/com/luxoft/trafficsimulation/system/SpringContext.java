package com.luxoft.trafficsimulation.system;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.luxoft.trafficsimulation.publishers.EventPublisher;
import com.luxoft.trafficsimulation.repository.IVehicleService;
import com.luxoft.trafficsimulation.repository.VehicleService;

@Component
public class SpringContext implements ApplicationContextAware {
     
    private static ApplicationContext context;
 
    public static EventPublisher getEventPublisher() {
        return (EventPublisher)context.getBean("eventPublisher");
    }
    
    public static IVehicleService getVehicleService() {
    	return (VehicleService)context.getBean("vehicleService");
    }
     
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
         
        SpringContext.context = context;
    }
}
