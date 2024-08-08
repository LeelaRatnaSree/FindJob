package com.telusko.MongoDemo.Interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.telusko.MongoDemo.Model.Post;

public interface PostInterface extends MongoRepository<Post, String>{

}
