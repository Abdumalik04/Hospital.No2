package service.impl;

import dao.DoctorDao;
import model.Doctor;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        return null;
    }

    @Override
    public DoctorDao findDoctorById(Long id) {
        return null;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {

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
