Feature: Get data from from server

@Read @Positive @TC_ @Regression
Scenario: Testing read or get data. 
Given Go to https://httpbin.org/get
Then Check connection correctly with status code 200 or not
And Check if response time is less than 200 ms
And Header check test data format is json or not  
And Check body response should not be null
And Check attritubute origin should be there 
And Check URL value should contains get only


@Read @Positive @TC_ @Regression
Scenario: Testing or creating Data
Given Go to https://httpbin.org/post
When Add the new data
Then Check connection correctly with status code 200 or not
And Check if response time is less than 200 ms
And Header check test data format is json or not  
And Check body response should not be null
And Check attritubute origin should be there 
And Check URL value should contains get only