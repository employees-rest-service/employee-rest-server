package spring.rest.employee.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectResponse> handleException(NoSuchEmployeeException exception) {
        return getResponseEntity(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectResponse> handleException(Exception exception) {
        return getResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<IncorrectResponse> getResponseEntity(Exception exception, HttpStatus status) {
        IncorrectResponse incorrectResponse = new IncorrectResponse();
        incorrectResponse.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectResponse, status);
    }

}
