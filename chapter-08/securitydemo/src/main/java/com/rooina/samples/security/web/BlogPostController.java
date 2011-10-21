package com.rooina.samples.security.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.rooina.samples.security.model.BlogPost;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "blogposts", formBackingObject = BlogPost.class)
@RequestMapping("/blogposts")
@Controller
public class BlogPostController {
}
