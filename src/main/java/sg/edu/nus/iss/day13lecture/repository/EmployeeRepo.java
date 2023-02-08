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

        DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        Date dt = df.parse("29-12-1995");
        Employee emp = new Employee("Mahesan", "Elangovan", "blahblah@gmail.com", "91234567", 5500, dt, "10 Ghim Moh",
                510010);

        dt = df.parse("14-07-1995");
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
        //employees.stream().filter(emp -> emp.getEmail().equalsIgnoreCase(employee.getEmail())).findFirst().get();

        Boolean result = false;
        int employeeIndex = employees.indexOf(employee);

        if(employeeIndex >=0) {
            employees.remove(employeeIndex);
            result = true;
        }
        return result;
    }
}