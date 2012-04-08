package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.model.Course;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/courses")
@Controller
@RooWebScaffold(path = "courses", formBackingObject = Course.class)
public class CourseController {

  @RequestMapping("/costbyday")
  public@ResponseBody String calcCostByDay(@RequestParam String days) {
    try {
      int val = Integer.parseInt(days);
      return String.valueOf(val * 50);
    } catch (NumberFormatException e) {
      return "0";
    }
  }
}
