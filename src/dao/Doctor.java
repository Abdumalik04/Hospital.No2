package dao;

import java.util.List;

public interface  Doctor {
    String addDoctorToHospital(Long id, Doctor doctor);
    Doctor findDoctorById(Long id);
    String updateDoctor(Long id, Doctor doctor);
    void deleteDoctorById(Long id);
    // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган
    // Department'ге табылган Doctor'лорду кошуп коюнунуз
    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
    List<Doctor> getAllDoctorsByHospitalId(Long id);
    List<Doctor> getAllDoctorsByDepartmentId(Long id);
}
