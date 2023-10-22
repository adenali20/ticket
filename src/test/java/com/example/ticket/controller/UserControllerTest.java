package com.example.ticket.controller;


import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserControllerTest {
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    private MockMvc mockMvc;
//    @BeforeEach
//    public void setup() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
//    }
//
//    @Test
//    public void test_valid_input() throws Exception {
//        User user=new User("dfdf","1-12-2012");
//        mockMvc.perform(post("/greeting")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(user))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andReturn();
//    }
//
//    @Test
//    public void test_invalid_name() throws Exception {
//        User user=new User("","1-12-2012");
//
//        mockMvc.perform(post("/greeting")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(user))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("name").value("must not be empty"))
//
//                .andExpect(status().is4xxClientError()).andReturn();
//    }
//
//    @Test
//    public void test_invalid_invalid_date() throws Exception {
//        User user=new User("dfdf","1-12-2012g");
//        mockMvc.perform(post("/greeting")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(user))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is4xxClientError())
//                .andExpect(jsonPath("name").value("must not be empty"))
//                .andExpect(jsonPath("date").value("invalid date must be mmddy"))
//                .andReturn();
//    }
//
//    @Test
//    public void test_invalid_invalid_date_name() throws Exception {
//        User user=new User("","1-12-2012g");
//        mockMvc.perform(post("/greeting")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(user))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("name").value("must not be empty"))
//                .andExpect(jsonPath("date").value("invalid date must be mmddy"))
//                .andExpect(status().is4xxClientError()).andReturn();
//    }


}