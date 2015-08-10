import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.io.File;
import java.io.*;


public class JSouper
{

	public static void main(String args[])
	{
		Document doc = null;
		try
		{
			//doc = Jsoup.connect("http://pathofexile.gamepedia.com/List_of_unique_axes/").get();
			doc = Jsoup.parse(new File("C:/Users/Badgers/Desktop/uniqs/jewels.html"), "UTF-8");
			Elements trs = doc.select("tr[id]");
			
			for (Element src : trs)
			{
				//System.out.println(src.attr("id"));	//what is the item's name?
				String itmName="";
				Elements itmNames = src.select("[href]:lt(2)");
				for ( Element src2 : itmNames)
				{
					itmName = itmName + src2.attr("title") + " ";
				}
				itmName = itmName.trim();
				//System.out.println(src.select("span.itemboxstatsgroup:last-child").html());	//what are its non damage rolls stats
				String stats = new String(src.select("span.itemboxstatsgroup:last-child").html());
				stats = stats.replaceAll(" <br>", ";");
				stats = stats.replaceAll("0 to ", "0-");
				stats = stats.replaceAll("1 to ", "1-");
				stats = stats.replaceAll("2 to ", "2-");
				stats = stats.replaceAll("3 to ", "3-");
				stats = stats.replaceAll("4 to ", "4-");
				stats = stats.replaceAll("5 to ", "5-");
				stats = stats.replaceAll("6 to ", "6-");
				stats = stats.replaceAll("7 to ", "7-");
				stats = stats.replaceAll("8 to ", "8-");
				stats = stats.replaceAll("9 to ", "9-");
				stats = stats.replace('(', '[');
				stats = stats.replace(')', ']');
				System.out.println(itmName + "|" + stats);				
			}			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
}
