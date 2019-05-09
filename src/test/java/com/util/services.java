package com.util;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class services {
    Response response;

    public Response getService(String city,String headers){

         response = given().log().all().
                when().
                header("Content-Type","application/json").
                get("https://www.premierinn.com/services/en/mobileHotelLocator/suggestions/" + city).
                then().
                extract().
                response();

        return response;

    }
    public Response postService(String JSONFile) throws IOException, ParseException {

        //read json file
        String path = System.getProperty("user.dir");

        String file = path + "/src/test/java/com/TestData/" + JSONFile;

        JSONParser jsonParser=new JSONParser();
        JSONObject jsonObject= (JSONObject) jsonParser.parse(new FileReader(file));
        response = given().log().all().
                when().
                body(jsonObject).
                post("https://reqres.in/api/users").
                then().
                extract().
                response();

        return response;

    }

}
