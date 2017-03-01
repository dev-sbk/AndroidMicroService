package com.android.server.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class Home {
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index() {
		return "home";
	}
}
