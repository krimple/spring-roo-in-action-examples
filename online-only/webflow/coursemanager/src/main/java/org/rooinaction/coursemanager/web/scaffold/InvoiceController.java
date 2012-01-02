package org.rooinaction.coursemanager.web.scaffold;

import org.rooinaction.coursemanager.model.Invoice;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "invoices", formBackingObject = Invoice.class)
@RequestMapping("/invoices")
@Controller
public class InvoiceController {
}
