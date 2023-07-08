Project Description:

   This project is created to automate all types of APIs(SOAP and REST) primarily using rest assured, ApachePOI, TestNG and JsonPath. The most important feature of this project is to execute the test cases as per the sequence mentioned in excel


Features of the project are : 


	1) This project is capable to automate execution and validation :
		> REST: POST, PUT, PATCH, DELETE and GET
		> SOAP: GET and POST
	2) User can also construct the request body using parameters fed from excelFile, I have created an utility using ApachePOI to read data from excel
	3) This project is built on concept of data driven and keyword driven.
	4) I have divided the project into four packages
			>> Request Repository
			>> Common API Methods : >>> API Methods
				              : >>> Common Utility Method
			>> Test Classes 
			>> Dynamic Driver 
	5) The test execution is driven by TestNG XML.
	6) The project is capable of saving the evidences of the execution into text files which contains details of request sent, endpoint and response received

TestNg Framework executes the test classes by using @test annotation in alphabetical order of Test Case Name when there is no priority mentioned. This framework generates emailable HTML reports alongwith test case execution summary, reads payload from excel file and logs the response in the text file alongwith requestbody parameters and status code
