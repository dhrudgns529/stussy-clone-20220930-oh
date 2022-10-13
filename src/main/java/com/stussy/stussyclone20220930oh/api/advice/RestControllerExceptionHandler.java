package com.stussy.stussyclone20220930oh.api.advice;

import com.stussy.stussyclone20220930oh.dto.CMRespDto;
import com.stussy.stussyclone20220930oh.exception.CustomInternalServerErrorException;
import com.stussy.stussyclone20220930oh.exception.CustomValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class) // 이 예외가 발생하면.
    public ResponseEntity<?> validationErrorException(CustomValidationException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

    @ExceptionHandler(CustomInternalServerErrorException.class) // 이 예외가 발생하면.
    public ResponseEntity<?> internalServerErrorException(CustomInternalServerErrorException e) {
        // 500 에러 - 서버 에러
        return ResponseEntity.internalServerError().body(new CMRespDto<>(e.getMessage(), null));
    }
}
