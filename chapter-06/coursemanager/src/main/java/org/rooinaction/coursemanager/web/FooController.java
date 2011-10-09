package org.rooinaction.coursemanager.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/foo/**")
@Controller
public class FooController {

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    public void post(@PathVariable java.lang.Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public java.lang.String index() {
        return "foo/index";
    }
}
