package com.satconfluence.POJO;

import java.util.ArrayList;

public class ChatGPTResponse{
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public int getCreated() {
		return created;
	}
	public void setCreated(int created) {
		this.created = created;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public ArrayList<Choice> getChoices() {
		return choices;
	}
	public void setChoices(ArrayList<Choice> choices) {
		this.choices = choices;
	}
	@Override
	public String toString() {
		return "ChatGPTResponse [id=" + id + ", object=" + object + ", created=" + created + ", model=" + model
				+ ", choices=" + choices + ", usage=" + usage + "]";
	}
	public Usage getUsage() {
		return usage;
	}
	public void setUsage(Usage usage) {
		this.usage = usage;
	}
	public String id;
    public String object;
    public int created;
    public String model;
    public ArrayList<Choice> choices;
    public Usage usage;
}
