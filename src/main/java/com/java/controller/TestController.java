package com.java.controller;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.SedexTokenResponse;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping
	public ResponseEntity<String> getFuncation(){
		checkVendorAPI();
		return new ResponseEntity<String>("This is the test url",HttpStatus.OK);
	}
	
	public String testFuncation(){
		return "This is the test url";
	}

	public String checkVendorAPI(){

		String url = "https://sedex-dev-am-gateway.cloud.gravitee.io/sedex-dev/oauth/token?grant_type=client_credentials";
		String username="2ln7BAcEXUjHWP_cjpWRnT0nK-DiB12kyXxRj-1Xo5c";
		String password="t04jExgTLpSXblHxBxPSV7WJ_Dla1rMsMIQxJszDQ-U";

		RestTemplate restTemplate =  new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
      //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	  
	  headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


	  String auth = username + ":" + password;
	  String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(Charset.forName("US-ASCII")));

	  String authHeader = "Basic " + encodedAuth;
	  headers.add("Authorization", authHeader);
	  


      HttpEntity <String> entity = new HttpEntity<String>(headers);
	  

	  ResponseEntity<Object> resulEntity = 
	  restTemplate.postForEntity(url, entity,Object.class, headers);
      
	  System.out.println(resulEntity.getBody());

	  ObjectMapper mapper = new ObjectMapper();
	  try {
		SedexTokenResponse response= mapper.readValue(resulEntity.getBody().toString(), SedexTokenResponse.class);
		System.out.println(response.toString());

	  } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	  }
	  


		System.out.println(resulEntity);

      //restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
  
		return null;

	}

}
