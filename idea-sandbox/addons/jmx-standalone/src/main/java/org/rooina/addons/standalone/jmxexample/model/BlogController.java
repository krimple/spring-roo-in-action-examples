package org.rooina.addons.standalone.jmxexample.model;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "blogs", formBackingObject = Blog.class)
@RequestMapping("/blogs")
@Controller
public class BlogController {
}
