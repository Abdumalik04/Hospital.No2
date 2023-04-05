package dao;

import dao.imp.DoctorImpl;
import model.Doctor;

import java.util.List;

public interface DoctorDao {
    String addDoctorToHospital(Long id, Doctor doctor);
    DoctorDao findDoctorById(Long id);
    String updateDoctor(Long id, Doctor doctor);
    void deleteDoctorById(Long id);
    // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган
    // Department'ге табылган Doctor'лорду кошуп коюнунуз
    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
    List<DoctorDao> getAllDoctorsByHospitalId(Long id);
    List<DoctorDao> getAllDoctorsByDepartmentId(Long id);
}
