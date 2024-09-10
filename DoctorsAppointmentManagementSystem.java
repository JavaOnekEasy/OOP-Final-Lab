

package doctorsappointmentmangementsystem;

import java.util.ArrayList;
import java.util.List;

abstract class Doctor{
    private String name;
    private String specialization;
    private List<String> availability;
    
    public Doctor(String name, String specialization){
        this.name = name;
        this.specialization = specialization;
        this.availability = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
   
    
    public List<String> getAvailability(){
        return availability;
    }
    
    public void addAvailability(String time){
        availability.add(time);
    }
    public abstract void displayAvailability();
}

class GeneralPractitioner extends Doctor{
    public GeneralPractitioner(String name){
        super(name, "GeneralPractitioner");
    }
    
    @Override
    public void displayAvailability(){
        System.out.println("GeneralPractitioner" + getName() + "is available for walk-in patients at:" + getAvailability());
    }
}

class Specialist extends Doctor{
    public Specialist(String name){
        super(name, "GeneralPractitioner");
    }
    
    @Override
    public void displayAvailability(){
        System.out.println("Specialist" + getName() + "requires appoinment conformation. Available times: " + getAvailability());
    }
}


class Patient {
    private String name;
    private String contactInfo;

    public Patient(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    
}


class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String time;

    public Appointment(Doctor doctor, Patient patient, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.time = time;
    }

    public void displayAppointmentDetails() {
        System.out.println("Appointment Details: ");
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Patient: " + patient.getName());
        System.out.println("Time: " + time);
    }
}


public class DoctorsAppointmentManagementSystem {
    public static void main(String[] args) {
        Doctor doc1 = new GeneralPractitioner("Dr. Kylie");
        doc1.addAvailability("10:00 AM - 12:00 PM");
       

        Doctor doc2 = new Specialist("Dr. Ambrose");
        doc2.addAvailability("1:00 PM - 3:00 PM");
       
        Doctor doc3 = new GeneralPractitioner("Dr. Nebras");
        doc3.addAvailability("4:00 PM - 6:00 PM");
       
         Doctor doc4 = new Specialist("Dr. Alan");
        doc4.addAvailability("7:00 PM - 9:00 PM");

        doc1.displayAvailability();
        doc2.displayAvailability();
        doc3.displayAvailability();
        doc4.displayAvailability();

        Patient patient1 = new Patient("Vladimir Vostok", "019-456-890");
        Appointment appointment1 = new Appointment(doc1, patient1, "10:30 AM");
        appointment1.displayAppointmentDetails();
       
        Patient patient2 = new Patient("Franklin Roosevelt", "013-568-790");
        Appointment appointment2 = new Appointment(doc4, patient2, "7:30 PM");
        appointment2.displayAppointmentDetails();
    }
}
