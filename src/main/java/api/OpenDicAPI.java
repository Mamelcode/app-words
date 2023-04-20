package api;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.google.gson.Gson;

import data.search.SearchResult;

public class OpenDicAPI {
	
	public static SearchResult search(String q){
		try {
			String targetURL = "https://opendict.korean.go.kr/api/search";
			String queryString = "key=21A0BF1DAEAAC329C994EB6755AFDEED";
			queryString += "&req_type=json&advanced=y&pos=1";
			queryString += "&q=" + URLEncoder.encode(q, "utf-8");
			
			URI uri = new URI(targetURL+ "?" +queryString);
			
			
			//==============================
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
	            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
	            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
	            public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
	        }};

	        SSLContext sslContext = SSLContext.getInstance("TLS");
	        sslContext.init(null, trustAllCerts, null);
			//==============================
	        HttpClient client = HttpClient.newBuilder().sslContext(sslContext).build();
			
			
			//HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
			
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			Gson gson = new Gson();
			
			SearchResult result = gson.fromJson(response.body(), SearchResult.class);
			
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		SearchResult result = OpenDicAPI.search("행복");
		System.out.println(result.getChannel().getTotal());
	}
}
