package com.example.jewelryshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 1. Bizim fırlattığımız standart hataları yakalayan kısım (Örn: "Ürün bulunamadı!")
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now()) // İşte zaman damgasını buraya bağladık!
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // 2. DTO Validasyon hatalarını şıklaştıran kısım (Örn: "Fiyat eksi olamaz!")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Hangi alanda (isim, fiyat vs.) ne hatası yapıldığını bulup listeliyoruz
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}