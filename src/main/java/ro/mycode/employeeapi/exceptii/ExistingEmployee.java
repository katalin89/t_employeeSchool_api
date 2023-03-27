package ro.mycode.employeeapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.employeeapi.constants.Constants.EMPLOYEE_DUPLICATE;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistingEmployee extends RuntimeException {

    public  ExistingEmployee(){
        super(EMPLOYEE_DUPLICATE);//trebuie facuta constanta
    }
}

/*@ResponseStatus(HttpStatus.BAD_REQUEST)//sa nu arunce eroare de 404,va arunca Bad_request
public class ExceptieMasinaDBEmpty extends  RuntimeException{
    public ExceptieMasinaDBEmpty(){
        super(EMPTY_DATABASE_EXCEPTION);
    }
}*/
