package com.example.demo.controllers;

import javax.validation.constraints.NotNull;

import com.example.demo.database.RegisterDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private final RegisterDatabase registerDatabase;

	public HomeController(@NotNull final RegisterDatabase registerDatabase) {
		super();
		this.registerDatabase = registerDatabase;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(final Model model) {
		model.addAttribute("message", "Hello, world!");
		model.addAttribute("registers", this.registerDatabase.list());
		return "index";
	}
}