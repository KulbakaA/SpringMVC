package com.getjavajob.servlets;

import com.getjavajob.model.entity.User;
import com.getjavajob.service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller()
public class UserController {

	private IService service;

	public UserController() {
	}

	@Inject
	public UserController(IService service) {
		this.service = service;
	}

	@RequestMapping(value = "/showUsers", method = RequestMethod.GET)
	public ModelAndView showAllUsers() {
		ModelAndView modelAndView = new ModelAndView("showAll");
		List<User> users = this.service.fetchAll();

		for (User user : users) {
			System.out.println("user = " + user);

		}

		return modelAndView.addObject("listOfUsers", users);
	}

	@RequestMapping(value = "/update")
	public ModelAndView showUpdate(@RequestParam("id") Long id) {
		User userById = this.service.getById(id);
		ModelAndView modelAndView = new ModelAndView("updateUser");
		modelAndView.addObject("userById", userById);
		return modelAndView;
	}

	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	public String doUpdate(@ModelAttribute User user) {
		this.service.updateUser(user);
		return "redirect:/showUsers";
	}


}
