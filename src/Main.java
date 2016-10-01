import java.io.IOException;
import java.util.Scanner;

import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Enter the song and artist you'd like to search for: ");
		Scanner sc = new Scanner(System.in);
		String searchTerms = sc.nextLine();
		sc.close();

		String searchURL = LyricFinder.prepareSearch(searchTerms);
		Elements cards = LyricFinder.getSearchPageElements(searchURL);
		LyricFinder.getLyricsURL(cards);
		
	}

}
