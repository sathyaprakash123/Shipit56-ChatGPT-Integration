package com.satconfluence.chatBot;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageAnalysis {
	
	final static Logger logger = LoggerFactory.getLogger(RequestInitialiser.class);

	@Autowired
	ConfluencePageCreator createpage;

	public void getPageAnalysis(String analysis, String key) throws IOException, InterruptedException

	{
		logger.info("Calling create page method");
		
		
		
		String y = "Thank you for the information. It seems like there are a few dependencies and delays in the bug fixing process.\n"
				+ "\n"
				+ "Bug PS-112 is currently in progress and is expected to be completed by March 23rd, 2023. It is good to know that John is on track to complete this bug.\n"
				+ "\n"
				+ "Bug PS-113 is dependent on PS-112, so it will not be completed before March 23rd, 2023.\n"
				+ "\n"
				+ "Bug PS-119 is expected to be fixed by April 2nd, 2023, but it is dependent on bug PS-110. Unfortunately, Judy, who is supposed to work on bug PS-110, is on sick leave and is not expected to return until April 25th.\n"
				+ "\n"
				+ "This means that there will be a delay in fixing bug PS-119, as it cannot be completed until PS-110 is resolved. We may need to consider finding someone else to work on PS-110 to keep the bug fixing process on schedule.\n"
				+ "\n"
				+ "I hope this helps. Let me know if you have any further questions.";

		
		createpage.createConfluencePageUsingSpacekey("Analysis of page with id 2293795", "SUP", y);
				
		
	}

}
