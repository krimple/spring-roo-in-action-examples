package org.rooina.addons.standalone.jmxexample.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Blog {

	@NotNull
	@Size(min=5, max=30)
    private String title;

	@NotNull
	@Size(max=1000)
    private String entry;
}
