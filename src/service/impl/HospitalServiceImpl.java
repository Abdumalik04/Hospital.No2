package service.impl;

import database.Database;
import model.Hospital;
import model.Patient;
import service.HospitalService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HospitalServiceImpl implements HospitalService {
    Database database = new Database();

    @Override
    public String addHospital(Hospital hospital) {
        database.getHospitals().add(hospital);
        return hospital.toString();
    }


    @Override
    public Hospital findHospitalById(Long id) {
        return database.getHospitals().stream().filter(x -> x.getId() == id).findFirst().orElse(null);

    }

    @Override
    public List<Hospital> getAllHospital() {
        return database.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        List<Patient> patients = new ArrayList<>();
        Stream<Hospital> hospitalStream = database.getHospitals().stream().filter(x -> {
            if (x.getId() == id) {
                patients.add((Patient) x.getPatients());
            }
            return false;

        });
        return patients;
    }

    @Override
    public String deleteHospitalById(Long id) {
        database.getHospitals().removeIf(x -> x.getId() == id);
        return "succesfully removed !";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> hospitalMap = new HashMap<>();
        Stream<Hospital> patients = database.getHospitals().stream().filter(x -> {
            if (x.getAddress().equalsIgnoreCase(address)) {
                hospitalMap.put(x.getAddress(), x);
            }
            return false;
        });
        return hospitalMap;
    }
}
