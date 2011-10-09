package com.springsource.pizzashop;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsource.pizzashop.domain.PizzaOrder;

@Controller
@RequestMapping("/pizzaorders")
@RooWebScaffold(path = "pizzaorders", formBackingObject = PizzaOrder.class, exposeJson = true)
public class PizzaOrderController {
}
