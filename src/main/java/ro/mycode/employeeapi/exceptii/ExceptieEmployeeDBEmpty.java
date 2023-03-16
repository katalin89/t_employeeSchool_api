package ro.mycode.employeeapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.employeeapi.constants.Constatnts.EMPTY_DATABASE_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptieEmployeeDBEmpty extends  RuntimeException{
    public  ExceptieEmployeeDBEmpty(){
        super(EMPTY_DATABASE_EXCEPTION);
    }
}
