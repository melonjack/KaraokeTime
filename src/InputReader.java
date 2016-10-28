import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.lang3.text.WordUtils;

public class InputReader {
	
	public static ArrayList<String> getSearchInfo()
	{
		ArrayList<String> searchTerms = new ArrayList<>();
		System.out.println("Enter the song you'd like to search for: ");
		Scanner sc = new Scanner(System.in);
		//song name
		searchTerms.add(WordUtils.capitalize(sc.nextLine()));
		System.out.println("Enter the artist you'd like to search for: ");
		//artist name
		searchTerms.add(WordUtils.capitalize(sc.nextLine()));
		sc.close();
		return searchTerms;
	}

}
