package com.rooina.samples.security.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.rooina.samples.security.model.Blog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "blogs", formBackingObject = Blog.class)
@RequestMapping("/blogs")
@Controller
public class BlogController {
}
