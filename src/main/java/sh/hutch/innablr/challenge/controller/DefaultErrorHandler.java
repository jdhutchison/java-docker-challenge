package sh.hutch.innablr.challenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

/**
 * In lieu of any other exception or error handling this error handler will
 * resolve exceptions (of any type) into some vaguely helpful error message.
 */
@ControllerAdvice
public class DefaultErrorHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity onException(Exception e) {
    var errorDetails = new HashMap<String, Object>();
    errorDetails.put("message", e.getMessage());
    errorDetails.put("exception", e.getClass().getName());
    errorDetails.put("stacktrace", e.getStackTrace());
    return ResponseEntity.internalServerError().body(errorDetails);
  }
}
