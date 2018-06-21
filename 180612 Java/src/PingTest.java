import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingTest {

	public static void main(String[] args) {
		
		String ip = "192.168.1.217";
		String pingResult = "";
		
		String pingCmd = " ping " + ip;
		try {
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(pingCmd);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				Pattern pattern = Pattern.compile("(\\d+ms)(\\s+)(TTL=\\d+)", Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(inputLine);
				if(matcher.find()) {
					System.out.println(matcher.group(1)+" "+matcher.group(3));
					}	
				}
			in.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
