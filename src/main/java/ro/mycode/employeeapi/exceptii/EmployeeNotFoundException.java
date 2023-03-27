package ro.mycode.employeeapi.exceptii;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.employeeapi.constants.Constants.EMPLOYEE_NOT_FOUND_EXCEPTION;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super(EMPLOYEE_NOT_FOUND_EXCEPTION);

    }
}
