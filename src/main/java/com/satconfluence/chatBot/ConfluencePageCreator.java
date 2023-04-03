package com.satconfluence.chatBot;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConfluencePageCreator {
	// public static String requestUrl, userName, passWord, spaceKey, pageName;

	/* Method to send POST request to Confluence */
	final static Logger logger = LoggerFactory.getLogger(RequestInitialiser.class);
	public static String result;

	public String createConfluencePageUsingSpacekey(String pName, String spaceKey, String pageContent)
			throws IOException, InterruptedException
			
	

	{
		logger.info("Create page using space key called");
      
		String payload = "{" + "\"type\":\"page\"," + "\"title\":\"$Page Placeholder$\","
				+ "\"space\":{\"key\":\"$Space Placeholder$\"}," + "\"body\":{" + "\"storage\":{"
				+ "\"value\":\"$Page Content$\"," + "\"representation\":\"storage\"" + "}" + "}" + "}";

		payload = payload.replace("$Page Placeholder$", pName);
		payload = payload.replace("$Space Placeholder$", spaceKey);
		payload = payload.replace("$Page Content$", pageContent);
		payload = payload.replace("\n", "");

		logger.info(payload);
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8090/rest/api/content"))

				// HttpRequest.newBuilder(URI.create("https://requestinspector.com/inspect/01gsyd6nrm5xhcbt3pyxb711rk"))
				.header("content-type", "application/json").header("Authorization", getBasicAuth())
				.POST(HttpRequest.BodyPublishers.ofString(payload)).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String responseResult = String.valueOf(response.statusCode());
		logger.info("Actual response from Confluence : "+ response.toString());
		if (!responseResult.isEmpty()) {
			if (responseResult.compareTo("200") == 0) {
				result = "Page "+ pName + " created in Confluence";
			} else {
				result = "Page not created. Please check logs for details";
			}

		}

		logger.info("Page Creation status :" +result);
		return result;

	}

	/* Generating basic auth for username & password */

	private static String getBasicAuth() {
		String userPass = "sathya:sathya";
		return ("Basic " + Base64.getEncoder().encodeToString(userPass.getBytes()));

	}

}
