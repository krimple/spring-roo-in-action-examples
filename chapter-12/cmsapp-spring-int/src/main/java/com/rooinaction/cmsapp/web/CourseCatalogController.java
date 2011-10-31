package com.rooinaction.cmsapp.web;

import com.rooinaction.cmsapp.domain.CourseCatalog;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "coursecatalogs", formBackingObject = CourseCatalog.class)
@RequestMapping("/coursecatalogs")
@Controller
public class CourseCatalogController {
}
