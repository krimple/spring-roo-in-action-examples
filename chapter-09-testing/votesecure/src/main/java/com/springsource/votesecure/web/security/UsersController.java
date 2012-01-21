package com.springsource.votesecure.web.security;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.springsource.votesecure.domain.security.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "userses", formBackingObject = Users.class)
@RequestMapping("/userses")
@Controller
public class UsersController {
}
