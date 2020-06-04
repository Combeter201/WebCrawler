package URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Crawler 
{
	public static void main(String[] args) 
	{
		BufferedReader br = null;
		InputStreamReader isr = null;
		URL url = null;
		
		int startindex = 764 + 3;
		String urlString = "https://ani-op.com/?page_id=" + startindex;

		try {
			url = new URL(urlString);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		try {
			isr = new InputStreamReader(url.openStream());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		br = new BufferedReader(isr);
		
		String line = null;
		ArrayList<String> link = new ArrayList<String>();
		String title = null;
		try{
			while((line = br.readLine()) != null)
			{
				if(line.contains("http://op4.anistream.net/wp-content/uploads/2018/03/"))
				{
					String substring = line;
					substring = substring.substring(substring.indexOf("http://op4.anistream.net/wp-content/uploads/2018/03/"),substring.indexOf("http://op4.anistream.net/wp-content/uploads/2018/03/")+100);
					substring = substring.substring(0, 94);
					title = substring.substring(52, 94);
					link.add(substring);
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		for(int i = 0; i < link.size(); i++)
		{
			System.out.println(link.get(i));
		}
	}
}
