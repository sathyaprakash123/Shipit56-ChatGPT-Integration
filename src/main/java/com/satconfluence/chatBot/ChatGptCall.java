package com.satconfluence.chatBot;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.satconfluence.POJO.ChatGPTResponse;


@Component
public class ChatGptCall {
	
	final static Logger logger = LoggerFactory.getLogger(RequestInitialiser.class);
	
	public String GPTResponse(String ask) throws IOException, InterruptedException
	{
	
	logger.info("Initiating request to Chatbot with payload : ");
    String payload = "{\"model\": \"text-davinci-003\",\"prompt\": \"" + ask
			+ "\",\"max_tokens\": 4000,\"temperature\": 1.0}";
    logger.info(payload);
	HttpClient client = HttpClient.newHttpClient();

	HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.openai.com/v1/completions"))
			.header("content-type", "application/json")
			.header("Authorization", "Bearer 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")
			.POST(HttpRequest.BodyPublishers.ofString(payload)).build();

	HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	
	Gson gson = new Gson();
	ChatGPTResponse gptresponse = gson.fromJson(response.body(), ChatGPTResponse.class);
	logger.info("Query Resoponse : "+ gptresponse.choices.get(0).text);
	return gptresponse.choices.get(0).text;
	}


}
