// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import java.lang.Long;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Invoice_Roo_Jpa_Entity {
    
    declare @type: Invoice: @Entity;
    
    declare @type: Invoice: @Table(name = "invoice");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Invoice.id;
    
    public Long Invoice.getId() {
        return this.id;
    }
    
    public void Invoice.setId(Long id) {
        this.id = id;
    }
    
}
