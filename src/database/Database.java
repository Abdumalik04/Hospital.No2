package database;

import model.Doctor;

import java.util.LinkedHashSet;
import java.util.Set;

public class Database {
private Set<Hospital> hospitals = new LinkedHashSet<>();
private Set<Department> departments= new LinkedHashSet<>();
private Set<Doctor> doctors = new LinkedHashSet<>();
private Set<Patient> patients = new LinkedHashSet<>();

    public Set<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(Set<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
