package com.controller;

import com.dao.UserDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(loginController.class)
class loginControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    UserDao userDao;

    @Test
    public void testLogin() throws Exception {
        String JSON = "{\"name\":\"王小二\",\"psw\":\"1234\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/login")
                .accept(MediaType.APPLICATION_JSON).content(JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
        String expected = "{\"message\":\"登录成功\",\"code\":\"200\"}";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }
}
