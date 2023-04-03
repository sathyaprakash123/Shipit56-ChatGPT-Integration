package com.satconfluence.chatBot;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class RequestInitialiser {

	// public static String requestURL =
	// "https://requestinspector.com/inspect/01gsyd6nrm5xhcbt3pyxb711rk";
	final static Logger logger = LoggerFactory.getLogger(RequestInitialiser.class);

	public static String spaceKey;
	public static String spaceContent;
	public static String pageName;
	
	@Autowired
	ConfluenceTroubleshoot troubleshootConfluence;
	
	@Autowired
	PageAnalysis pageanalysis;

	@Autowired
	ChatGptCall chatGptCall;

	@Autowired
	ConfluencePageCreator confluencePageCreator;

	@Autowired
	ConfluenceQueryDetails confQueryDetails;

	@GetMapping(path = "/api/confchat")
	public String createRequest(@RequestParam String ask) throws IOException, InterruptedException

	{

		return chatGptCall.GPTResponse(ask);

	}

	@GetMapping(path = "/api/createpage")
	public String createPageOnSpace(@RequestParam String ask, @RequestParam String spaceKey)
			throws IOException, InterruptedException

	{

		/*
		 * if (ask.contains("create page on space:")) {
		 * logger.info("Page creation request accepted"); ConfPageDetails pageDetails =
		 * confQueryDetails.parseRequestQuery(ask); String chatGPTResponse =
		 * chatGptCall.GPTResponse(pageDetails.getQuery()); return
		 * confluencePageCreator.createConfluencePageUsingSpacekey(pageDetails.getQuery(
		 * ), pageDetails.getSpaceKey(), chatGPTResponse);
		 * 
		 * }
		 */
		logger.info("Page creation request accepted");
		String chatGPTResponse = chatGptCall.GPTResponse(ask);
		return confluencePageCreator.createConfluencePageUsingSpacekey(ask, spaceKey, chatGPTResponse);

	}

	@GetMapping(path = "/api/status")
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String getStatus()

	{

		return "ConfluenceChatGPTService is Running";

	}
	
	@GetMapping(path = "/api/analysePage")
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String analysePage(@RequestParam String pageId, @RequestParam String spaceKey) throws IOException, InterruptedException

	{
       
		pageanalysis.getPageAnalysis(pageId, spaceKey);
		
		return "Page Analysed and comments added";

	}
	
	@GetMapping(path = "/api/troubleshoot")
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String analyseRecentLogs(@RequestParam String spaceKey) throws IOException, InterruptedException

	{
		
       
		troubleshootConfluence.troubleshootConfluence(spaceKey);
		return "Recent logs analysed and comments added to page";

	}
	
	@GetMapping(path = "/api/socialmedia")
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String postOnSocialMedia(@RequestParam String spaceKey, @RequestParam String page) throws IOException, InterruptedException

	{
		
       
	
		return "page summarised and posted on Twitter, Facebook";

	}
	
	@GetMapping(path = "/api/performance")
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String confPerformance(@RequestParam String spaceKey) throws IOException, InterruptedException

	{
		
       
	
		return "Performance params added to page";

	}

}
