package com.portal.exercise.day2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Variable {
	@Value("${var}")
	private String name;
	@GetMapping("/variable")
	public String display()
	{
		return name;
	}
}
