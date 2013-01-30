
Build and Deploy the Sample Application for Email and JMS:
-----------------------------------------------------------------

To generate the sample application from scratch, you can run the commands listed in RooCommands.txt file. Or you can copy the coursemanager application created in Chapter 8 to start with a baseline and then run the JMS and Email commands listed in BuildCommands.txt file in this directory.

Once the code is compiled, you can run the JUnit tests from the IDE (Eclipse) or the command line.

Here are the test class names and other configuration details you will need to run the unit tests for the 3 use cases discussed in the chapter.


Use Case # 1:
---------------

Test class: CourseCatalogUpdateEventPublisherTest

When you run this test class, the course catalog update message is posted to the "jms.topic.CourseCatalogUpdateAlerts" Topic. This message is then consumed by JmsCourseCatalogUpdateTopicListener class which is listening the above JMS Topic and if all goes well, you should see the following log message on the console.

"JMS message received: Test CourseCatalogEvent Message."

If it doesn't work, try to run it again using the Debug mode in IDE (Eclipse) which should create the delay in posting the message to the Topic before the JMS listener class (JmsCourseCatalogUpdateTopicListener) can consume it. Debug option should do the trick.


Use Case # 2:
---------------

Test class: RegistrationNotificationEventPublisherTest

Before running the test class, change the EMAIL_TO_ADDRESS field to the email address where you would like to receive the e-mail notification message.

Use your SMTP user name and password to authenticate the mail server (e.g. GMail).

If all goes well, you should receive an email message in the "EMAIL_TO_ADDRESS" account specified in the RegistrationNotificationEventPublisherTest class.


Use Case # 3:
---------------

Test class: RegistrationNotificationWaitListEventPublisherTest
Listner class: JmsCourseRegistrationWaitListQueueListener

Run the test class and if all works w/o any issues, you should see the following log message on the console.

"JMS message received: Test regNotifyWaitListEvent Message."

If it doesn't work, try to run it again using the Debug mode in IDE (Eclipse) which should create the delay in posting the message to the Topic before the JMS listener class (JmsCourseCatalogUpdateTopicListener) can consume it. Debug option should do the trick.



