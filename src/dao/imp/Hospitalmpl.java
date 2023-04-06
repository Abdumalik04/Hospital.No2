package dao.imp;

import dao.HospitalDao;
import database.Database;
import model.Hospital;
import model.Patient;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hospitalmpl implements HospitalDao {

    Database database = new Database();

    @Override
    public String addHospital(Hospital hospital) {

        try {
            database.getHospitals().stream().filter(x -> x.getHospitalName().equalsIgnoreCase(hospital.getHospitalName())).findFirst().orElseThrow(() -> new Exception("Hospital already exists"));
            return "Same hospital name";
        } catch (Exception e) {
            database.getHospitals().add(hospital);
            return "Hospital seccesfully added";

        }
    }

    @Override
    public Hospital findHospitalById(Long id) {
        try {
            return database.getHospitals().stream().filter(x -> x.getId() == id).findFirst().orElseThrow(() -> new Exception("Uncorrect id of hospital!"));
        } catch (Exception e) {
            System.out.println("Uncorrect hospital id !");
            return null;
        }
    }

    @Override
    public List<Hospital> getAllHospital() {
        return database.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        try {
            return database.getHospitals().stream().filter(x -> x.getId() == id).findFirst().orElseThrow(() -> new Exception("Uncorrect id of hospital!")).getPatients();
        } catch (Exception e) {
            System.out.println("Uncorrect hospital id !");
            return null;
        }

    }


    @Override
    public String deleteHospitalById(Long id) {
        try {
            database.getHospitals().removeIf(x -> x.getId() == id);
            return "Succesfully removed !";
        } catch (Exception e) {
            System.out.println("Uncorrect id of hospital!" + e.getMessage());
            return "Uncorrect id of hospital";
        }

    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        try {
            return database.getHospitals()
                    .stream()
                    .filter(x -> x.getAddress().equals(address))
                    .collect(Collectors.toMap(Hospital::getHospitalName, hospital -> hospital));
        } catch (Exception e) {
            System.out.println("Uncerrect adress of hospital!+"+e.getMessage());
            return new HashMap<>();
        }
    }
}



