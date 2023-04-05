package dao;

import java.util.List;
import java.util.Map;

public interface PatientDao {

    String addPatientToHospital(Long id, PatientDao patient);
    String addPatientsToHospital(Long id,List<PatientDao> patients);
    String updatePatientById(Long id, PatientDao patientsNewInfo);
    void removePatientById(Long id);
    PatientDao getPatientById(Long id);
    Map<Integer, PatientDao> getPatientByAge();
    List<PatientDao> sortPatientsByAge(String ascOrDesc);
}
