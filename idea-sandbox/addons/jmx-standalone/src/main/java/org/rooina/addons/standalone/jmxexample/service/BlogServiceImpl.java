package org.rooina.addons.standalone.jmxexample.service;

import javax.management.Notification;

import org.apache.commons.lang3.text.StrBuilder;
import org.rooina.addons.standalone.jmxexample.model.Blog;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.transaction.annotation.Transactional;

public class BlogServiceImpl implements BlogService, NotificationPublisherAware {	
	
	private static final String ADDED_MESSAGE = "Added Blog Entry $id - $title";
	private static final String FAILURE_MESSAGE = "Failure adding blog- $exception";

	private NotificationPublisher publisher;
	
	private int counter = 0;
	
	@Override
	@Transactional	
	public void addBlogEntry(String title, String message) {
		Blog blog = null;
		try { 
			blog = new Blog();
			blog.setEntry(message);
			blog.setTitle(title);
			blog.persist();	
			//notifyAdded(blog);				
		} catch (Throwable de) {
			System.err.println("FAILED!");
			de.printStackTrace();
			//notifyFailed(de);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	@ManagedOperation
	public long getBlogEntryCount() {
		return Blog.countBlogs();		
	}
	
	@Override
	public void setNotificationPublisher(
			NotificationPublisher notificationPublisher) {
		this.publisher = notificationPublisher;		
	}

	private void notifyAdded(Blog blog) {
		StrBuilder builder = new StrBuilder(ADDED_MESSAGE);
		builder.replaceAll("$title", blog.getTitle());
		builder.replaceAll("$id", blog.getId().toString());
		
		publisher.sendNotification(
		  new Notification("success", 
	        this, 
	        incrementCounter(), 
	        builder.toString()));
	}
	
	private void notifyFailed(Throwable de) {
		StrBuilder builder = new StrBuilder(FAILURE_MESSAGE);
		builder.replaceAll("$exception", de.getMessage());
		
		publisher.sendNotification(
		  new Notification("failure", 
	        this, 
	        incrementCounter(), 
	        builder.toString()));		
	}
	
	private synchronized int incrementCounter() {
		counter++;
		return counter;
	}
}
