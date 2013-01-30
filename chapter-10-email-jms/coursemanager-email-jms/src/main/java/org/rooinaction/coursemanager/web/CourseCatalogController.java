package org.rooinaction.coursemanager.web;

import org.rooinaction.coursemanager.domain.CourseCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/coursecatalogs")
@Controller
@RooWebScaffold(path = "coursecatalogs", formBackingObject = CourseCatalog.class)
public class CourseCatalogController {

    @Autowired
    private transient JmsOperations jmsOperations;

    public void sendMessage(Object messageObject) {
        jmsOperations.convertAndSend(messageObject);
    }
}
