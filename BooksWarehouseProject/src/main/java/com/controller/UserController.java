package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AddressRepository;
import com.model.Address;
import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/registration")
	public User registerUser(@RequestBody User u) {

		return userService.registerUse(u);
	}

	@GetMapping("/findId/{id}") public User loginUser(@PathVariable ("id") long id){

		return userService.findUserById(id); }


	@PostMapping("/login/{username}/{password}")
	public ResponseEntity<String> login(@PathVariable("username") String username ,@PathVariable("password") String password) {

		boolean checkStatus =  userService.loginCredentials(username,password);

		if(checkStatus == true) {

			return ResponseEntity.status(HttpStatus.OK).header("found","sucessfully logged in").body("logged in sucessfully") ;
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Login Credentials");

		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){

		userService.delete(id);

		return ResponseEntity.status(HttpStatus.OK).header("found","sucessfully deleted").body("deleted user") ;
	}



	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable("id") long id,@RequestBody User u ){

		User user = userService.updateUser(id, u);
		if(user != null)

			return ResponseEntity.status(HttpStatus.OK).header("updated").body("sucessfully updation done");

		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("error").body("failed updation");
		}
	}


	// Adderss operations 
}