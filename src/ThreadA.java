
public class ThreadA implements Runnable{
	
				final int maxadd = 20;
				private Message msg;
        		private long counter = 0;
        		private boolean run;
        		private volatile boolean flag;
        		private volatile boolean flagAlive;
        //		 private ThreadB brB;
        		
        	    
        	    public ThreadA(Message m){
        	        this.msg = m;
        	      //  flag = false;
        	        flag = true;
        	        run = true;
        	        flagAlive = false;
        	    }
        	    
        	    
        	  /*  public ThreadA(ThreadB brB, Message msg) {
        	        this.msg = msg;
        	        this.brB = brB;
        	        flag = true;
        	        run = true;
        	    } */
        	    
        	    
        	    
        	    public synchronized void setFlag(boolean flag) {
        	    	this.flag = flag; 
        	   }   
        	    
        	    
        	    public synchronized void setFlagAlive(boolean flag) {
        	    	this.flagAlive = flag; 
        	   }   
        	    
        	    
        	    public synchronized void setRun(boolean run) {
        	        this.run = run;
        	    } 
        	    
        	    public void setJobTRUE() {
        	   	 System.out.println("���� " + flag);
        	   	flag = true;
        	       System.out.println("����� " + flag);
        	   }
        	   
        	    
        	    @Override
        	    public void run() {
        	    	
        	    	String name = Thread.currentThread().getName();
        	    	
        	    	writeToFile wtf = new writeToFile ();
        	    	
        	    	
        	    	
        	  
        	        	try {	
        	        	while (run) {
        	        	//	synchronized (msg) {
        	        	//	System.out.println(run);
        	        	//	System.out.println(flag);
        	          // 	 System.out.println("����� ���� ��������");
        	           	 
        	        		wtf.doFileProcessing(counter, "A");
        	                counter++;
        	                
        	                if (counter >= maxadd) {
        	                	this.run = false;
        	               System.out.println("�� ��������� �������� ...  " + counter);	
        	               break;	
        	                } 
        	            
        	                System.out.println("Thread 1 ...  " + counter);
        	          
        						Thread.sleep(280);
        				
        							
        	        	while (flag) {	
        	        		synchronized (msg) {
        	        		
        	        	try{
        	        		
        	        		
        	        		 msg.notify();
        	        		
        	        		 if (!flagAlive) {
        	        			 System.out.println("Thread A is waiting....");
        	        		 msg.wait();
        	        		 }
        	        		
        	        	
        	                
        	            } catch(InterruptedException e){
        	                e.printStackTrace();
        	            }
        	        	} //s1-end
        	        //	}
        	        //
        	   //         System.out.println(name + " ��� ����� ������ notify: " + System.currentTimeMillis());
        	            /*   // ���������� ���� ��������� */
        	            
        	        	
        	        //	System.out.println(name + " : " + msg.getMsg()); 
        	        	flag = false; // ���������� ����
        	         //   System.out.println(run);
        	            	
        	            
        	        	}
        	        	
        	        //	System.out.println("�������� ...  " + counter);
        	        	flag = true; // ���������� ����
        	        	
        	        		//} // s2 - end
        	        	} //-while ext - end
        	        	
        	        	
        	       
        	        	//flag = false; // ���������� ����
        		
        	        	} catch (InterruptedException e) {
        	                e.printStackTrace();
        	                System.out.println(name + " interrupted");
        	            }
        	        	System.out.println(name + " finished");
        	}        
        	 	

}
