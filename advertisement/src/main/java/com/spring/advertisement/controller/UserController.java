package com.spring.advertisement.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.advertisement.entity.Advertise;
import com.spring.advertisement.entity.User;
import com.spring.advertisement.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@RequestMapping(value="register", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody String createUser(@RequestBody User  userData) throws JsonProcessingException{
		User user=new User(userData.getFirstName(),userData.getLastName(), userData.getUserName(), userData.getPassword(),userData.getEmail(), userData.getPhone());
		user=userService.createUser(user);
		JSONObject json = new JSONObject();
	    json.put("message", "Registration successful");
		return json.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value="login", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody String login(@RequestBody Map<String, String>  userData) throws JsonProcessingException{
		String auth_token=userService.login(userData.get("userName"), userData.get("password"));
		JSONObject json = new JSONObject();
	      json.put("auth-token", auth_token);
	      json.put("userName", userData.get("userName"));
	      return json.toString();
	}
	
	@CrossOrigin
	@RequestMapping(value="categories", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody String getCategories() throws JsonProcessingException{
		String str= userService.getCategories();
		return str;
	}
	
	@RequestMapping(value="actions", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody String getActions() throws JsonProcessingException{
		String str= userService.getActions();
		return str;
	}
	
	@CrossOrigin
	@RequestMapping(value="logout", method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String logout(@RequestHeader(value="auth-token") String auth_token) throws JsonProcessingException {
		System.out.println("authToken = " + auth_token);
		return userService.logout(auth_token);
	}
	
	@CrossOrigin
	@RequestMapping(value="postAd", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody String postAd(@RequestBody Advertise  ad,
			@RequestHeader(value="auth-token") String auth_token) {
		Advertise adToPost=new Advertise(ad.getTitle(),ad.getName(), ad.getCategory(), ad.getDescription() );
		String res= userService.postAd(adToPost, auth_token);
		System.out.println("advertise: "+ad);
		JSONObject json = new JSONObject();
	    json.put("Status",res);
	    return json.toString();
	}
	
}
