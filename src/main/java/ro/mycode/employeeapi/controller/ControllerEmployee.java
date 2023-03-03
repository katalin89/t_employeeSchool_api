package ro.mycode.employeeapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.mycode.employeeapi.model.Employee;
import ro.mycode.employeeapi.repository.RepoEmployee;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerEmployee {


    private RepoEmployee repoEmployee;

    public ControllerEmployee(RepoEmployee repoEmployee) {

        this.repoEmployee = repoEmployee;
    }

    @GetMapping("/api/v1/employee")
    public List<Employee> getAllEmployee(){

        return repoEmployee.findAll();
    }

    @GetMapping("api/v1/employee/name")
    public List<String>getAllName(){
        return  repoEmployee.getAllNames();
    }

    @GetMapping("api/v1/employee/{name}")
    public List<Employee>getAllEmployeeByName(@PathVariable String name){
        return repoEmployee.getAllEmployeeByName(name);
    }
    
    @PostMapping("api/v1/add")
    public  Employee addEmployee(@RequestBody Employee employee){
        this.repoEmployee.save(employee);

        return  employee;
    }
}
