package webscrape;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Scanner;
public class WebScrape
{

    public static void main(String[] args) throws Exception
    {
        Scanner inp = new Scanner(System.in);
        String input;
        System.out.println("Please enter the movie for me to search :P");
        input = inp.nextLine();
        
        String log = "";
        String log2 = "";
        int count = 0;
        int starwars = 0;
        final Document document = Jsoup.connect("https://www.imdb.com/chart/top/").get();
        //System.out.println(document.outerHtml());
        
        for(Element row : document.select("table.chart.full-width tr"))
        {
            final String title = row.select(".titleColumn").text();
            if(row.select(".titleColumn").text().contains("Star Wars"))
            {
                starwars++;
                log += row.select(".titleColumn").text() + "\n";
            }
            if(row.select(".titleColumn").text().contains(input))
            {
                log2 += row.select(".titleColumn").text() + "\n";
                count++;
            }
            final String rating = row.select(".imdbRating").text();
            
            System.out.println(title + " " + rating);
        }
        
        System.out.println("Star Wars was on the list " + starwars + " times.");
        System.out.println(log);
        System.out.println("the movie you searched for appeared " + count + " times.");
        System.out.println(log2);
    }
    
}
