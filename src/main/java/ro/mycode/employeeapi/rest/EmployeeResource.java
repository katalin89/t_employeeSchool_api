package ro.mycode.employeeapi.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.employeeapi.dtos.EmployeeDTO;
import ro.mycode.employeeapi.model.Employee;
import ro.mycode.employeeapi.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin
public class EmployeeResource {

    private EmployeeService employeeService;

    public  EmployeeResource(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>>getAllEmployee(){
        List<Employee> allEmployee=employeeService.getAllEmployee();
        return  new ResponseEntity<>(allEmployee, HttpStatus.OK);

    }

    @DeleteMapping("/deleteByName/{name}")
    ResponseEntity deleteByName(@PathVariable String nume){
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public  ResponseEntity addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@Valid @RequestBody EmployeeDTO employee, String name){
        this.employeeService.update(employee,name);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
