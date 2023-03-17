package ro.mycode.employeeapi.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ro.mycode.employeeapi.dtos.EmployeeDTO;
import ro.mycode.employeeapi.exceptii.EmployeeNotFoundException;
import ro.mycode.employeeapi.exceptii.ExceptieEmployeeDBEmpty;
import ro.mycode.employeeapi.exceptii.ExistingEmployee;
import ro.mycode.employeeapi.model.Employee;
import ro.mycode.employeeapi.repository.RepoEmployee;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    private RepoEmployee repoEmployee;

    public EmployeeService(RepoEmployee repoEmployee){
        this.repoEmployee=repoEmployee;
    }

//    public EmployeeService(RepoEmployee repoEmployee) {
//        this.repoEmployee = repoEmployee;
//    }

    public List<Employee> getAllEmployee() throws ExceptieEmployeeDBEmpty {
        List<Employee> employees = repoEmployee.findAll();
        if (employees.size() > 0) {
            return employees;

        }

        throw new ExceptieEmployeeDBEmpty();

    }

    public void deleteEmployeeByName(String name) throws EmployeeNotFoundException {
        Employee byName = repoEmployee.findByNume(name).get();

        if (byName != null) {
            repoEmployee.deleteEmployeeByName(name);
        } else {
            throw new EmployeeNotFoundException();
        }


    }



    @Transactional
    @Modifying

    public void update(@RequestBody EmployeeDTO employee, String name) throws EmployeeNotFoundException {
        Employee e = repoEmployee.findByNume(employee.getNume()).get();

        if (e == null) {
            throw new EmployeeNotFoundException();
        }

        if (employee.getNume().equals("") == false) {
            e.setNume(employee.getNume());
        }

        if (employee.getVarsta() != 0) {
            e.setVarsta(employee.getVarsta());
        }

        if (employee.getAdresa().equals("") == false) {
            e.setAdresa(employee.getAdresa());
        }
    }

    @Transactional
    @Modifying
    public void addEmployee(Employee employee) throws EmployeeNotFoundException {

        List<Employee> employeeWith = repoEmployee.findEmployeeWith(employee.getNume(), employee.getAdresa());

        if (employeeWith.size() > 0) {
            throw new ExistingEmployee();
        }
        this.repoEmployee.saveAndFlush(employee);
    }
}
