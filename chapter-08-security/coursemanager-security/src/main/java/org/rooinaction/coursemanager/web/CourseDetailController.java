package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.domain.CourseDetail;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/coursedetails")
@Controller
@RooWebScaffold(path = "coursedetails", formBackingObject = CourseDetail.class)
public class CourseDetailController {
}
