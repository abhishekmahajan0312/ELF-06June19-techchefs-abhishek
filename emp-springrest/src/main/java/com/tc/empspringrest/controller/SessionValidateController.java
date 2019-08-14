package com.tc.empspringrest.controller;

import static com.tc.empspringrest.common.EMPConstants.DB_INTERACTION_TYPE;
import static com.tc.empspringrest.common.EMPConstants.PROPERTY_FILENAME;
import static com.tc.empspringrest.common.EMPConstants.VIEW_LOGINPAGE;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validator")
@PropertySource(PROPERTY_FILENAME)
public class SessionValidateController {

	@Qualifier(DB_INTERACTION_TYPE)
	@GetMapping("/validate/{url1}/{url2}")
	public String validate(HttpSession session, ModelMap map, @Value("${invalidSession}") String msg,
			@PathVariable("url1") String url1, @PathVariable("url2") String url2) {
		if (session.isNew()) {
			map.addAttribute("msg", msg);
			session.invalidate();
			return VIEW_LOGINPAGE;
		}
		return "forward:/" + url1 + "/" + url2;
	}

	@PostMapping("/validate")
	public String validatePost(HttpSession session, ModelMap map, @Value("${invalidSession}") String msg,
			@PathVariable("url1") String url1, @PathVariable("url2") String url2) {
		return validate(session, map, msg, url1, url2);
	}

}
