package com.example.demo.musicfiledata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@EnableAutoConfiguration
public class Mongocl {
    @Autowired
	MongoClient mongoClient = MongoClients.create("http://localhost:27017");
	MongoDatabase database = mongoClient.getDatabase("MusicPranav");
	MongoCollection<org.bson.Document> collection = database.getCollection("songdata");
	
}
