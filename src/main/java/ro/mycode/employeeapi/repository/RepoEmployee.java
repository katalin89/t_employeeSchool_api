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

    @Transactional
    @Modifying
    @Query("delete from Employee  e where e.name like ?1")
    void deleteEmployeeByName(String name);

    @Transactional
    @Modifying
    @Query("delete  from Employee  e where e.id=?1")
    void deleteById(int id);

    Employee findByName(String name);

    @Transactional
    @Modifying
    @Query("select  distinct  e from Employee  e order by e.name")
    List<Employee>sortByName();

    @Transactional
    @Modifying
    @Query("select  distinct  e from Employee e order by e.varsta ")
    List<Employee>sortByVarsta();

    @Transactional
    @Modifying
    @Query("select distinct e from Employee e order by e.adresa")
    List<Employee>sortByAdresa();
}
