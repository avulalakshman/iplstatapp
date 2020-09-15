package com.careerit.iplstatapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

		@GetMapping({"/","/hello"})
		public String message() {
			return "Hello world";
		}
}
