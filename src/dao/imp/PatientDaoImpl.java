package dao.imp;

import dao.PatientDao;
import database.Database;
import model.Hospital;
import model.Patient;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class PatientDaoImpl implements PatientDao {

    private Database database;

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        for (Hospital hospital : database.getHospitals()) {
            if (hospital.getId().equals(id)){
                this.database.getPatients().add(patient);
            }
        }
        return "Successfully added.";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : database.getHospitals()) {
            if (hospital.getId().equals(id)){
                this.database.getPatients().addAll(patients);

            }
        }
        return "Successfully added.";
    }

    @Override
    public String updatePatientById(Long id, Patient newPatient) {
        Patient oldPatient = database.getPatients().stream().filter(x -> x.getId().equals(id)).findAny().get();
        oldPatient.setFirstName(newPatient.getFirstName());
        oldPatient.setLastName(newPatient.getLastName());
        oldPatient.setAge(newPatient.getAge());
        oldPatient.setGender(newPatient.getGender());

        return "Patient with id " + id + " successfully updated";
    }

    @Override
    public void removePatientById(Long id) {
        for (Patient patient : database.getPatients()) {
            if (patient.getId().equals(id)){
                database.getPatients().remove(patient);
                System.out.println("Successfully deleted!");
            }
        }
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Patient patient : database.getPatients()) {
            if (patient.getId().equals(id)){
                database.getPatients().add(patient);
                return  patient;
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        Map<Integer, Patient> map = new HashMap<>();
        for (Patient patient : database.getPatients()) {
            int age = Period.between(patient.getAge(), LocalDate.now()).getYears();
            map.put(age, patient);
        }
        return map;
    }

    @Override
    public void sortPatientsByAge(String ascOrDesc) {

        List<Patient> patients = new ArrayList<>();

        System.out.println("<<<COMMANDS>>>");

        System.out.println("""
                   1 -> sorted asc,
                   2 -> sorted desc
                """);

        while (true) {
            switch (ascOrDesc) {
                case "asc":

                    patients.sort(new Comparator<Patient>() {
                        @Override
                        public int compare(Patient o1, Patient o2) {
                            return o1.getAge().compareTo(o2.getAge());
                        }
                    });

                case "desc":

                    patients.sort(new Comparator<Patient>() {
                        @Override
                        public int compare(Patient o1, Patient o2) {
                            return o2.getAge().compareTo(o1.getAge());
                        }
                    });


            }
        }


    }
}