package com.jiangnan.edu.web.controller;

import com.jiangnan.edu.entity.User;
import com.jiangnan.edu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 吴叶俊
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("list")
    public String list(Model model) {
        List<User> users = userService.listAll();
        if (!CollectionUtils.isEmpty(users)) {
            model.addAttribute("users", users);
        }
        return "user/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(User user) {
        userService.create(user);
        return "redirect:list";
    }
}
