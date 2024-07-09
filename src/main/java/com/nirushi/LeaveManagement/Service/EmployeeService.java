package com.nirushi.LeaveManagement.Service;

import com.nirushi.LeaveManagement.Entity.Employee;
import com.nirushi.LeaveManagement.Exception.EmployeeNotFoundException;
import com.nirushi.LeaveManagement.Exception.FileUploadException;
import com.nirushi.LeaveManagement.Repository.EmployeeRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhone(employeeDetails.getPhone());
        employee.setHireDate(employeeDetails.getHireDate());
        employee.setPosition(employeeDetails.getPosition());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }


    public void saveEmployeesFromCsv(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // Skip header
//            if (reader.readNext() != null){
//                System.out.println("Errorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
//            }
//            else {
//                System.out.println("tttttttttttttttttttttttt");
//            }
            while ((line = reader.readNext()) != null) {
                Employee employee = new Employee();
                employee.setFirstName(line[0]);
                employee.setLastName(line[1]);
                employee.setEmail(line[2]);
                employee.setPhone(line[3]);
                employee.setHireDate(parseDate(line[4]));
                employee.setPosition(line[5]);
                employeeRepository.save(employee);
            }
        } catch (IOException | CsvValidationException | ParseException e) {
            throw new FileUploadException("Error processing CSV file", e);
        }
    }

    private Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(dateStr);
    }
}
