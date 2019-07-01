package com.myco.div.unit.restwebservices.user;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {
	// retrieveallusers
	// GET /users
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() throws NoUsersFoundException{
		List<User> userlist = service.findAll();
		if(userlist.size()<1) {
			throw new NoUsersFoundException("No Users found");
		}

		return userlist;
		}
	
	@GetMapping("/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id) throws NoUsersFoundException {
		
		User user = service.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("id - "+ id);
		}
		
		//HATEOAS -- HyperMedia as the engine of application state
		//all-users,serverpath,/users
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		
		return  resource;
	}
	
	//Created
	//Input = details of user
	//Output= Created and return uri;
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
		 
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		
		User user = service.deleteById(id);
		
		if(user == null) {
			throw new UserNotFoundException("id - "+ id);
		}
		
		
	}

}
