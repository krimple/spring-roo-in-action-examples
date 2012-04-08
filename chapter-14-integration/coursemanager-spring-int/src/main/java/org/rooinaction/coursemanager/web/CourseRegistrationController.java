package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.domain.CourseRegistration;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "courseregistrations", formBackingObject = CourseRegistration.class)
@RequestMapping("/courseregistrations")
@Controller
public class CourseRegistrationController {
}
