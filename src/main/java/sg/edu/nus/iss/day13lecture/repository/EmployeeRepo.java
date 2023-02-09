package sg.edu.nus.iss.day13lecture.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day13lecture.model.Employee;

@Repository
public class EmployeeRepo {

    private List<Employee> employees;

    public EmployeeRepo() throws ParseException {
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date dt = df.parse("1995-12-29");
        Employee emp = new Employee("Mahesan", "Elangovan", "blahblah@gmail.com", "91234567", 5500, dt, "10 Ghim Moh",
                510010);
        employees.add(emp);

        dt = df.parse("1995-07-14");
        emp = new Employee("Jack", "Daniel", "jackdaniel@gmail.com", "80994455", 123456, dt, "99 bedok south ave",
                459099);

        employees.add(emp);

    }

    public List<Employee> findAll() {
        return employees;
    }

    public Boolean save(Employee employee) {
        Boolean result = employees.add(employee);
        return result;
    }

    public Boolean delete(Employee employee) {
        // employees.stream().filter(emp ->
        // emp.getEmail().equalsIgnoreCase(employee.getEmail())).findFirst().get();

        Boolean result = false;
        int employeeIndex = employees.indexOf(employee);

        if (employeeIndex >= 0) {
            employees.remove(employeeIndex);
            result = true;
        }
        return result;
    }

    public Employee findbyEmailId(String email){
        Employee emp = employees.stream().filter(e->e.getEmail().equals(email)).findFirst().get();
        return emp;
    }

    public Boolean updateEmployee(Employee em) {
        Employee emp = employees.stream().filter(e -> e.getEmail().equals(em.getEmail())).findFirst().get();

        int employeeIndex = employees.indexOf(emp);

        if (employeeIndex >= 0) {
            // employees.remove(employeeIndex);

            employees.get(employeeIndex).setAddress(em.getAddress());
            employees.get(employeeIndex).setBirthDay(em.getBirthDay());
            employees.get(employeeIndex).setFirstName(em.getFirstName());
            employees.get(employeeIndex).setLastName(em.getLastName());
            employees.get(employeeIndex).setSalary(em.getSalary());
            employees.get(employeeIndex).setPhoneNo(em.getPhoneNo());
            employees.get(employeeIndex).setPostalCode(em.getPostalCode());
        }

        // employees.add(em);

        return true;
    }
}
