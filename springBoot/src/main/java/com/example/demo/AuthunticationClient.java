package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("Authenticator")
public interface AuthunticationClient {
	@RequestMapping(method = RequestMethod.POST,value="/verifyemails")
	public ResponseEntity<String> validateEmail(@RequestBody String email);

}
