package com.satconfluence.chatBot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.satconfluence.POJO.ConfPageDetails;

@Component
public class ConfluenceQueryDetails {
	
	
	final static Logger logger = LoggerFactory.getLogger(RequestInitialiser.class);
	ConfPageDetails pageDetails = new ConfPageDetails();
	
	
	public ConfPageDetails parseRequestQuery(String question)

    
	
	{
	logger.info("Parsing query to extract Space KEY and Page title");
    String[] supertext = question.split(" ");
    String query = question.substring(question.lastIndexOf("about:") + 6);
    pageDetails.setQuery(query);

	for (String x : supertext)

	{

		   if (x.contains("space:")) {
			String[] y = x.split(":");
			logger.info("Space Key = " + y[1]);
			pageDetails.setSpaceKey(y[1]);

		}

	}

	logger.info("Query to ChatGPT : " + query);
	return pageDetails;
	
	}
	
	

}
