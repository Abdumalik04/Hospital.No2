package dao.imp;

import dao.HospitalDao;
import database.Database;
import exception.Exception;
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
            if (database.getHospitals().removeIf(x -> x.getId() == id)) {
                return "Succesfully removed !";

            } else {
                throw new Exception("Uncorect id of hospital");
            }


        } catch
        (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map <String,Hospital>hospitalMap=new HashMap<>();
        boolean isTrue = true;
        try {
            for (Hospital d : database.getHospitals()
            ) {
                if(d.getAddress().equalsIgnoreCase(address)){
                    hospitalMap.put(d.getAddress().toString(),d);
                    return hospitalMap;
                }else {
                    isTrue=false;
                }
            }
            if (!isTrue){
                throw new Exception("Uncorect adress!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } return hospitalMap;
    }
}


