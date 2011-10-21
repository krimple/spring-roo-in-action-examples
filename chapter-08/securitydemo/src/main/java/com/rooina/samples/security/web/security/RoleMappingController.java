package com.rooina.samples.security.web.security;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.rooina.samples.security.model.security.AuthorityPrincipalAssignment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "security/assignments", formBackingObject = AuthorityPrincipalAssignment.class)
@RequestMapping("/security/assignments")
@Controller
public class RoleMappingController {
}
