package dao.imp;

import dao.PatientDao;

import java.util.List;
import java.util.Map;

public class PatientDaoImpl implements PatientDao {


    @Override
    public String addPatientToHospital(Long id, PatientDao patient) {
        return null;
    }

    @Override
    public String addPatientsToHospital(Long id, List<PatientDao> patients) {
        return null;
    }

    @Override
    public String updatePatientById(Long id, PatientDao patientsNewInfo) {
        return null;
    }

    @Override
    public void removePatientById(Long id) {

    }

    @Override
    public PatientDao getPatientById(Long id) {
        return null;
    }

    @Override
    public Map<Integer, PatientDao> getPatientByAge() {
        return null;
    }

    @Override
    public List<PatientDao> sortPatientsByAge(String ascOrDesc) {
        return null;
    }
}
