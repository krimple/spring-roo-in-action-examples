package org.rooinaction.taskmanager.web;

import org.rooinaction.taskmanager.model.Task;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tasks")
@Controller
@RooWebScaffold(path = "tasks", formBackingObject = Task.class)
public class TaskController {


}
