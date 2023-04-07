import dao.imp.DepartmentImpl;
import dao.imp.DoctorImpl;
import dao.imp.Hospitalmpl;
import dao.imp.PatientDaoImpl;
import enums.Gender;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static <HospitalDaoImpl> void main(String[] args) {


        List<Department> departments = new ArrayList<>();
        DepartmentImpl department = new DepartmentImpl();
        Hospitalmpl hospitalmpl = new Hospitalmpl();
        DoctorImpl doctor = new DoctorImpl();
        PatientDaoImpl patientDao = new PatientDaoImpl();


        departments.add(new Department(2L, "Oncology", List.of(new Doctor())));
        departments.add(new Department(3L, "Urology", List.of(new Doctor())));
        departments.add(new Department(4L, "Psychiatry", List.of(new Doctor())));
        List<Doctor> doctors = new ArrayList<>();
        Doctor doctor1 = new Doctor(1L, "AbduMalik", "Samatov", Gender.MALE, 2004);
        Doctor doctor3 = new Doctor(2L, "Abdu", "amatov", Gender.MALE, 2000);
        Doctor doctor2 = new Doctor(3L, "Baatyrov Kapar", "Mamatbekov", Gender.MALE, 1998);
        Doctor doctor4 = new Doctor(4L, "Mahabat ", "Maaripbekova", Gender.FEMALE, 2000);

        doctors.add(new Doctor(1L, "AbduMalik", "Samatov", Gender.MALE, 2004));
        doctors.add(new Doctor(2L, "Abdusapar", "Saparov", Gender.MALE, 2001));
        doctors.add(new Doctor(3L, "Baatyrov Kapar", "Mamatbekov", Gender.MALE, 1998));
        doctors.add(new Doctor(3L, "Mahabat ", "Maaripbekova", Gender.FEMALE, 2000));

        departments.add(new Department(5L, "Neurology", doctors));
        Department departmen = new Department(1L, "Neurology", doctors);
        Department departmen2 = new Department(2L, "Oncology", doctors);
        Department departmen3 = new Department(3L, "Urology", doctors);
        Department departmen4 = new Department(4L, "Psychiatry", doctors);

        Patient patient = new Patient(1L, "Ernazar", "Tilek uulu", 16, Gender.MALE);
        Patient patient1 = new Patient(2L, "Arnaz", "Taalai uulu", 18, Gender.MALE);
        Patient patient2 = new Patient(3L, "Matmusa", "Abduvohob uulu", 21, Gender.MALE);
        Patient patient3 = new Patient(4L, "Aigul", "Japarova", 56, Gender.FEMALE);
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1L, "Ernazar", "Tilek uulu", 16, Gender.MALE));
        patients.add(new Patient(2L, "Arnaz", "Taalai uulu", 18, Gender.MALE));
        patients.add(new Patient(3L, "Matmusa", "Abduvohob uulu", 21, Gender.MALE));
        patients.add(new Patient(4L, "Aigul", "Japarova", 56, Gender.FEMALE));


        Hospital hospital = new Hospital(1L, "Hospital", "jal", departments, doctors, patients);
        Hospital hospital1 = new Hospital(2L, "Hospital1", "bishkek ", departments, doctors, patients);
        Hospital hospital2 = new Hospital(3L, "Hospital2", "kyzyl-Asker 5", departments, doctors, patients);
        Hospital hospital3 = new Hospital(4L, "Hospital3", "bala", departments, doctors, patients);

        System.out.println("Add new hospital :" + hospitalmpl.addHospital(hospital));
        System.out.println("Add new hospital :" + hospitalmpl.addHospital(hospital2));
        System.out.println("Add new hospital :" + hospitalmpl.addHospital(hospital3));
        System.out.println("Add new hospital :" + hospitalmpl.addHospital(hospital1));

        System.out.println("Find by id :" + hospitalmpl.findHospitalById(2l));
        System.out.println("Get all patients from hospital :" + hospitalmpl.getAllPatientFromHospital(4l));
        System.out.println("Get all hospitals :" + hospitalmpl.getAllHospital());
        System.out.println("Find hospital by id " + hospitalmpl.findHospitalById(2l));

        System.out.println("Find hospital by adress :" + hospitalmpl.getAllHospitalByAddress("bala"));
        System.out.println("Delete hospital by id :" + hospitalmpl.deleteHospitalById(1l));
        System.out.println("Get all hospitals :" + hospitalmpl.getAllHospital());
        System.out.println("=================================");
        System.out.println("add new department to hospital :" + department.addDepartmentToHospital(2l, departmen2));
        System.out.println("add new department to hospital :" + department.addDepartmentToHospital(3l, departmen3));
        System.out.println("add new department to hospital :" + department.addDepartmentToHospital(4l, departmen4));
        System.out.println("find by department name :" + department.findDepartmentByName("Psychiatry"));
        System.out.println(" Update department by id " + department.updateDepartmentById(3l, departmen));
        department.deleteDepartmentById(2l);
        System.out.println(" Update department by id " + department.updateDepartmentById(2l, departmen2));
        System.out.println("================================");

        System.out.println("Add doctors to hospital :" + doctor.addDoctorToHospital(1l, doctor1));
        System.out.println("Add doctors to hospital :" + doctor.addDoctorToHospital(2l, doctor2));
        System.out.println("Add doctors to hospital :" + doctor.addDoctorToHospital(3l, doctor3));
        System.out.println("Add doctors to hospital :" + doctor.addDoctorToHospital(4l, doctor4));
        System.out.println("Get all doctors by department id :" + doctor.getAllDoctorsByDepartmentId(4l));
        System.out.println("Get all doctors by hospital id :" + doctor.getAllDoctorsByHospitalId(3l));
        List<Long> longs = new ArrayList<>(Arrays.asList(1l, 2l, 3l, 4l));
        System.out.println("Assign doctor to department :" + doctor.assignDoctorToDepartment(1l, longs));
        System.out.println("Update doctor :" + doctor.updateDoctor(4l, doctor2));
        System.out.println("Find doctor by id " + doctor.findDoctorById(1l));
        doctor.deleteDoctorById(3l);
        System.out.println("Find doctor by id " + doctor.findDoctorById(1l));
        System.out.println("====================================================");
        System.out.println("ADDED PATIENT TO HOSPITAL :" + patientDao.addPatientToHospital(2l, patient2));
        System.out.println("ADDED PATIENTS TO HOSPITAL :" + patientDao.addPatientsToHospital(1l, patients));
        System.out.println("GET PATIENT BY ID :" + patientDao.getPatientById(3l));
        System.out.println("GET PATIENT BY AGE :"+patientDao.getPatientByAge());
        System.out.println("SORT PATIENT BY AGE :"+patientDao.sortPatientsByAge("desc"));
        System.out.println("UPDATE PATIENT BY ID :"+patientDao.updatePatientById(2l, patient));
        patientDao.removePatientById(3l);
        System.out.println("GET PATIENT BY ID :" + patientDao.getPatientById(3l));
    }
}