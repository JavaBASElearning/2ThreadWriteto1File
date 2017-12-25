
public class Message {
	
	private String msg;
	final int max = 25;
    
    public Message(String str){
        this.msg=str;
    }
 
    public synchronized String getMsg() {
        return msg;
    }
    
    public synchronized int getMax() {
        return max;
    }
 
    public synchronized void setMsg(String str) {
        this.msg=str;
    }	
	

}
