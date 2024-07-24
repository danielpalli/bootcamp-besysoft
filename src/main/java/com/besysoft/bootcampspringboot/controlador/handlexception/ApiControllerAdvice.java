package com.besysoft.bootcampspringboot.controlador.handlexception;

import com.besysoft.bootcampspringboot.dto.response.ExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class ApiControllerAdvice {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO exceptionHandler(MethodArgumentNotValidException ex) {
        List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
        Map<String, String> detalle = new HashMap<>();

        errorList.forEach(e -> {
            log.error("Error en: " + e.getField() + ", " + e.getDefaultMessage());
            detalle.put(e.getField(), e.getDefaultMessage());
        });

        return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), "Validaciones", detalle);
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO isExistException(Exception ex) {
        return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
    }
}
