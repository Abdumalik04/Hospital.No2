package service.impl;

import model.Patient;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {

    private PatientService patientService;

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        return patientService.addPatientToHospital(id, patient);
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientService.addPatientsToHospital(id, patients);
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        return patientService.updatePatientById(id, patientsNewInfo);
    }

    @Override
    public void removePatientById(Long id) {
        patientService.removePatientById(id);

    }

    @Override
    public Patient getPatientById(Long id) {
        return patientService.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientService.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientService.sortPatientsByAge(ascOrDesc);
    }
}
