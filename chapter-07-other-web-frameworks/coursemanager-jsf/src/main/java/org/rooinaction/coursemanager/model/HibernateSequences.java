package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = HibernateSequencesPK.class, versionField = "", table = "hibernate_sequences")
@RooDbManaged(automaticallyDelete = true)
public class HibernateSequences {
}
