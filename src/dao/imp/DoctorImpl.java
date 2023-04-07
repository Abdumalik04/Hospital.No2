package dao.imp;

import dao.DoctorDao;
import exception.Exception;
import model.Department;
import model.Doctor;
import model.Hospital;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class DoctorImpl implements DoctorDao {

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        try {
            Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getDoctors().add(doctor)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return "succesfully added";
        } catch (NoSuchElementException e) {
            return "Uncorrect id of hospital!";
        }
    }


    @Override
    public Doctor findDoctorById(Long id) {
        try {
            Hospital hospital = Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getDoctors().stream().
                            anyMatch(p -> p.getId().equals(id))).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            Doctor doctor = hospital.
                    getDoctors().stream().filter(x -> x.getId().equals(id)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return doctor;
        } catch (NoSuchElementException e) {
            System.out.println("Uncorrect id of doctor");
            return null;
        }
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        try {
            Hospital hospital = Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getDoctors().stream().
                            anyMatch(p -> p.getId().equals(id))).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            Doctor doctor1 = hospital.
                    getDoctors().stream().filter(x -> x.getId().equals(id)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            doctor1.setFirstName(doctor.getFirstName());
            doctor1.setLastName(doctor.getLastName());
            doctor1.setId(doctor.getId());
            return doctor1.toString() + "Succesfully updated!";
        } catch (NoSuchElementException e) {
            System.out.println("Uncorrect id of hospital");
            return null;
        }
    }

    @Override
    public void deleteDoctorById(Long id) {
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        try {
            Hospitalmpl.database.getHospitals().stream()
                    .filter(hospital -> hospital.getDoctors().stream().anyMatch(doctor -> doctor.getId().equals(id)))
                    .findFirst()
                    .ifPresent(hospital -> {
                        hospital.getDoctors().removeIf(doctor -> doctor.getId().equals(id));
                        isDeleted.set(true);
                    });


            if (isDeleted.get()) {
                System.out.println("Doctor with ID " + id + " has been deleted.");
            } else {
                throw new Exception("Uncorrect id of doctor!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        List<Doctor> doctors = new ArrayList<>();

        Hospitalmpl.database.getHospitals().stream().
                filter(x -> {
                    for (Doctor p : x.getDoctors()) {
                        if (doctorsId.contains(p.getId())) {
                            doctors.add(p);
                            return true;
                        }
                    }
                    return false;
                });


        try {
            Hospital hospital = Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getDepartments().stream().
                            anyMatch(p -> p.getId().equals(departmentId))).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            Department department= hospital.
                    getDepartments().stream().filter(x -> x.getId().equals(departmentId)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
           department.getDoctors().addAll(doctors);

           return department.toString();
        } catch (NoSuchElementException e) {
            System.out.println("Uncorrect id of doctor");
            return null;
        }

    }


    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        try {
            Hospital hospital = Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getId().equals(id)).findFirst().orElseThrow(NoSuchElementException::new);
            return hospital.getDoctors();

        } catch (NoSuchElementException e) {
            System.out.println("Uncorrrect id!");
            return new ArrayList<>();
        }

    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {

        try {
            Department department = Hospitalmpl.database.getHospitals().stream().
                    flatMap(x -> x.getDepartments().stream().
                            filter(p -> p.getId().equals(id))).
                    findFirst().orElseThrow(NoSuchElementException::new);
            return department.getDoctors();
        } catch (NoSuchElementException e) {
            System.out.println("Uncorrect id of department!");
            return new ArrayList<>();
        }
    }
}

