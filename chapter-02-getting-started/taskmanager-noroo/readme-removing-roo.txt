To remove roo, Ken performed the following tasks:

  1) opened up the project (in my case in IntelliJ) in SpringSource Tool
Suite
  2) push-in refactored all Roo-managed components
  3) removed all roo-specific maven artifacts
  4) removed all Roo annotations
  5) removed the mode="aspectj" portion of <tx:annotation-driven /> in
the applicationContext.xml file
  6) ran tests until I removed all artifacts I missed
  7) ran with mvn jetty:run to test

