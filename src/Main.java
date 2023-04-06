import dao.imp.Hospitalmpl;
import enums.Gender;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static <HospitalDaoImpl> void main(String[] args) {


        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1L, "Kairat", List.of(new Doctor())));
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(2L, "AbduMalik", "Samatov", Gender.MALE, 2004));
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(3L, "Ernazar", "Tilek uulu", 16, Gender.MALE));
        Hospital hospital = new Hospital(1L, "Hospital", "jal", departments, doctors, patients);
        Hospital hospital1 = new Hospital(2L, "Hospital1", "bishkek ", departments, doctors, patients);
        Hospital hospital2 = new Hospital(3L, "Hospital2", "kyzyl-Asker 5", departments, doctors, patients);
        Hospital hospital3 = new Hospital(4L, "Hospital3", "bala", departments, doctors, patients);
        Hospitalmpl hospitalmpl = new Hospitalmpl();
        System.out.println(hospitalmpl.addHospital(hospital));
        System.out.println(hospitalmpl.addHospital(hospital1));
        System.out.println(hospitalmpl.addHospital(hospital2));
        System.out.println(hospitalmpl.addHospital(hospital3));
        System.out.println(hospitalmpl.findHospitalById(2l));
        System.out.println(hospitalmpl.getAllPatientFromHospital(6l));
        System.out.println(hospitalmpl.getAllHospital());
        System.out.println(hospitalmpl.findHospitalById(2l));
        System.out.println(hospitalmpl.getAllHospitalByAddress("jal"));
        System.out.println(hospitalmpl.deleteHospitalById(1l));

//        System.out.println(hospitalDao.addHospital(hospital1));
//        System.out.println(hospitalDao.findHospitalById(1L));
//        System.out.println(hospitalDao.getAllHospital());
//        System.out.println(hospitalDao.getAllPatientFromHospital(1L));
//        System.out.println(hospitalDao.deleteHospitalById(1L));
//        System.out.println(hospitalDao.getAllHospitalByAddress("Hospital"));


    }
}