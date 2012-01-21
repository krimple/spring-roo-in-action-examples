package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/coursenonscaffolded/**")
@Controller
public class CourseNonScaffoldedController {

  @Autowired
  private CourseService courseService;

  @RequestMapping
  public String index(Model uiModel) {
    long numCourses = courseService.countAllCourses();
    uiModel.addAttribute("numCourses", numCourses);
    return "coursenonscaffolded/index";
  }
}
