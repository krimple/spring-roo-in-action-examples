package org.rooina.addons.standalone.jmxexample.service;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public interface BlogServiceJmxMethods {
	
	@ManagedOperation
	void addBlogEntryJmx(String title, String entry);

}
