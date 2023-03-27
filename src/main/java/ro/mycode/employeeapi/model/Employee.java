package ro.mycode.employeeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Entity//o sa creeze o tabla in baze de date
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee  implements Comparable<Employee>{
    @Id
    @SequenceGenerator(name="employee_sequence",sequenceName = "employee_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")

    private Long id;

    @Column(name="name",nullable = false)
    @Size(min=4,message="Numele trebuie sa aiba cel putin 4 caractere")
    private String name;

    @Column (name="varsta",nullable=false)
    @Min(value=2,message = "Persoana trebuie sa fie min 12 ani")
    private int varsta;

    @Column
    @Size(max=50,message = "Adresa nu poate fi mai lung de 50 de caractere")
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
        if(this.name.compareTo(o.name)>0){
            return 1;
        }
        if(this.name.compareTo(o.name)<0){
            return  -1;
        }else

        return 0;
    }

    @Override
    public  boolean equals(Object o){
        Employee employee=(Employee)o;
        return  this.name.equals(employee.name);
    }
}
