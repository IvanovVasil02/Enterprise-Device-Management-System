package ivanovvasil.u5d5w2Project;

import com.fasterxml.jackson.databind.ObjectMapper;
import ivanovvasil.u5d5w2Project.controllers.EmployeeController;
import ivanovvasil.u5d5w2Project.entities.Employee;
import ivanovvasil.u5d5w2Project.exceptions.NotFoundException;
import ivanovvasil.u5d5w2Project.payloads.NewEmployeeDTO;
import ivanovvasil.u5d5w2Project.services.EmployeesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
  private static final String ENDPOINT = "/employees";

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;
  @MockBean
  private EmployeesService employeesService;

  @Test
  public void testSaveWrongsEmployeerReturnBadRequest() throws Exception {
    NewEmployeeDTO newEmployeeDTO = new NewEmployeeDTO("", "ivanov", "asd@asdasd.com", "asd");

    String requestBody = objectMapper.writeValueAsString(newEmployeeDTO);
    mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  public void testSaveEmployeerReturn201() throws Exception {
    NewEmployeeDTO newEmployeeDTO = new NewEmployeeDTO("vasil", "ivanov", "asd@asdasd.com", "asd");

    String requestBody = objectMapper.writeValueAsString(newEmployeeDTO);
    mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  @Test
  public void testGetAllEmployeerReturnOkk() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());

  }

  @Test
  public void testGetEmployeerReturnNotFound() throws Exception {
    int userId = -1;
    Mockito.when(employeesService.findById(userId)).thenThrow(NotFoundException.class);
    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT + "/" + userId)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  public void testGetEmployeerReturnOk() throws Exception {
    int employeeId = 2;

    Mockito.when(employeesService.findById(2)).thenReturn(Employee.builder().build());

    mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT + "/" + employeeId)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
  }
}
