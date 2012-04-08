

Build and Deploy the Sample Application for Spring Integration:
-----------------------------------------------------------------

To build and deploy the application, follow the commands listed in BuildCommands.txt file in this directory.

The test client class name is CourseRegistrationSpringIntegrationTestClient located in:
src\main\java\org\rooinaction\coursemanager\integration folder.


Running Test Client from Command Line:
----------------------------------------

If you want to run the test client from command line using Maven commands, use the exec:java command as shown below:

mvn exec:java -Dexec.mainClass="org.rooinaction.coursemanager.integration.CourseRegistrationSpringIntegrationTestClient"
 
 
Test Data:
------------

SCENARIO # 1:
Successful Registration Text Message:
Test Course Registration # 12345

SCENARIO # 2:
Waitlist Registration Text Message:
Test Course Registration # 99999

SCENARIO # 3:
Invalid Registration Text Message:
Test Course Registration # 77777

When the test client is up and running, try with all three scenarios
by entering the text messages listed above, to see how each message
is routed to a different channel to process the course registration, 
based on the context (i.e. the registration code included in the
text message).

