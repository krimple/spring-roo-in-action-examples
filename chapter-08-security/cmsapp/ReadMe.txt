

Tool Installation:

1. OpenDS Server: Download (http://www.opends.org/) and install OpenDS LDAP Server. You can download the latest version available (version 2.2 at the time of this writing).

Run the Sample Application:

1. Start OpenDS LDAP server. Open a command prompt and run the following commands to launch the LDAP server.

set JAVA_HOME=YOUR_JDK_HOME_DIRECTORY
set PATH=%PATH%;% JAVA_HOME%\bin;
set OPEN_DS_HOME= YOUR_OPEN_DS_SERVER_HOME_DIRECTORY
cd % OPEN_DS_HOME %\bat
control-panel.bat

2. Once the server is started, it will display a login prompt. Enter the credentials to authenticate and open the Open DS server console.

User ID: cn=Directory Manager
Password: PASSWORD_CREATED_DURING_OPEN_DS_INSTALL

3. After starting the Open DS server, you will need to add some test users ids and roles to test the sample application. Here are the user id’s and the roles I used to setup the LDAP user data store.

1. Student User:
User Id: student
Password: teststudent
Role/Group: ROLE_STUDENT

2. Admin User:
User Id: adminuser
Password: testadmin
Role/Group: ROLE_ADMIN


Refer to the Security tutorial available at the following link, on how to add the users and groups/roles in Open DS server:
SecureJavaEE6App Tutorial - NetBeans Wiki (http://wiki.netbeans.org/SecureJavaEE6App)

The base DN used for the sample application is:
dc=coursemanager,dc=org

