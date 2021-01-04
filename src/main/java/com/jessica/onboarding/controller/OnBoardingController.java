package com.jessica.onboarding.controller;

import com.jessica.onboarding.model.Pessoa;
import com.jessica.onboarding.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/onboarding")
public class OnBoardingController {

    private final PessoaService service;

    public OnBoardingController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarDados(@Valid @RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(service.save(pessoa), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorField = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(errorField, errorMessage);
        });

        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public String handleValidationExceptions(ValidationException ex) {
        return ex.getMessage();
    }
}
