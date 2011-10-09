package com.springsource.pizzashop;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsource.pizzashop.domain.Base;

@Controller
@RequestMapping("/bases")
@RooWebScaffold(path = "bases", formBackingObject = Base.class, exposeJson = true)
public class BaseController {
}
