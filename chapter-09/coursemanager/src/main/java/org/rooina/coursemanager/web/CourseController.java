package org.rooina.coursemanager.web;

import org.rooina.coursemanager.model.Course;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "courses", formBackingObject = Course.class)
@RequestMapping("/courses")
@Controller
public class CourseController {
}
