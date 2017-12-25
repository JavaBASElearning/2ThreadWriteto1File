import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeToFile {
	
String lineSeparator = System.getProperty("line.separator");	


public void doFileProcessing(long y, String letter) throws InterruptedException {
		
		
		FileWriter writer= null;
		String result;
		File file =new File("text.txt");
		BufferedWriter bw = null;
	
		try {
			
		
		writer = new FileWriter(file,true);
      //	int s =  str[y];
			
		//	result = Integer.toString(y) + lineSeparator; 
			result = letter + Long.toString(y) + lineSeparator;
			
		
			
			
			System.out.println(Long.toString(y) + " записано в файл...");
			writer.write(result);

			writer.flush();
        writer.close();

    //    Thread.sleep(400);
	
		} catch (IOException e2) {
            e2.printStackTrace();
        }
		
		
	}
	
	
	

}
