package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.model.Tag;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "tags", formBackingObject = Tag.class)
@RequestMapping("/tags")
@Controller
public class TagController {
}
