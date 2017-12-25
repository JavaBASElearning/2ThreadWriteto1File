import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThreadB implements Runnable{

	private final Message msg;
    private ThreadA br;
    final int maxadd = 20;
    private long counter = 0;
    
    private boolean runB;
	private boolean flagB;
    
    
    public ThreadB(ThreadA br, Message msg) {
        this.msg = msg;
        this.br = br;
        flagB = true;
        runB = true;
    }
    
    public long Read() {
    long ret;
    String[] find = {"A", "B"};
       
    ret = 0;
    	try {	
   		 
    		 FileReader fr = new FileReader("text.txt");
    		 BufferedReader br = new BufferedReader(fr);
    		 String strLine = null, tmp;

    		while ((tmp = br.readLine()) != null)
    {
    			strLine = tmp;
            }
    		
    	//	 String lastLine = strLine;
    		
    		for (String temp : find) {
    			strLine = strLine.replace(temp, "");
            }
    		 
    		System.out.println("Я прочитал - " + strLine);
    		
    		
    		
    		ret = Long.parseLong(strLine);
    		br.close();
    		fr.close();
    		
    		} catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
    	
            }
    	return  ret;
        
    }
    
    
    public synchronized void setFlag(boolean flag) {
    	this.flagB = flag; 
   }   
    
    public synchronized void setRun(boolean run) {
        this.runB = run;
    } 
	
    
    @Override
    public void run() {
    	
    	String name = Thread.currentThread().getName();
      
    	System.out.println(name + " стартовал");
        
        counter = Read();
        
        writeToFile wtf = new writeToFile ();
        
        try {	
        	while (runB) {
        		
        		wtf.doFileProcessing(counter, "B");
        		counter++;
        
        if (counter >= maxadd) {
        	this.runB = false;
        	System.out.println("Мы превысили значение ...  " + counter);
        	br.setFlag(true);
        	
        synchronized (msg) {
             
        	msg.setMsg(name + " поток Thread B отработал");
        	msg.notify();
        	br.setFlagAlive(true);            	 
        	}
        	
        	
        	break;	
        }
        
        System.out.println("Thread B ...  " + counter);
        
		Thread.sleep(200);
        
        br.setFlag(true);
        
     //   try {
     //   	Thread.sleep(3000);
        while (flagB) {	
            synchronized (msg) {
             
            	try{
            	
            	msg.setMsg(name + " поток Thread B отработал");
              //  msg.notifyAll();
                System.out.println(name + " отработал");
               
                msg.notify();
                
                System.out.println(name + " : " + msg.getMsg());
                msg.wait();
                
                
            	} catch(InterruptedException e){
	               e.printStackTrace();
	            }
            	
            	flagB = false;
                
                
            }
        
        }
        
        flagB = true;   
        
        
    }
        	System.out.println("Мы превысили значение во Thrd B и выволились сюда...  " + counter);
        	
        	
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	
}
}