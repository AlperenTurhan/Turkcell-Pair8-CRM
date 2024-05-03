package com.turkcell.pair8.core.exception.handlers;

import com.turkcell.pair8.core.exception.details.BusinessProblemDetails;
import com.turkcell.pair8.core.exception.details.ProblemDetails;
import com.turkcell.pair8.core.exception.details.ValidationProblemDetails;
import com.turkcell.pair8.core.exception.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException)
    {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(businessException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setErrors(errors.toArray(new String[0]));
        return problemDetails;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleOtherExceptions()
    {
        return new ProblemDetails("Internal Server Error", "An unexpected error occurred", "https://turkcell.com/exceptions/internal-server-error");
    }
}