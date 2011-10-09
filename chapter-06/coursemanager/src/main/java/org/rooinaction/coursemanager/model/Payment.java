package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(identifierType = PaymentPK.class, versionField = "", table = "payment")
@RooDbManaged(automaticallyDelete = true)
public class Payment {
}
