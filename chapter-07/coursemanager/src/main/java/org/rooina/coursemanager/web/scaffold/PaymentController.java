package org.rooina.coursemanager.web.scaffold;

import org.rooina.coursemanager.model.Payment;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "payments", formBackingObject = Payment.class)
@RequestMapping("/payments")
@Controller
public class PaymentController {
}
