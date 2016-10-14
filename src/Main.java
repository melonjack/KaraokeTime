import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.text.WordUtils;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Enter the song you'd like to search for: ");
		Scanner sc = new Scanner(System.in);
		String songName = sc.nextLine();
		System.out.println("Enter the artist you'd like to search for: ");
		String artistName = sc.nextLine();
		sc.close();
		
		System.out.println("Searching for: " + WordUtils.capitalize(songName) + " by " + WordUtils.capitalize(artistName));
		//String searchURL = LyricFinder.prepareSearch(searchTerms);
		//Elements cards = LyricFinder.getSearchPageElements(searchURL);
		//LyricFinder.getLyricsURL(cards);
		LyricFinder.getLyrics("http://genius.com/Billy-joel-the-longest-time-lyrics");
		
	}

}
