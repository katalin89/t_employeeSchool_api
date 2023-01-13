package ro.mycode.employeeapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
