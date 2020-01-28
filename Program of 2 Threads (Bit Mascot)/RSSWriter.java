package juinv.com.pmscs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RSSWriter extends Thread {
	
	@Override
	public void run() {
		try {
			for(;;) {
				System.out.println("File Writing started");
				updateFile("http://rss.cnn.com/rss/edition.rss");
				System.out.println("File Writing finished");
				Thread.sleep(15000);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void updateFile(String url) throws IOException {
		rssWriter(url);
	}

	private void rssWriter(String rssUrl) throws IOException {
		URL url = new URL(rssUrl);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String rssText = "";
		String line;
		while ((line = reader.readLine()) != null) {
			String[] newLines = line.split("<");
			for (String str : newLines) {
				if (str.trim().length() < 2) continue;
				str = "<" + str;
				rssText += str + "\n";
			}
		}
		File path = new File("D:\\a.rss");
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		bw.write(rssText);

		reader.close();
		bw.close();
	}
}
