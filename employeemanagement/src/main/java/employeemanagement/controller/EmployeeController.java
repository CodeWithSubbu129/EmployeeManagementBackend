package employeemanagement.controller;

import employeemanagement.model.Employee;
import employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getListOfEmployee(){
        return employeeService.getAllemployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }
}
