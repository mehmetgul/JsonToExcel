package test;


import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;

public class Example4 {
	public static void main(String[] args) throws Exception {
		try(FileReader fr = new FileReader("employees.json");
		    FileWriter fw = new FileWriter("jsondata3.json");
		    JsonReader reader = Json.createReader(fr);
		    JsonWriter jsonWriter = Json.createWriter(fw);) {
			JsonObject jsonObject = reader.readObject();

			JsonBuilderFactory jsonBuilderFactory = Json.createBuilderFactory(null);
			JsonObjectBuilder jsonObjectBuilder = jsonBuilderFactory.createObjectBuilder();

			for(String key : jsonObject.keySet()) {
				jsonObjectBuilder.add(key, jsonObject.get(key));
			}
			jsonObjectBuilder.add("firstName", "Mehmet");
			jsonObjectBuilder.add("age", "48");

			jsonObject = jsonObjectBuilder.build();

			jsonWriter.writeObject(jsonObject);
		}
	}
}