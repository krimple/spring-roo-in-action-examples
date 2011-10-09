package org.rooinaction.coursemanager.web.scaffold;

import org.rooinaction.coursemanager.model.Instructor;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "instructors", formBackingObject = Instructor.class)
@RequestMapping("/instructors")
@Controller
public class InstructorController {
}
