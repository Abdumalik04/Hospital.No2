package dao;

public interface DoctorDao {
    String addDoctorToHospital(Long id, DoctorDao doctor);
    DoctorDao findDoctorById(Long id);
    String updateDoctor(Long id, DoctorDao doctor);
    void deleteDoctorById(Long id);
}
