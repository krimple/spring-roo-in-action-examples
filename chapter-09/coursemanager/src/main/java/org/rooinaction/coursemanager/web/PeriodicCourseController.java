package org.rooina.coursemanager.web;

import org.rooina.coursemanager.model.PeriodicCourse;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "periodiccourses", formBackingObject = PeriodicCourse.class)
@RequestMapping("/periodiccourses")
@Controller
public class PeriodicCourseController {
}
