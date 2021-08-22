package com.appdevlopment.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.appdevlopment.app.ws.exceptions.UserServiceException;
import com.appdevlopment.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appdevlopment.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appdevlopment.app.ws.ui.model.responce.UserRest;
import com.appdevlopment.app.ws.userservice.UserService;
import com.appdevlopment.app.ws.userservice.impl.UserServiceImpl;
/*
 * @RestController will register this class as a RestController and it will able to receive the
 * requests when they get send and match the url path
 * 
 * @RequestMapping:- When http request send it send it on a particular url path.
 * UserController will be responsible for all the operations performed on and by the user
 */

@RestController

@RequestMapping("users")   //http://localhost:8080/users
public class UserController {
	
	Map<String,UserRest> users;
	
	@Autowired
	UserService userService;
	
	/*
	 * to make the getUser respond to http Get request we need to bind the getUser method to
	 * http GET request, for that the @GetMapping annotation is used and similarly @PostMapping,@PutMapping
	 * and @DeleteMapping are used.
	 */
	
	
	/*
	 * when http GET request sends on "http://localhost:8080/users" path only this method gets called.
	 * required is not use for the primitive data type it will gave an error that's why String parameter is used.
	 */
	@GetMapping()
	public String getUser(@RequestParam(value="page",defaultValue = "1") int page,
			@RequestParam(value="limit",defaultValue = "50") int limit,
			@RequestParam(value="sort", defaultValue = "desc",required=false) String sort)
	{
		return "getUsers was called with page:  "+page+" and limit: "+limit+" sort: "+sort;
	}
	
	/*
	 * here, binding i create to bind userId to the "http://localhost:8080/users" path
	 * And @PathVariable annotation is used to access that userId to the class.
	 * MediaType(returning as XML or JSON
	 * ResponseEntity is use for returning Different Status codes.
	 */
	@GetMapping(path="/{userId}",produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId)
	{
		/*UserRest returnValue=new UserRest();
		returnValue.setFirstName("Ram");
		returnValue.setLastName("Varma");
		returnValue.setEmail("test@test.com");
		returnValue.setPassword("*****");
		returnValue.setUserId(userId);
		*/
		
		
		//For Exception Handaling purpose...
		/*
		 String firstName=null;
		 int namelength=firstName.length(); 
		*/
		
		//for userSerivceException
		if(true) throw new UserServiceException("A user Service Exception");
		
		if(users.containsKey(userId))
		{
			return new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT );
		}
		
		
	}
	
	@PostMapping(consumes= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	},produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
	{
		UserRest returnValue=userService.createUser(userDetails); 
		
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
		
	}
	
	@PutMapping(path="/{userId}",
			consumes= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			},produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public UserRest updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails)
	{
		UserRest storedUserDetails=users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userId,storedUserDetails);
		return storedUserDetails;
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id)
	{
		users.remove(id);
		return ResponseEntity.noContent().build();
		
	}

}
