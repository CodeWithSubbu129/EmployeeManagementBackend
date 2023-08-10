package employeemanagement.service;

import employeemanagement.exception.ResourceNotFound;
import employeemanagement.model.Employee;
import employeemanagement.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllemployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employee Not Found with Id: " + id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

    public ResponseEntity<Employee> updateEmployee(int id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Employee Not Found with Id: " + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setGender(employeeDetails.getGender());
        employee.setDateOfBirth(employeeDetails.getDateOfBirth());
        employee.setVocals(employeeDetails.getVocals());
        employee.setInstruments(employeeDetails.getInstruments());
        employee.setAddress(employeeDetails.getAddress());
        employee.setPaymentMode(employeeDetails.getPaymentMode());
        employee.setMobileNr(employeeDetails.getMobileNr());
        employee.setDateOfJoining(employeeDetails.getDateOfJoining());
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);

    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
