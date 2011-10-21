package org.rooina.addons.standalone.jmxexample.service;


public interface BlogService {
	
	void addBlogEntry(String title, String message);
	long getBlogEntryCount();
}

