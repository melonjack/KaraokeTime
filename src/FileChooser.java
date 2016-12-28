import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

public class FileChooser extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1007039820598633990L;

	JButton go;

	JFileChooser chooser;
	String choosertitle;
	String lyricsPath;

	public FileChooser() {
		go = new JButton("Do it");
		go.addActionListener(this);
		add(go);
	}

	public void actionPerformed(ActionEvent e) {
		chooser = new JFileChooser(); 
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle(choosertitle);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// disable the "All files" option.
		chooser.setAcceptAllFileFilterUsed(false);
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			setLyricsPath(chooser.getSelectedFile().getPath() + "\\" + LyricFinder.getSong() + " - " + LyricFinder.getArtist() + ".txt");
			FileWriter fileWriter = new FileWriter();
			try {
				fileWriter.writeLyricsFile(LyricFinder.getLyricsText(), getLyricsPath());
				System.out.println("File created.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else {
			System.out.println("No folder selected.");
		}
	}

	public Dimension getPreferredSize(){
		return new Dimension(200, 200);
	}
	
	private void setLyricsPath(String path)
	{
		this.lyricsPath = path;
	}
	
	public String getLyricsPath()
	{
		return lyricsPath;
	}

}
