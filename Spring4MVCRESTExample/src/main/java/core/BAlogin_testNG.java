package core;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BAlogin_testNG {
	/*public String url = "https://self.test.com:8080/WB/user/login";
	String password = "111111";
	String programName = "PROGRAMTEST";
	String userType = "benchAdmin";
	String userMail = "benchadmin@ba.com";
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test() throws Exception, Exception {
		/*
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("password", password);
		jsonObject.put("programName", programName);
		jsonObject.put("userType", userType);
		jsonObject.put("userMail", userMail);

		String result = postData(url, jsonObject.toJSONString());
		JSONObject wrapper = (JSONObject) new JSONParser().parse(result);
		Assert.assertEquals(Integer.valueOf(wrapper.get("errorCode").toString()), Integer.valueOf(0));
		 */
		//create member by API

	    String url = "http://localhost:8081/membershipWallet/membersrvc/createmember";
		String data="{\"userName\":\"admin\",\"password\":\"abc\",\"jsonData\":{\"firstName\":\"test\",\"lastName\":\"testData\",\"email\":\"test@test34.com\",\"mobileNo\":\"9999999999\",\"role\":\"USER\",\"password\":\"krypc123\",\"cnfpassword\":\"krypc123\"}}";
		String result = postData(url, data);
		JSONObject wrapper = (JSONObject) new JSONParser().parse(result);
		Assert.assertEquals(Integer.valueOf(wrapper.get("errorCode").toString()), Integer.valueOf(0));
		
	}

	private String postData(String url, String jsonString) throws ClientProtocolException, Exception {
		// TODO Auto-generated method stub
		String result = null;
		HttpClient httpclient = new DefaultHttpClient();
		// 2. make POST request to the given URL
		HttpPost httpPost = new HttpPost(url);
		// 5. set json to StringEntity
		StringEntity se = new StringEntity(jsonString);
		// 6. set httpPost Entity
		httpPost.setEntity(se);
		// 7. Set some headers to inform server about the type of the
		// content
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
		

		// 8. Execute POST request to the given URL
		HttpResponse httpResponse = httpclient.execute(httpPost);

		result = EntityUtils.toString(httpResponse.getEntity());

		// result = httpResponse.toString();
		System.out.println("RESULT   :::" + result);

		return result.toString();
	}
}