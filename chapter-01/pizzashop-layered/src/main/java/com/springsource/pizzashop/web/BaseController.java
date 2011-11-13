package com.springsource.pizzashop.web;

import com.springsource.pizzashop.domain.Base;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebJson(jsonObject = Base.class)
@Controller
@RequestMapping("/bases")
@RooWebScaffold(path = "bases", formBackingObject = Base.class)
public class BaseController {
}
