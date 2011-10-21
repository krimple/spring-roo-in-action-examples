package org.rooina.coursemanager.web;

import org.rooina.coursemanager.model.SingleEvent;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "singleevents", formBackingObject = SingleEvent.class)
@RequestMapping("/singleevents")
@Controller
public class SingleEventController {
}
