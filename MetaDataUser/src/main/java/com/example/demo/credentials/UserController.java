package com.example.demo.credentials;

//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/signup")
	public String createUser(@RequestBody UserCredentials user) {
		UserCredentials newUser = new UserCredentials(user.getFirstname(), user.getLastname(), user.getPassword(),
				user.getUsername(), user.getContact(), user.getEmail());
		userRepository.save(newUser);
		return "SUCCESSFULLY REGISTERED";
	}

	@GetMapping("/getdetails/{username}")
	public ResponseEntity<UserCredentials> details(@PathVariable String username) {
		UserCredentials us = userRepository.findByUsername(username);
		return ResponseEntity.ok().body(us);
	}

	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<UserCredentials> Login(@PathVariable String username, @PathVariable String password)
			throws ResourceNotFoundException {
		UserCredentials existinguser;
		if (userRepository.existsByUsername(username)) {
			existinguser = userRepository.findByUsername(username);
			if (existinguser.getPassword().equals(password)) {
				System.out.println("ACCESSED APPROVED");
			} else
				System.out.println("Access Denied");
		} else
			throw new ResourceNotFoundException("User not found for this data :: " + username);

		return ResponseEntity.ok().body(existinguser);
	}

}
