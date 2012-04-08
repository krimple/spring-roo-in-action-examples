package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.domain.CourseDetails;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "coursedetailses", formBackingObject = CourseDetails.class)
@RequestMapping("/coursedetailses")
@Controller
public class CourseDetailsController {
}
