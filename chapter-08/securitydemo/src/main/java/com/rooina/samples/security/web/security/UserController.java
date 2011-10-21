package com.rooina.samples.security.web.security;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.rooina.samples.security.model.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "security/users", formBackingObject = Principal.class)
@RequestMapping("/security/users")
@Controller
public class UserController {
}
