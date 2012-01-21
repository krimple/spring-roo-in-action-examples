package com.rooinaction.cmsapp.web;

import com.rooinaction.cmsapp.domain.CourseDetails;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "coursedetailses", formBackingObject = CourseDetails.class)
@RequestMapping("/coursedetailses")
@Controller
public class CourseDetailsController {
}
