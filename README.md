ReadMe: 

How to build and prepare environment:
1. donwload JDK11
2. install Eclipse 
3. install cucmber plugin and testng plugins from Eclipse marketplace  
4. download the code from git hub
5. import project in to eclipse 
6. update the chrome webdriver path in the file "dealerwareTest/src/main/java/pageObjects/accountCreation.java" inside accountCreation() constructor.
7. update the project my right clicking on project and select "Maven=>Update Project" 

How to run:
1. Open Test Runner class and right click.
2. Select RunAs-> Testng test
3. two scenarios will run
4. at every re-run amke sure email id is updated in the "Scenario: User signs in with the newly created account"
