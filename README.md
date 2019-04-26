# Testing

TestNG -Test automation framework developed using Java and Selenium with page object model and with API test.
Developed as a Maven project that can be easily integrated with Jenkins and run the test. 


***************************************************About the project*********************************************

Test automation framework contains following packages and other project related files.
1. Project: Assignment
Packages

1. apiutilis
This package contains all the api releated utils classes like connection, constants, and utils used accross the project.

2.	uipageobjects.
Page classes for each page with actions that can be performed on this page.
All the static methods that are defined in the each page class can be re used 
in test classes by importing the class to perform actions on web elements.

3. apitests.
This package contains test classes where all the test cases are written using the methods that are defined in page 
classes to validate UI tests.

4. uitests.
This package contains test classes where all the test cases are written using the methods that are defined in page 
classes to validate UI tests.


 pom.xml
Contains all the plugins and dependencies that are required to run the test as maven project.
 TestNG.xml is configured 
in this pom.xml to trigger the test.

.TestNG.xml
	Contains the all class names that are to be triggered to run the complete suite of test cases for both ui and api tests.

4. Test Output folders.
Reports like emailable-report.html, index.html and testng-results.xml are generated under these folders once the test is run. 
These reports are very useful to analyze the test results and even to share the comprehensive results about the tests to 
higher management.

****************************************************************************************************************************


Instructions to run the test automation:

Method1 : To Run as Maven Project locally

1. Install and set up Java

2. Install and set up Maven plugin

Clone the project and set webdriver path in both TestClass and TestClass1.
Run as maven project. use below commands to run
Navigate to the project main folder using terminal or cmd and type below commands
mvn compile
mvn test

************************************************************************************************************************************

Method2 : To Run as Maven Project using Jenkins

3. Install and set up Jenkins
Fork the project to your account and change web driver path in both TestClass and TestClass1.
Configure to Jenkins as maven project and build the test.


**********************************************************************************************************************************

Method3 : To Run manually

4. Download all the below required jars and configure in build path

  • Download and add Selenium Jars to the project build path
    Go to http://www.seleniumhq.org/download/
    Download Selenium Client & WebDriver Language Bindings for Java and add to Java build path.
    
  • Download and set Web driver for example chromedriver to invoke the chrome browser.
  
  •TestNG set up
   Add TestNG plug in to eclipse:
   Use http://beust.com/eclipse to add TestNG plug in to eclipse.
	  
    Download and add TestNG and JCommander JAR files to the Java build path. Refer below links to download jar files
    https://mvnrepository.com/artifact/org.testng/testng/6.11   
    //Check for latest compatible versions if required
    
    https://mvnrepository.com/artifact/com.beust/jcommander/1.69  
    //Check for latest compatible versions if required

  • Add TestNG Source jar file.
    http://grepcode.com/project/repo1.maven.org/maven2/org.testng/testng/
  
  • Download the project, Update the webdriver path in uitests.
    Open the project using IDE and run the TestNG.xml as testng suite to obtain the results.


