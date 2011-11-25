package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.model.Course;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/courses")
@Controller
@RooWebScaffold(path = "courses", formBackingObject = Course.class, exposeFinders = true)
@RooWebFinder
public class CourseController {
}
