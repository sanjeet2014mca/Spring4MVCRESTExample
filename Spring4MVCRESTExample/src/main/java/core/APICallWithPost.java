package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class APICallWithPost {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			DefaultHttpClient httpClient = new DefaultHttpClient();
			//LOGIN API
			/*HttpPost postRequest = new HttpPost("http://localhost:8080/WB/user/login");
			StringEntity input = new StringEntity("{\"userType\":\"user\",\"password\":\"test123\",\"userMail\":\"test2@u.com\",\"programName\":\"HDFC\"}");
		    */
			//Send & Receive API
			String data="{\"userName\":\"admin\",\"password\":\"abc\",\"jsonData\":{\"firstName\":\"test\",\"lastName\":\"testData\",\"email\":\"test@test29.com\",\"mobileNo\":\"9999999999\",\"role\":\"USER\",\"password\":\"test123\",\"cnfpassword\":\"test123\"}}";
			HttpPost postRequest = new HttpPost("http://localhost:8081/membershipWallet/membersrvc/createmember");
			//StringEntity input = new StringEntity("{\"messageId\":\"SHARE_PUR_REP\",\"userType\":\"user\",\"password\":\"test123\",\"userMail\":\"test2@u.com\",\"programName\":\"HDFC\"}");
			//StringEntity input = new StringEntity("{\"userName\":\"admin\",\"password\":\"dfafa\",\"jsonData\":{\"firstName\":\"test\",\"lastName\":\"testData\",\"email\":\"test3@u.com\",\"mobileNo\":\"9999999999\",\"role\":\"USER\",\"password\":\"test123\",\"cnfpassword\":\"test123\"}}");//
			//http://localhost:8080/WB/asset/balanceUser/?data={userMail:test2@u.com,programName:HDFC}-call by browser 
			StringEntity input=new StringEntity(data);
			input.setContentType("application/json");
			postRequest.setEntity(input);
			System.out.println(postRequest);
			//data = URLDecoder.decode(data, "UTF-8");
			HttpResponse response = httpClient.execute(postRequest);
			System.out.println(response);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(
					new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
