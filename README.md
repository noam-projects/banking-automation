# Project summary
This project is an automated tests project using test driven attitude.

# What is the goal of this project
The goal of this project is to test features of way2automation.com/angularjs-protractor/banking/#/login website (which is a sample bank to run tests on) to make sure they work correctly.

# Details about project
BaseTests.java file holds key configuration for each test, using Object oriented attitude in java every test extends base test thus gaining access to its configuration efficiently,
some configurations be changed by changing config.properties file such as which browser is used
Test are done in test driven attitude the test uses the bank_customers.xlsx file which holds details about customers and uses it on the site.

# How to use the project
To use the project downnload the files in java IDE such as InteliJ or Eclipse and right click the run_tests.xml file and click on run run.tests.xml,
than you can go to logs and reports folder and find detaild report on the test in nice graphics window in extent.html file.

# Key technologies used in this project
* TestNG for testing framework
* selenium for controlling automated browser
* extent report for as reporting framework
* logging using java util logger
* using java library to take data from excell file
