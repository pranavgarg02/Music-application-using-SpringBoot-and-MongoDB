package com.example.demo.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@RestController
@RequestMapping("/serviceA") 
public class ControllerA {
	 
	    @GetMapping("/displayMessage") 
	    public ResponseEntity<String> showMessage(){ 
	        return ResponseEntity.ok("MusicFileMinIO controller executed"); 
	    } 
	} 
