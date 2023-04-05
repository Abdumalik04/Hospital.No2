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
        departments.add(new Department(1L,"Kairat",List.of(new Doctor())));
        List<Doctor>doctors = new ArrayList<>();
        doctors.add(new Doctor(2L,"AbduMalik","Samatov", Gender.MALE,2004));
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(3L,"Ernazar","Tilek uulu",16,Gender.MALE));
        Hospitalmpl hospitalDao = new Hospitalmpl();
        Hospital hospital = new Hospital(1L,"Hospital","vostok 5",departments,doctors,patients);
        Hospital hospital1 = new Hospital(2L,"Hospital","jal ",departments,doctors,patients);
        Hospital hospital2 = new Hospital(3L,"Hospital","kyzyl-Asker 5",departments,doctors,patients);
        Hospital hospital3 = new Hospital(4L,"Hospital","ak-orgo ",departments,doctors,patients);

//        System.out.println(hospitalDao.addHospital(hospital1));
//        System.out.println(hospitalDao.findHospitalById(1L));
//       System.out.println(hospitalDao.getAllHospital());
//        System.out.println(hospitalDao.getAllPatientFromHospital(1L));
//        System.out.println(hospitalDao.deleteHospitalById(1L));
//        System.out.println(hospitalDao.getAllHospitalByAddress("Hospital"));


    }
}