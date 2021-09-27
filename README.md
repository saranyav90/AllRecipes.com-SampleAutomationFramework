# AllRecipes.com-SampleAutomationFramework

This is a hybrid framework which is basically data driven and implements Page Object Model mechanism where test scripts are separated from test data.
It is written using Java code 
Base class , which contains various reusable methods like webDriver initialisation, taking screenshot etc is extended by test scripts.
While automating test cases, objects of Page classes are created .
Listeners Class which  implements the iTestListener contains methods to capture screenshots for failed TCs etc and other logs
The data.properties file stores the information that remains static throughout the framework such as browser-specific information, application URL, screenshots path, etc.
In testNG.xml,  grouping of tests, parallel execution, cross browser testing etc are achieved.
ExtentReports were used for reporting purpose
