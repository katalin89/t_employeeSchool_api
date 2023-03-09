package ro.mycode.employeeapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.mycode.employeeapi.dtos.EmployeeDTO;
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
    public List<Employee> getAllEmployee() {

        return repoEmployee.findAll();
    }

    @GetMapping("api/v1/employee/name")
    public List<String> getAllName() {
        return repoEmployee.getAllNames();
    }

    @GetMapping("api/v1/employee/{name}")
    public List<Employee> getAllEmployeeByName(@PathVariable String name) {
        return repoEmployee.getAllEmployeeByName(name);
    }

    @PostMapping("api/v1/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        this.repoEmployee.save(employee);

        return employee;
    }

    @DeleteMapping("api/v1/deleteByName/{name}")
    public String deleteEmployee(@PathVariable String name) {
        this.repoEmployee.deleteEmployeeByName(name);

        return name;
    }

    @DeleteMapping("api/v1/deleteById/{id}")
    public long deleteEmployeeById(@PathVariable long id) {
        this.repoEmployee.deleteById(id);
        return id;
    }

    @PutMapping("api/v1/update")
    public Employee updateEmployee(@RequestBody EmployeeDTO employee) {
        Employee e = repoEmployee.findByName(employee.getName());

        if (employee.getName().equals("") == false) {
            e.setName(employee.getName());
        } else System.out.println("Nu are valoare");
        if (employee.getVarsta() != 0) {
            e.setVarsta(employee.getVarsta());
        } else System.out.println("Nu are valoare");
        if (employee.getAdresa().equals("") == false) {
            e.setAdresa(employee.getAdresa());
        } else System.out.println("Nu are valoare");

        repoEmployee.save(e);
        return e;
    }

    @GetMapping("api/v1/get/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return repoEmployee.findById(Long.valueOf(id)).get();
    }

    @GetMapping("api/v1/sortByVarsta")

    public List<Employee> sortByVarsta() {
        return repoEmployee.sortByVarsta();
    }

    @GetMapping("api/v1/sortByName")
    public List<Employee> sortByName() {
        return repoEmployee.sortByName();
    }

    @GetMapping("api/v1/sortByAdresa")
    public List<Employee> sortByAdresa() {
        return repoEmployee.sortByAdresa();
    }

//    @GetMapping("api/v1/verify")
//    public List<Employee>verify(){
//        return  repoEmployee.verifyIfExists();
//
//    }



}

