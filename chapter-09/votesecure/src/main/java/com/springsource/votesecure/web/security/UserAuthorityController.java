package com.springsource.votesecure.web.security;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.springsource.votesecure.domain.security.UserAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "userauthoritys", formBackingObject = UserAuthority.class)
@RequestMapping("/userauthoritys")
@Controller
public class UserAuthorityController {
}
