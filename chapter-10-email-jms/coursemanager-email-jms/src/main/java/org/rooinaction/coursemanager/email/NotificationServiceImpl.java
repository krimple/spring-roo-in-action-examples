package org.rooinaction.coursemanager.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceImpl implements NotificationService {
	
	private static final Log log = LogFactory.getLog(NotificationServiceImpl.class);

    @Autowired
    private transient MailSender mailTemplate;

    @Autowired
    private transient SimpleMailMessage simpleMailMessage;

    public void sendMessage(String mailTo, String message) {
    	log.debug("Ready to send the email message.");
        simpleMailMessage.setTo(mailTo);
        simpleMailMessage.setText(message);
        mailTemplate.send(simpleMailMessage);
    }
}
