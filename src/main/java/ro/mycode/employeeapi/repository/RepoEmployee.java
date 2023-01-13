package ro.mycode.employeeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.employeeapi.model.Employee;

@Repository
public interface RepoEmployee  extends JpaRepository<Employee,Long> {
}
