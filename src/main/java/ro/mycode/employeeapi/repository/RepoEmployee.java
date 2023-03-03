package ro.mycode.employeeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.employeeapi.model.Employee;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RepoEmployee  extends JpaRepository<Employee,Long> {
    @Query("select distinct e.name from Employee e")
    List<String>getAllNames();

    @Query
    List<Employee>getAllEmployeeByName(String name);

//    @Transactional
//    @Modifying
//    @Query
}
