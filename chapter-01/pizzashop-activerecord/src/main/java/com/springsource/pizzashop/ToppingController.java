package com.springsource.pizzashop;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsource.pizzashop.domain.Topping;

@Controller
@RequestMapping("/toppings")
@RooWebScaffold(path = "toppings", formBackingObject = Topping.class, exposeJson = true)
public class ToppingController {
}
