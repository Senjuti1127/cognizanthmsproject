package net.cts.hms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.cts.hms.dto.LoginDto;
import net.cts.hms.dto.RegisterDto;
import net.cts.hms.entity.User;
import net.cts.hms.repository.UserRepository;
 
@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterDto registerDto) throws IllegalArgumentException{
		System.out.println("recieved request for REGISTER USER");
		System.out.println(registerDto);
		User user = new User();
		user.setEmailId(registerDto.getEmailId());
		user.setFirstName(registerDto.getFirstName());
		user.setLastName(registerDto.getLastName());
		user.setPassword(registerDto.getPassword());
		if(registerDto.getRole()!=null && (registerDto.getRole().equalsIgnoreCase("admin") || registerDto.getRole().equalsIgnoreCase("user")))
		user.setRole(registerDto.getRole());
		else
			throw new IllegalArgumentException("Invalid role");

		User addUser = userRepository.save(user);
		System.out.println("response sent!!!");
		return ResponseEntity.ok(addUser);
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
		System.out.println("recieved request for LOGIN USER");
		System.out.println(loginDto);
		User user = new User();
		user = userRepository.findByEmailIdAndPasswordAndRole(loginDto.getEmailId(), loginDto.getPassword(), loginDto.getRole());
		System.out.println("response sent!!!");
		return ResponseEntity.ok(user);
	}

}
