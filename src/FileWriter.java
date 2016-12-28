import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileWriter {
	
	public void writeLyricsFile(String lyricsText, String filePath) throws IOException
	{
		// writes to the file at the specified location
		PrintWriter writer = new PrintWriter(filePath, "UTF-8");
		// read the lyrics and iterate through line by line to write to file
		BufferedReader reader = new BufferedReader(new StringReader(lyricsText));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			line = line.trim();
			writer.println(line);
		}
		writer.close();
	}
}
