package juinv.com.pmscs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RSSReader extends Thread {
	
	@Override
	public void run() {
		try {
			for(;;) {
				System.out.println("File reading started");
				getImgRef();
				System.out.println("File reading finished");
				Thread.sleep(20000);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getImgRef() throws IOException {
		rssReader();
	}

	private void rssReader() throws IOException {
		File path = new File("D:\\a.rss");
		BufferedReader reader = new BufferedReader(new FileReader(path));

		String line;
		while ((line = reader.readLine()) != null) {
			String[] newLines = line.split("<");
			for (String str : newLines) {
				str = "<" + str;
				if (str.contains("medium=\"image\"")) {
					int index = str.indexOf("url=");
					String temp = str.substring(index);
					temp = temp.split(".jpg")[0].substring(5) + ".jpg";
					System.out.println(temp);
				}
			}
		}
		reader.close();
	}
}
