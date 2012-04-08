package org.rooinaction.coursemanager.email;


public interface NotificationService {
	
	void sendMessage(String mailTo, String message);
}
