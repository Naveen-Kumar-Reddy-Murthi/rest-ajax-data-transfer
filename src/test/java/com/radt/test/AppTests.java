package com.radt.test;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radt.SpringBootWebApplication;
import com.radt.controller.RADTController;
import com.radt.model.Message;
import com.radt.model.Password;
import com.radt.model.User;
import com.radt.repository.MessageRepository;
import com.radt.repository.PasswordRespository;
import com.radt.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(RADTController.class)
@ContextConfiguration(classes = SpringBootWebApplication.class)
public class AppTests {
	

	@Autowired
	private MockMvc mvc;

	@MockBean
	private MessageRepository messageRepository;

	@MockBean
	private PasswordRespository passwordRepository;

	@MockBean
	private UserRepository userRepository;
	
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getTextTest() throws Exception {
		mvc.perform(get("/api/v1/getText/{text}", "test123")).andExpect(status().isOk())
				.andExpect(content().string("test123"));

	}

	@Test
	public void saveMessageTest() throws Exception {

		Message mesage = new Message(1l, "This is a test message", new Date());

	
		String content = mapper.writeValueAsString(mesage);

		given(messageRepository.save(mesage)).willReturn(mesage);
		mvc.perform(MockMvcRequestBuilders.post("/api/v1/msg/save").contentType(MediaType.APPLICATION_JSON)
				.content(content).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string("Message Saved Successfully"));

	}
	
	@Test
	public void savePasswordTest() throws Exception {

		Password password = new Password(1l,"nave121212", new Date());
		String content = mapper.writeValueAsString(password);
		
		given(passwordRepository.save(password)).willReturn(password);
		mvc.perform(MockMvcRequestBuilders.post("/api/v1/pwd/save").contentType(MediaType.APPLICATION_JSON)
				.content(content).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string("Password saved successfully"));

	}
	
	@Test
	public void saveUserTest() throws Exception {

		User user = new User(1l,"test","test@hotmail.com","xyz","can","222.56","459.67","22",new Date() );
		
		String content = mapper.writeValueAsString(user);
		
		System.out.println("content = "+content);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		
		given(userRepository.findAll()).willReturn(userList);
		mvc.perform(MockMvcRequestBuilders.post("/api/v1/user/save").contentType(MediaType.APPLICATION_JSON)
				.content(content).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andDo(print());

	}
	

}
