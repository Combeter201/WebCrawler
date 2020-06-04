package URL;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class main 
{
	public static void main(String[] args)
	{
		BufferedReader br = null;
		InputStreamReader isr = null;
		URL url = null;
		
		int startindex = 33;
		
		for(;startindex <= 47; startindex += 3)
		{
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
						substring = substring.substring(substring.indexOf("http://op4.anistream.net/wp-content/uploads/2018/03/"),substring.indexOf("http://op4.anistream.net/wp-content/uploads/2018/03/")+120);
						int urllength = 0;
						char[] ss = substring.toCharArray();
						for(int s = 52; s <= ss.length-1;s++)
						{
							if(ss[s] == '.')
							{
								urllength += 56;
								break;
							}
							else
							{
								urllength += 1;
							}
						}
						substring = substring.substring(0, urllength);
						title = substring.substring(52, urllength);
						link.add(substring);
					}
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			String Link = "http://op4.anistream.net/wp-content/uploads/2018/03/" + title;
		
			File out = new File("C:\\Users\\David\\Desktop\\One Piece\\" + title);
		
			new Thread(new Download(Link, out)).start();
		}
	}
}