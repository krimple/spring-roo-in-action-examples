package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.domain.CourseCatalog;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "coursecatalogs", formBackingObject = CourseCatalog.class)
@RequestMapping("/coursecatalogs")
@Controller
public class CourseCatalogController {
}
