package ro.mycode.employeeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity//o sa creeze o tabla in baze de date
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee  implements Comparable<Employee>{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String name;
    private int varsta;

    private String adresa;

    public Employee(String name, int varsta,  String adresa) {
        this.name = name;
        this.varsta = varsta;
        this.adresa = adresa;
    }

    @Override
    public String toString(){
        String text="";
        text+=id+","+name+","+varsta+","+adresa;
        return  text;
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    public int compare(Object o){
        Employee Employee=(Employee)o;

        if(this.varsta> Employee.varsta){
            return  1;
        }else if(this.varsta<Employee.varsta){
            return  0;

        }
        return -1;


    }

}
