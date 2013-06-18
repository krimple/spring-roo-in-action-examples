package com.springsource.votesecure.web.security;

import com.springsource.votesecure.domain.security.Authorities;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "authoritieses", formBackingObject = Authorities.class)
@RequestMapping("/authoritieses")
@Controller
public class AuthoritiesController {
}
