package com.radt.test;

import java.util.UUID;

import com.radt.model.Message;

public class LiveTest {
	 
    private static final String API_ROOT
      = "http://localhost:8081/api/v1";
 
    private Message createRandomBook() {
    	Message msg = new Message();
        msg.setMessage(UUID.randomUUID().toString());
        return msg;
    }
 
	/*
	 * private String createBookAsUri(Book book) { Response response =
	 * RestAssured.given() .contentType(MediaType.APPLICATION_JSON_VALUE)
	 * .body(book) .post(API_ROOT); return API_ROOT + "/" +
	 * response.jsonPath().get("id"); }
	 */
}