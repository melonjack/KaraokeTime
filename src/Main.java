import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> searchTerms = InputReader.getSearchInfo();
		
		System.out.println("Searching for: " + searchTerms.get(0) + " by " + searchTerms.get(1));
		String searchURL = LyricFinder.prepareSearch(searchTerms.get(0), searchTerms.get(1));
		System.out.println(searchURL);
		//Elements cards = LyricFinder.getSearchPageElements(searchURL);
		//LyricFinder.getLyricsURL(cards);
		LyricFinder.getLyrics("http://genius.com/Billy-joel-the-longest-time-lyrics");
		
	}

}
