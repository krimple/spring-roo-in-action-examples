package com.springsource.pizzashop;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsource.pizzashop.domain.Pizza;

@Controller
@RequestMapping("/pizzas")
@RooWebScaffold(path = "pizzas", formBackingObject = Pizza.class, exposeJson = true)
public class PizzaController {
}
