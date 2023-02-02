package sh.hutch.innablr.challenge.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The IndexController is so named as it is intended to contain operations that
 * sit in the root (/) namespace for the API.
 */
@RestController
public class IndexController {


  @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
  public String index() {
    return "Hello World!";
  }
}
