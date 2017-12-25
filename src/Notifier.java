
public class Notifier implements Runnable {
	
	private final Message msg;
//	private boolean flag;
    private WriteWaiter br;
    
    public Notifier(WriteWaiter br, Message msg) {
        this.msg = msg;
        this.br = br;
    }
 
    
    //WriteWaiter br = new WriteWaiter();
    
    
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");
        
        br.setFlag(true);
        
        try {
        	Thread.sleep(3000);
            synchronized (msg) {
                msg.setMsg(name + " поток Notifier отработал");
                msg.notifyAll();
                System.out.println(name + " отработал");
                 
            //     br.setJobTRUE();
                 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	

}
