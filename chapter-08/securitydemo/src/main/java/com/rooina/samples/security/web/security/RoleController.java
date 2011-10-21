package com.rooina.samples.security.web.security;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.rooina.samples.security.model.security.Authority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "security/roles", formBackingObject = Authority.class)
@RequestMapping("/security/roles")
@Controller
public class RoleController {
}
