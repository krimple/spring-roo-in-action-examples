package org.rooinaction.coursemanager.web.scaffold;

import org.rooinaction.coursemanager.model.Student;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "students", formBackingObject = Student.class)
@RequestMapping("/students")
@Controller
public class StudentController {
}
