package dao.imp;

import dao.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
    @Override
    public String addPatientToHospital(Long id, PatientService patient) {
        return null;
    }

    @Override
    public String addPatientsToHospital(Long id, List<PatientService> patients) {
        return null;
    }

    @Override
    public String updatePatientById(Long id, PatientService patientsNewInfo) {
        return null;
    }

    @Override
    public void removePatientById(Long id) {

    }

    @Override
    public PatientService getPatientById(Long id) {
        return null;
    }

    @Override
    public Map<Integer, PatientService> getPatientByAge() {
        return null;
    }

    @Override
    public List<PatientService> sortPatientsByAge(String ascOrDesc) {
        return null;
    }
}
