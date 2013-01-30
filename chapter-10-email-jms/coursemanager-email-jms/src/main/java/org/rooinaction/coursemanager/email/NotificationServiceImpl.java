package org.rooinaction.coursemanager.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceImpl implements NotificationService {

	private static final Log log = LogFactory.getLog(NotificationServiceImpl.class);

    @Autowired
    private transient MailSender mailTemplate;

    @Autowired
    private transient SimpleMailMessage templateMessage;

    public void sendMessage(String mailTo, String message) {
		log.debug("Ready to send the email message.");

        templateMessage.setTo(mailTo);
        templateMessage.setText(message);
        mailTemplate.send(templateMessage);
    }
}
