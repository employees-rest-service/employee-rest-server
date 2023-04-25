package spring.rest.employee.controllers;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerUtils {
    public static Map<String,String> valid(BindingResult result){
        return result.hasErrors() ?
                result.getFieldErrors().stream().collect(Collectors.toMap(
                        errorKey -> "error_" + errorKey.getField(),
                        errorValue -> errorValue.getDefaultMessage() != null ? errorValue.getDefaultMessage() : ""))
                : new HashMap<>();
    }
}
