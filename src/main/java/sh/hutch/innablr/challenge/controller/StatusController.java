package sh.hutch.innablr.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sh.hutch.innablr.challenge.config.ApplicationDetails;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StatusController {

  @Value("${appinfo.name}")
  private String applicationName;
  private ApplicationDetails appDetails;

  @Autowired
  public StatusController(ApplicationDetails appDetails) {
    this.appDetails = appDetails;
  }

  @GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
  public Map<String, List<ApplicationDetails>> getStatus() {
    var details = new HashMap<String, List<ApplicationDetails>>();
    details.put(applicationName, Arrays.asList(appDetails));
    return details;
  }


}
