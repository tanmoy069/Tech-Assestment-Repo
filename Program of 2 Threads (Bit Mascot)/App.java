package juinv.com.pmscs;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	RSSReader rdr = new RSSReader();
    	RSSWriter wrt = new RSSWriter();
   		wrt.start();
   		rdr.start();
    }
}
