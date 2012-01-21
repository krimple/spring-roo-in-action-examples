package com.rooinaction.cmsapp.email;


public interface NotificationService {
	
	void sendMessage(String mailTo, String message);
}
