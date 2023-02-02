package sh.hutch.innablr.challenge.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StatusControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnApplicationInfo() throws Exception {
    this.mockMvc.perform(get("/status"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.my-application").isArray())
        .andExpect(jsonPath("$.my-application[0].version").value("1.0"))
        .andExpect(jsonPath("$.my-application[0].description")
            .value("my-application description"))
        .andExpect(jsonPath("$.my-application[0].sha").value("TO_BE_SET"));
  }

}
