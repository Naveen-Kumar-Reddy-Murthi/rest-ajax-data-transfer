package com.radt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radt.model.Message;
import com.radt.model.Password;
import com.radt.model.User;
import com.radt.repository.MessageRepository;
import com.radt.repository.PasswordRespository;
import com.radt.repository.UserRepository;


@RestController
@RequestMapping("api/v1")
public class RADTController {

	@Autowired
    private MessageRepository messageRepository;
	
	@Autowired
	private PasswordRespository passwordRepository;
	
	@Autowired
	private UserRepository userRepository; 
    
    @GetMapping(path = "getText/{text}" )
    public ResponseEntity<String> getText(@PathVariable String text){
    	
    	 return ResponseEntity.ok(text);
    }
    
    @PostMapping(path = "msg/save")
    public ResponseEntity<String> saveMessage(@RequestBody Message message) {
    	System.out.println("ins msg/save hadler "+ message);
        Message msg =  messageRepository.save(message);
        return ResponseEntity.ok("Message Saved Successfully");
    }

    @PostMapping(path = "pwd/save")
    public ResponseEntity<String> savePassword(@RequestBody Password password) {
        Password pwd =  passwordRepository.save(password);
        return ResponseEntity.ok("Password saved successfully");
    }
    
    @PostMapping(path = "user/save")
    public ResponseEntity<Iterable<User>> saveUser(@RequestBody User user) {
    	User usr =  userRepository.save(user);
    	System.out.println(usr + "is saved to db successfully");
    	System.out.println("findAll returns =>"+userRepository.findAll());
        return ResponseEntity.ok(userRepository.findAll());
    }

}
