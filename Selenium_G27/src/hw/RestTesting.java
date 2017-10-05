package hw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

public class RestTesting {

	public static Response sendRequest(String url, String key) throws IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		get.setHeader("Content-Type", "application/x-zip");
		get.setHeader("X-Api-Key", key);
		HttpResponse responseGet = client.execute(get);
		HttpEntity resEntityGet = responseGet.getEntity();

		Assert.assertEquals(responseGet.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		String json = EntityUtils.toString(responseGet.getEntity(), "UTF-8");
		com.google.gson.Gson gson = new com.google.gson.Gson();

		return gson.fromJson(json, Response.class);

	}

	@Test
	public void testRest() throws IOException {
		Response response = sendRequest("https://api.getpostman.com/collections", "4d434e58a3d6453ca77b92891a623f5b");
		int sizeOfCollection = response.getCollections().size();

		System.out.println("response length = " + sizeOfCollection);
		System.out.println("All collections ->" + response.getCollections());

		if (sizeOfCollection > 0) {
			for (int numberInCollection = 0; numberInCollection < sizeOfCollection; numberInCollection++) {
				System.out.println("Response name" + numberInCollection + " = "
						+ response.getCollections().get(numberInCollection).get("owner"));
			}

		}

	}
}
