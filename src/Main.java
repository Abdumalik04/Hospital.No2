public class Main {
    public static void main(String[] args) {


       /* 1)  Оорукана тууралу бир программа жазыныз. Dao жана Service менен иштешкиле (ар бир класстын dao жана service interface'тери жана ошол interface'ти implements класстары болуш керек). Database деген класс ачып, ичинде бардык маалыматтарды сактаган маалымат структурасы болсун(List<Hospital> hospitals).
        2) Класстар:
        * Hospital (Long id, String hospitalName, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients),
        * Department (Long id, String departmentName, List<Doctor> doctors),
        * Doctor (Long id, String firstName, String lastName, Gender gender, int experienceYear),
        * Patient (Long id, String firstName, String lastName, int age, Gender gender);
        3) Gender enum.
        4)
        PatientDao:
        String addPatientToHospital(Long id, Patient patient);
        String addPatientsToHospital(Long id,List<Patient> patients);
        String updatePatientById(Long id, Patient patientsNewInfo);
        void removePatientById(Long id);
        Patient getPatientById(Long id);
        Map<Integer, Patient> getPatientByAge();
        List<Patient> sortPatientsByAge(String ascOrDesc);
        DepartmentDao:
        String addDepartmentToHospital(Long id, Department department);
        List<Department> getAllDepartmentByHospital(Long id);
        Department findDepartmentByName(String name);
        void deleteDepartmentById(Long id);
        String updateDepartmentById(Long id, Department department);
        DoctorDao:
        String addDoctorToHospital(Long id, Doctor doctor);
        Doctor findDoctorById(Long id);
        String updateDoctor(Long id, Doctor doctor);
        void deleteDoctorById(Long id);
        // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган
        // Department'ге табылган Doctor'лорду кошуп коюнунуз
        String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
        List<Doctor> getAllDoctorsByHospitalId(Long id);
        List<Doctor> getAllDoctorsByDepartmentId(Long id);
        HospitalDao :
        String addHospital(Hospital hospital);
        Hospital findHospitalById(Long id);
        List<Hospital> getAllHospital();
        List<Patient> getAllPatientFromHospital(Long id);
        String deleteHospitalById(Long id);
        Map<String, Hospital> getAllHospitalByAddress(String address);
:белая_галочка:
        4

*/
    }
}