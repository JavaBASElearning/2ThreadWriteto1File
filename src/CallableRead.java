import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;

public class CallableRead implements Callable<Integer> {
	
	private int num = 0;
	public int lastvalue;
	public int lastvalueExt;
	public CallableRead(int num){
	        this.num = num;
    }	

	@Override
	public Integer call() throws Exception {
		
		int result = 0;
		int rand = 0;
		
		
		for (int j = 0; j < num; j++) {
		
			rand =  randInt(0, 10);
			System.out.println("We have generated the " + rand + " number from our Callable thread!");
			
			lastvalueExt = doReadAndSumProcessing();	
		    result = lastvalueExt+rand;
		    
		
		}
		
		
		return result;
	
	}
	
	public static int randInt(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	private int doReadAndSumProcessing() throws InterruptedException {
		
		Thread.sleep(900);
		
		
		try {	
			 
			FileReader fr = new FileReader("text.txt");
			BufferedReader br = new BufferedReader(fr);
//			String fileread = br.readLine();
			
		//	String line = br.readLine();
			 String strLine = null, tmp;
		//	while (line != null) {
			while ((tmp = br.readLine()) != null)
	{
				strLine = tmp;
			
	        }
			
			 String lastLine = strLine;
			 lastvalue = Integer.parseInt(lastLine);
		
			 
			
			 
			  System.out.println("Я прочитал - " + lastLine);	
			br.close();
			fr.close();
			
			} catch (FileNotFoundException e1) {
	            e1.printStackTrace();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
		return lastvalue;	
		
		
	}	

}
