package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.model.Instructor;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/instructors")
@Controller
@RooWebScaffold(path = "instructors", formBackingObject = Instructor.class)
public class InstructorController {
}
