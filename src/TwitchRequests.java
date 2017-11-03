import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class TwitchRequests {
	private static final String CLIENT_ID = "RETRIEVE FROM YOUR PROFILE";
	//TODO: DO NOT forget to remove this once you push to the repo.
	private static final String GET_URL = "https://api.twitch.tv/kraken/oauth2/authorize?response_type=token+id_token&client_id=" + CLIENT_ID + "&redirect_uri=http://localhost&scope=viewing_activity_read+openid&state=c3ab8aa609ea11e793ae92361f002671";
	//TODO: DO NOT forget to remove this once you push to the repo.
	private static final String ACCESS_TOKEN = "RETRIEVE AGAIN";
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI(GET_URL));
		
		URL obj = new URL("https://api.twitch.tv/helix/users?id=44322889");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		//Responsible for sending access token to Twitch.
		con.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
		//Code grabbed online for testing. Change this later. 
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
	}
}
