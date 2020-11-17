import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketPermission;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/*
 * https://www.tutorialspoint.com/java/java_url_processing.htm
 * https://docs.oracle.com/javase/7/docs/api/java/net/URL.html
 * https://docs.oracle.com/javase/7/docs/api/java/net/URI.html
 */


public class URLDemo {
	
	public static void main(String args[]) throws IOException, URISyntaxException {
		
		//basic URL... link to class: https://docs.oracle.com/javase/7/docs/api/java/net/URL.html
		URL test = new URL("https://www.youtube.com/watch?v=uAaC1FFAISs"); //link to a vlogbrothers video I really love ;)
		test = new URL("https://xacer.dev/");
		
		
		System.out.println("URL is " + test.toString());
		System.out.println("URL's default port is " + test.getDefaultPort());
		
		int defaultport = test.getDefaultPort(); //I got 443 when I tested this. Interesting. most websites are #80
		
		//URLConnection class...: https://docs.oracle.com/javase/8/docs/api/java/net/URLConnection.html
		URLConnection connectToTest = test.openConnection();
		System.out.println("will interact? " + connectToTest.getAllowUserInteraction());
		
			//connecting to that URL?.... https://docs.oracle.com/javase/7/docs/api/java/net/HttpURLConnection.html
		HttpURLConnection connection = (HttpURLConnection) connectToTest;
		
		SocketPermission perms = (SocketPermission) connection.getPermission();
		System.out.println("perms: " + perms.getActions());
		
			//sending info stuff
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		out.println("Hello World");
		out.flush();
	
		
			//receiving info stuff
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); //BufferedReaders read text from a character input stream. Note: there are audio, object, etc etc. for inputstreamreaders
		
		String thing;
		while((thing = in.readLine()) != null) {
			System.out.println(thing);
		}
		
		

		
		//nothing really important or difficult, but interesting to play around with
		//Open a URL in desktop
		//Desktop current = Desktop.getDesktop();
		//current.browse(test.toURI());
		
		
		
		
		
	} //end of main
	
}//end of class
