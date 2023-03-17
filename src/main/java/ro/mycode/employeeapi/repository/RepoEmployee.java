package ro.mycode.employeeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.employeeapi.model.Employee;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Repository
//public interface MasinaRepo extends JpaRepository<Masina, Long> {
@Repository
public interface RepoEmployee  extends JpaRepository<Employee,Long> {
    @Query("select distinct e.nume from Employee e")
    List<String>getAllNames();

    @Query("select e from Employee e where e.nume=?1")
    List<Employee>getAllEmployeeByName(String nume);



    @Transactional
    @Modifying
    @Query("delete from Employee  e where e.nume like ?1")
    void deleteEmployeeByName(String name);

    @Transactional
    @Modifying
    @Query("delete  from Employee  e where e.id=?1")
    void deleteById(int id);

    Optional<Employee> findByNume(String name);

    @Transactional
    @Modifying
    @Query("select  distinct  e from Employee  e order by e.nume")
    List<Employee>sortByName();

    @Transactional
    @Modifying
    @Query("select  distinct  e from Employee e order by e.varsta ")
    List<Employee>sortByVarsta();

    @Transactional
    @Modifying
    @Query("select distinct e from Employee e order by e.adresa")
    List<Employee>sortByAdresa();


    @Transactional
    @Modifying
    @Query ("select  e from Employee  e where e.nume=?1  and e.adresa=?2")
    List<Employee>findEmployeeWith(String nume,String adresa);


}
