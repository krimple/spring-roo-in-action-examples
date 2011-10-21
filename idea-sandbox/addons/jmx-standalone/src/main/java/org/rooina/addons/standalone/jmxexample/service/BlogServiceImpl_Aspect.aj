package org.rooina.addons.standalone.jmxexample.service;

import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

public aspect BlogServiceImpl_Aspect {
	
	declare @type: BlogServiceImpl: @ManagedResource;
	
	declare @type: BlogServiceImpl: @ManagedNotification(name="entry added", 
			  description="New blog entry added.", notificationTypes= {"success", "failure"});

	declare @type: BlogServiceImpl: @Service;
	
}
