package org.rooina.coursemanager.web.scaffold;

import org.rooina.coursemanager.model.Invoice;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "invoices", formBackingObject = Invoice.class)
@RequestMapping("/invoices")
@Controller
public class InvoiceController {
}
