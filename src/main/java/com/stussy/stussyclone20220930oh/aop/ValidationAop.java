package com.stussy.stussyclone20220930oh.aop;

import com.stussy.stussyclone20220930oh.exception.CustomValidationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component // di, ioc 개념 필수
public class ValidationAop {

    // 맨 앞 *은 타입 ..은 하위 폴더 *은 모든 메서드
    @Pointcut("execution(* com.stussy.stussyclone20220930oh.api.AccountApi.*(..))")
    private void executionPointCut() {}

    @Pointcut("@annotation(com.stussy.stussyclone20220930oh.aop.annotation.ValidAspect)")
    private void annotationPointCut() {}

    @Around("executionPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class){ // instanceof 쓰면 쉬우나.. 19버전에서 사라질 예정.
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            throw new CustomValidationException("Validation Error", errorMap);
        }

        Object result = null;
        result = joinPoint.proceed();

        return result;
    }
}
