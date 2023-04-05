package dao.imp;

import dao.DoctorDao;
import database.Database;
import model.Doctor;
import model.Hospital;

import java.util.List;
import java.util.Scanner;

public class DoctorImpl implements DoctorDao {
Database database=new Database();
    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        for (Hospital hospital:database.getHospitals()){
            if (hospital.getId().equals(id)){
                hospital.getDoctors().add(doctor);
            }
        }
        return "Added Hospital: "+doctor+" ,Doctor";
    }
    @Override
    public DoctorDao findDoctorById(Long id) {
        for (Hospital d:database.getHospitals()){
            for (Doctor doctor:d.getDoctors()){
                if (doctor.getId().equals(id)){

                }
            }
        }
        return null ;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        for (Hospital f:database.getHospitals()){
            for (Doctor doctors: f.getDoctors()){
                if (doctors.getId().equals(id)){
                    doctors.setFirstName(doctor.getFirstName());
                    doctors.setLastName(doctor.getLastName());
                    doctors.setGender(doctor.getGender());
                    doctors.setExperienceYear(doctor.getExperienceYear());
                }
            }
        }
        return "Successfully updated";
    }
    @Override
    public void deleteDoctorById(Long id) {
for (Hospital d:database.getHospitals()){
    for (Doctor s:d.getDoctors()){
        if (s.getId().equals(id)){
            d.getDoctors().remove(s);
        }
    }
}
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return null;
    }

    @Override
    public List<DoctorDao> getAllDoctorsByHospitalId(Long id) {
        return null;
    }

    @Override
    public List<DoctorDao> getAllDoctorsByDepartmentId(Long id) {
        return null;
    }
}
