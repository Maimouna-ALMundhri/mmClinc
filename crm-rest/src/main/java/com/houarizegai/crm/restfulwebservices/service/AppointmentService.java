package com.houarizegai.crm.restfulwebservices.service;

import com.houarizegai.crm.restfulwebservices.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AppointmentService {
    private static List<Appointment> appointments;
    private static long idCounter = 0;
    private Logger log;

    static {
        appointments = new LinkedList<>(Arrays.asList(
        	
                new Appointment(++idCounter,10004L, "Ahmed", "eye", "12","12-12-2020","heeelp","12345678","M", "hamdoon"),
                new Appointment(++idCounter,10004L, "Ahmed", "eye", "12","12-12-2020","heeelp","12345678","M", "hamdoon")
             
        ));
    }

    public List<Appointment> findAll() {
        return appointments;
    }

    public Appointment save(Appointment appointment) {
        if(appointment.getId() < 1) {
            appointment.setId(++idCounter);
            appointments.add(appointment);
        } else {
            deleteById(appointment.getId());
            appointments.add(appointment);
        }

        return appointment;
    }

    public Appointment deleteById(long id) {
        Appointment appointment = findById(id);

        if(appointment == null) return null;

        if(appointments.remove(appointment))
            return appointment;
        return null;
    }

    public List<Appointment>  findByPatientId(long patientId) {
    	List<Appointment> patientAppointments = new ArrayList<Appointment>();
    	  for(Appointment appointment : appointments) {
    		 
              if(appointment.getPatientID() == patientId) {
            	  
            	  patientAppointments.add(appointment);
                  
              }         	
              
    	  }
          return patientAppointments;
    }
    
    public Appointment findById(long patientId) {
        for(Appointment appointment : appointments)
            if(appointment.getPatientID() == patientId)
                return appointment;
        return null;
    }
}
