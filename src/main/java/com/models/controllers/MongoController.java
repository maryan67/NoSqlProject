package com.models.controllers;

import org.bson.Document;

import com.models.entities.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoController {
	
	private MongoCollection<Document> dbCollection;
	
	public MongoController() {
		MongoClient  mongoDB = new MongoClient ();
		MongoDatabase messages = mongoDB.getDatabase("messages");
		 dbCollection =  messages.getCollection("saved_messages");
		
		
	}
	
	public void create(User user, String message) {
		
		Document document = new Document();
		document.append("username", user.getUserName());
		document.append("message", message);
		
		dbCollection.insertOne(document);
		
	}

}
