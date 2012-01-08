package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.model.Course;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "courses", formBackingObject = Course.class)
@RequestMapping("/courses")
@Controller
public class CourseController {
}
