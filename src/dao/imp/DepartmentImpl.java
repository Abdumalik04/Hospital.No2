package dao.imp;

import dao.DepartmentDao;
import database.Database;
import model.Department;
import model.Hospital;

import java.util.ArrayList;
import java.util.List;


public class DepartmentImpl implements DepartmentDao {
    Database database = new Database();


    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        for (Hospital hospital : database.getHospitals())
            if (hospital.getId().equals(id)) {
                hospital.getDepartments().add(department);
                return "Successfully added department";

            }
        return null;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        List<model.Department> departments = new ArrayList<>();
        for (Hospital hospital : database.getHospitals()) {
            if (hospital.getId() == id) {
                departments.addAll(hospital.getDepartments());
            }
        }
        return departments;
    }

    @Override
    public Department findDepartmentByName(String name) {
        return database.getDepartments().stream().filter(x -> x.getDepartmentName().equals(name)).findFirst().get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        Department department = database.getDepartments().stream().filter(x -> x.getId().equals(id)).findFirst().get();
        database.getDepartments().remove(department);

    }

    @Override
    public String updateDepartmentById(Long id, Department newDepartment) {
        for (Hospital h : database.getHospitals()) {
            for (Department d : h.getDepartments()) {
                if (d.getId().equals(id)) {
                    d.setDepartmentName(newDepartment.getDepartmentName());
                    return "Department with id " + id + " successfully updated";

                }

            }

        }
        return null;

    }
}




