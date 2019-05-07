package com.radt.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.radt.model.Message;
import com.radt.model.Password;
import com.radt.model.User;
import com.radt.repository.MessageRepository;
import com.radt.repository.PasswordRespository;
import com.radt.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordRespository passwordRepository;

	@Autowired
	MessageRepository messageRepository;

	@Test
	public void repositorySavesUser() {
		User user = new User();
		user.setUsername("test");
		user.setEmail("test@gmail.com");

		User result = userRepository.save(user);

		assertEquals(result.getUsername(), "test");
		assertEquals(result.getEmail(), "test@gmail.com");
	}

	@Test
	public void repositorySavesPassword() {
		Password password = new Password();
		password.setPassword("pwd");

		Password result = passwordRepository.save(password);

		assertEquals(result.getPassword(), "pwd");
	}

	@Test
	public void repositorySavesMessage() {

		Message message = new Message();
		message.setMessage("Test Message");

		Message result = messageRepository.save(message);
		assertEquals(result.getMessage(), "Test Message");
	}

}
