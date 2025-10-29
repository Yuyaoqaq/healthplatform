package com.cy.healthplat.common.handler;

import com.cy.healthplat.common.util.Result;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleParamValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        String errorMsg = bindingResult.getFieldError().getDefaultMessage();
        return Result.fail(400,errorMsg);
    }
}
