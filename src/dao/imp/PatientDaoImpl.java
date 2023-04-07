package dao.imp;

import dao.PatientDao;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.time.Period;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatientDaoImpl implements PatientDao {


    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        try {
            Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getPatients().add(patient)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return "succesfully added";
        } catch (NoSuchElementException e) {
            return "Uncorrect id of hospital!";
        }
    }


    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        try {
            Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getPatients().addAll(patients)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return "succesfully added";
        } catch (NoSuchElementException e) {
            return "Uncorrect id of hospital!";
        }
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        try {
            Hospital hospital = Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getPatients().stream().
                            anyMatch(p -> p.getId().equals(id))).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            Patient patient = hospital.
                    getPatients().stream().filter(x -> x.getId().equals(id)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            patient.setFirstName(patientsNewInfo.getFirstName());
            patient.setLastName(patientsNewInfo.getLastName());
            patient.setAge(patientsNewInfo.getAge());
            patient.setId(patientsNewInfo.getId());
            return patient.toString() + " succesfully updated!";
        } catch (NoSuchElementException e) {
            return "patient with " + id + "not found !";
        }
    }

    @Override
    public void removePatientById(Long id) {
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        try {
            Hospitalmpl.database.getHospitals().stream()
                    .filter(hospital -> hospital.getPatients().stream().
                            anyMatch(patient -> patient.getId().equals(id)))
                    .findFirst()
                    .ifPresent(hospital -> {
                        hospital.getPatients().removeIf(patient -> patient
                                .getId().equals(id));
                        isDeleted.set(true);
                    });

            if (isDeleted.get()) {
                System.out.println("Patient  with ID " + id + " has been deleted.");
            } else {
                throw new java.lang.Exception("Uncorrect id of doctor!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public Patient getPatientById(Long id) {
        try {
            Hospital hospital = Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getPatients().stream().
                            anyMatch(p -> p.getId().equals(id))).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            Patient patient = hospital.
                    getPatients().stream().filter(x -> x.getId().equals(id)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return patient;
        } catch (NoSuchElementException e) {
            System.out.println("Uncorrect id of doctor");
            return null;
        }

    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {


        Map<Integer, Patient> patientsByAge = new HashMap<>();

        Hospitalmpl.database.getHospitals()
                .stream()
                .flatMap(hospital -> hospital.getPatients().stream())
                .forEach(patient -> {

                        patientsByAge.putIfAbsent(patient.getAge(), patient);

                });

        return patientsByAge;

    }


    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        Comparator<Patient> ageComparator = Comparator.comparing(Patient::getAge);
        if (ascOrDesc.equalsIgnoreCase("desc")) {
            ageComparator = ageComparator.reversed();
            return Hospitalmpl.database.getHospitals().stream()
                    .flatMap(hospital -> hospital.getPatients().stream())
                    .sorted(ageComparator)
                    .collect(Collectors.toList());
        } else if (ascOrDesc.equalsIgnoreCase("asc")) {

            return Hospitalmpl.database.getHospitals().stream()
                    .flatMap(hospital -> hospital.getPatients().stream())
                    .sorted(ageComparator)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
