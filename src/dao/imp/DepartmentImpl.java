package dao.imp;

import dao.DepartmentDao;
import database.Database;
import exception.Exception;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;


public class DepartmentImpl implements DepartmentDao {


    @Override
    public String addDepartmentToHospital(Long id, Department department) {

        try {
            Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getDepartments().add(department)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return "succesfully added";
        } catch (NoSuchElementException e) {
            return "Uncorrect id of hospital!";
        }
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        try {
            Hospital hospital = Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getId().equals(id)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return hospital.getDepartments();
        } catch (NoSuchElementException e) {
            System.out.println("Uncorrect id of doctor");
            return null;
        }
    }

    @Override
    public Department findDepartmentByName(String name) {
        try {
            Hospital hospital = Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getDepartments().stream().
                            anyMatch(p -> p.getDepartmentName().equalsIgnoreCase(name))).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            Department department= hospital.
                    getDepartments().stream().filter(x -> x.getDepartmentName().equalsIgnoreCase(name)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return department;
        } catch (NoSuchElementException e) {
            System.out.println("Uncorrect id of doctor");
            return null;
        }

    }


    @Override
    public void deleteDepartmentById(Long id) {
        AtomicBoolean isDeleted = new AtomicBoolean(false);
        try {
            Hospitalmpl.database.getHospitals().stream()
                    .filter(hospital -> hospital.getDepartments().stream().anyMatch(doctor -> doctor.getId().equals(id)))
                    .findFirst()
                    .ifPresent(hospital -> {
                        hospital.getDepartments().removeIf(doctor -> doctor.getId().equals(id));
                        isDeleted.set(true);
                    });


            if (isDeleted.get()) {
                System.out.println("Department with ID " + id + " has been deleted.");
            } else {

                throw new Exception("Uncorerect id of department");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String updateDepartmentById(Long id, Department newDepartment) {
        try {
            Hospital hospital = Hospitalmpl.database.getHospitals().stream().
                    filter(x -> x.getDepartments().stream().
                            anyMatch(p -> p.getId().equals(id))).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            Department department = hospital.
                    getDepartments().stream().filter(x -> x.getId().equals(id)).findFirst()
                    .orElseThrow(NoSuchElementException::new);

            department.setDepartmentName(newDepartment.getDepartmentName());
            department.setId(newDepartment.getId());
            department.setDoctors(newDepartment.getDoctors());
            return department.toString() + " succesfully updated!";
        } catch (NoSuchElementException e) {
            return "department with " + id + "not found !";
        }
    }

}





