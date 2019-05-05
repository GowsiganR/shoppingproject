package com.niit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class navigationController {
@RequestMapping(value="/") 
	public String displayHome() {
	return "index";
	}
@RequestMapping(value="/ShoppinFrontend") 
public String displayHom() {
return "index";
}
}
