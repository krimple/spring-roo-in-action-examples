// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.springsource.pizzashop.repository;

import com.springsource.pizzashop.domain.Pizza;
import java.lang.Long;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect PizzaRepository_Roo_Jpa_Repository {
    
    declare parents: PizzaRepository extends JpaRepository<Pizza, Long>;
    
    declare parents: PizzaRepository extends JpaSpecificationExecutor<Pizza>;
    
    declare @type: PizzaRepository: @Repository;
    
}
