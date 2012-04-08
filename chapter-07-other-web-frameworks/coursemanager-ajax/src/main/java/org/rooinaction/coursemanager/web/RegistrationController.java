package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.model.Registration;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/registrations")
@Controller
@RooWebScaffold(path = "registrations", formBackingObject = Registration.class)
public class RegistrationController {
}
