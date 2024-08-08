package com.telusko.MongoDemo.Interfaces;

import java.util.List;

import com.telusko.MongoDemo.Model.Post;

public interface searchRepository {
	List<Post> findByText(String text);

}
