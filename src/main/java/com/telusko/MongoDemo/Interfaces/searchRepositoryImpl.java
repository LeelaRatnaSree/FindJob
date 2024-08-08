package com.telusko.MongoDemo.Interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.telusko.MongoDemo.Model.Post;

@Component
public class searchRepositoryImpl implements searchRepository{
	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;
	@Override
	public List<Post> findByText(String text){
		
		final List<Post> posts=new ArrayList<>();
		MongoDatabase database = mongoClient.getDatabase("NewJob");
		MongoCollection<Document> collection = database.getCollection("JobList");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("index", "default")
		            .append("text", 
		    new Document("query", text)
		                .append("path", "tech"))), 
		    new Document("$sort", 
		    new Document("exp", 1L))));
		result.forEach(doc -> posts.add(converter.read(Post.class,doc)));
		return posts;
	}

}
