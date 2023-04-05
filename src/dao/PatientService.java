package dao;

import java.util.List;
import java.util.Map;

public interface PatientService {

    String addPatientToHospital(Long id, PatientService patient);
    String addPatientsToHospital(Long id,List<PatientService> patients);
    String updatePatientById(Long id, PatientService patientsNewInfo);
    void removePatientById(Long id);
    PatientService getPatientById(Long id);
    Map<Integer, PatientService> getPatientByAge();
    List<PatientService> sortPatientsByAge(String ascOrDesc);
}
