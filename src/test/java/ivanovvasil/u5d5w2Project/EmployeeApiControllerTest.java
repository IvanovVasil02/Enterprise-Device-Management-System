package ivanovvasil.u5d5w2Project;

import com.fasterxml.jackson.databind.ObjectMapper;
import ivanovvasil.u5d5w2Project.controllers.EmployeeController;
import ivanovvasil.u5d5w2Project.payloads.NewEmployeeDTO;
import ivanovvasil.u5d5w2Project.services.EmployeesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(EmployeeController.class)
public class EmployeeApiControllerTest {
  private static final String ENDPOINT = "/employees";

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;
  @MockBean
  private EmployeesService employeesService;

  @Test
  public void testSaveWrongsEmployerReturnBadRequest() throws Exception {
    NewEmployeeDTO newEmployeeDTO = new NewEmployeeDTO("", "ivanov", "asd@asdasd.com", "asd");

    String requestBody = objectMapper.writeValueAsString(newEmployeeDTO);
    mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
}
