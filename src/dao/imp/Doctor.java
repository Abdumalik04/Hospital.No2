package dao.imp;

import java.util.List;

public class Doctor implements dao.Doctor {

    @Override
    public String addDoctorToHospital(Long id, dao.Doctor doctor) {
        return null;
    }

    @Override
    public dao.Doctor findDoctorById(Long id) {
        return null;
    }

    @Override
    public String updateDoctor(Long id, dao.Doctor doctor) {
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
    public List<dao.Doctor> getAllDoctorsByHospitalId(Long id) {
        return null;
    }

    @Override
    public List<dao.Doctor> getAllDoctorsByDepartmentId(Long id) {
        return null;
    }
}
