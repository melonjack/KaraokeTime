import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

public class LyricFinder {
	// variable for all the groups of lyrics (HTML elements with lyrics tags) on a website
	List<String> lyricGroups = new ArrayList<String>();

	/**
	 * Get the HTML elements of a page from the search URL
	 * @param searchURL the URL to try to parse
	 * @return the HTML elements of the page
	 */
	public static Elements getSearchPageElements(String searchURL) {
		Document doc = null;
		try {
			doc = Jsoup.connect(searchURL).get();
		} catch (IOException e) {
			System.out.println("Unable to connect to website.");
			e.printStackTrace();
		}
		return doc.getElementsByClass("media-card-text");
	}
	
	/**
	 * Prepare the search URL by converting spaces and apostrophes 
	 * @param searchTerms the terms to search for
	 * @return the URL of the search results
	 */
	public static String prepareSearch(String searchTerms)
	{
		String AZLyricsSearchURL = "http://search.azlyrics.com/search.php?q=";
		String MusixMatchSearchURL = "https://www.musixmatch.com/search/";

		
		searchTerms = searchTerms.replaceAll(" ", "%20").replaceAll("'", "%27");
		return MusixMatchSearchURL + searchTerms;
	}
	
	/**
	 * Gets the URL of the actual lyrics page for the song (hopefully the first search result is correct!)
	 * @param cards the card elements from the search page to check for a link to the song lyrics
	 * @return the URL of the lyrics page for the song
	 */
	public static String getLyricsURL(Elements cards)
	{
		String MusixMatchURL = "https://www.musixmatch.com";
		String lyricsURL = null;
		if(!cards.isEmpty())
		{
			//try to use the first card
			String lyricsURLSlug = cards.get(0).getElementsByClass("title").attr("href");
			lyricsURL = MusixMatchURL + lyricsURLSlug;
			System.out.println(lyricsURL);
		}
		return lyricsURL;
	}
	
	public static String getLyrics(String url)
	{
		Document doc = null;
		Elements lyricsElements = null;
		String lyricsText = null;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla").get();
			lyricsElements = doc.getElementsByClass("lyrics");
			// get pretty printed html with preserved br and p tags
		    String prettyPrintedBodyFragment = Jsoup.clean(lyricsElements.html(), "", Whitelist.none().addTags("br"), new Document.OutputSettings().prettyPrint(true));
		    // get plain text with preserved line breaks by disabled prettyPrint
		    lyricsText = Jsoup.clean(prettyPrintedBodyFragment, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
		} catch (IOException e) {
			System.out.println("Error: could not connect to lyrics URL.");
			e.printStackTrace();
		}
		System.out.println(lyricsText);
		return lyricsText;
	}

}
