package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utility {

	public static RequestSpecification req;
	public static PrintStream log;
	
	public RequestSpecification RequestSpecs() throws FileNotFoundException
	
	{		
		if(log==null)
		{
			 log = new PrintStream("C:\\Users\\Amruta\\eclipse-workspace\\APIFrameworkBDD\\Logs.txt");
		}
	   
		req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
				
		 return req;
	}
	
	
	}

