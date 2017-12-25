
public class WriteWaiter implements Runnable{
	
	private Message msg;
	private long counter = 0;
//	volatile boolean run = true;
//	volatile boolean flag = true;
	
	private boolean run;
	private boolean flag;
	
    
    public WriteWaiter(Message m){
        this.msg = m;
        flag = false;
        run = true;
    }
    
    public WriteWaiter(){
    	Message msg1 = new Message("сука");
    	this.msg = msg1;
    }
    
   /* public void setFlagTRUE() {
    	 System.out.println("run Был " + run);
    	 run = true;
        System.out.println("run Стало " + run);
    }
    
  */
    
    
    public synchronized void setFlag(boolean flag) {
    	this.flag = flag; 
   }   
    
    public synchronized void setRun(boolean run) {
        this.run = run;
    } 
    
    public void setJobTRUE() {
   	 System.out.println("Было " + flag);
   	flag = true;
       System.out.println("Стало " + flag);
   }
   
    
    @Override
    public void run() {
    	
    	String name = Thread.currentThread().getName();
    	
       	
    	System.out.println(run);
      //  synchronized (msg) {
        	try {	
        	while (run) {
        		
        	//	 System.out.println(name + " ждем вызов метода notify: " + System.currentTimeMillis());
                counter++;
                System.out.println("We are waiting ...  " + counter);
              //   try {
					Thread.sleep(100);
			//	} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
			//	} 
                 
           //     System.out.println("We are waiting ...  " + counter);
        		
        		
        	while (flag) {	
        		synchronized (msg) {
        		
        	try{
        		
        		System.out.println("wait");
        		msg.wait();
        	
        	//	System.out.println(name + " ждем вызов метода notify: " + System.currentTimeMillis());
              /*  counter++;
                Thread.sleep(500);
                System.out.println("We are waiting ...  " + counter);
               	// if(flag) msg.wait(); 	  */ 
        	 
                
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        	}
        //	}
        //
            System.out.println(name + " был вызов метода notify: " + System.currentTimeMillis());
            /*   // обработаем наше сообщение */
            
        	
        	System.out.println(name + " : " + msg.getMsg()); 
        	flag = false; // сбрасываем сами
           
            
            
        	}
        	}
       
	
        	} catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(name + " interrupted");
            }
        	System.out.println(name + " finished");
}
}
