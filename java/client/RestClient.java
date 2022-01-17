package client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//import org.json.JSONObject;

public class RestClient {

	/*public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse httpresponce = httpclient.execute(httpget);
		int statuscode = httpresponce.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		String responsestring = EntityUtils.toString(httpresponce.getEntity(), "UTF-8");
		JSONObject responsejson = new JSONObject(responsestring);
		System.out.println(responsejson);
		Header[] headerarray = httpresponce.getAllHeaders();
		HashMap<String, String> headervals = new HashMap<String, String>();
		for (Header header : headerarray) {
			headervals.put(header.getName(), header.getValue());
		}
	}
*/
}
