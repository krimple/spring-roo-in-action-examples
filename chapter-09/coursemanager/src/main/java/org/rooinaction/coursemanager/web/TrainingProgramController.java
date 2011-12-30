package org.rooina.coursemanager.web;

import org.rooina.coursemanager.model.TrainingProgram;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "trainingprograms", formBackingObject = TrainingProgram.class)
@RequestMapping("/trainingprograms")
@Controller
public class TrainingProgramController {
}
