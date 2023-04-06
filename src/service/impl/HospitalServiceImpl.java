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
        return null;
    }


    @Override
    public Hospital findHospitalById(Long id) {
        return null;

    }

    @Override
    public List<Hospital> getAllHospital() {
        return null;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        return null;

    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return null;
    }
}
