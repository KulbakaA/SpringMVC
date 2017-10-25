package com.getjavajob.servlets;

import com.getjavajob.model.entity.User;
import com.getjavajob.service.IService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;
import java.util.List;

@Controller()
@EnableWebMvc
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

    @RequestMapping(value = "/showUsersFilter", method = RequestMethod.GET)
    @ResponseBody
    public List<User> showAllUsersWithFilter(final @RequestParam("filter") String filter) {
        System.out.println("filter = " + filter);

        List<User> users = this.service.fetchAll();
        CollectionUtils.filter(users, new Predicate<User>() {
            @Override
            public boolean evaluate(User user) {
                if (user.getName().contains(filter) || user.getLastName().contains(filter)) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        return users;
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


    @RequestMapping(value = "/user/{id}/view", method = RequestMethod.POST)
    public void doU(@PathVariable("id") Long id) {
        System.out.println("id = " + id);
    }


}
