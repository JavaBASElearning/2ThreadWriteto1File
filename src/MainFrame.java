import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.UIManager;
import javax.swing.ListSelectionModel;

//
public class MainFrame extends JFrame{

	DefaultListModel<String> dlm = new DefaultListModel<String>();
	
	
	JList souvenirList;
	public int mySum;

    JScrollPane scrollPane;
    String lineSeparator = System.getProperty("line.separator");


    Container c = getContentPane();



    private String[] itemNames = {"mug","cap","tee shirt","sweat shirt","pennant","mini stick",

            "bobblehead","paper bag","foam paw","thunderstix"};
	

    
    public static void main(String[] args)

    {

		MainFrame frame = new MainFrame();

        frame.setSize(600,400);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLocationRelativeTo(null);
        
    }
	

	
public void newCall () throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		CallableRead callableRd = new CallableRead(50);	
		Future<Integer> task = executor.submit(callableRd);
		Integer result = task.get();
		System.out.println("Результат newCall = " + result);

	}
    
    
    
    public MainFrame() {
        getContentPane().setLayout(null);

        JList <String> souvenirList = new JList<>(dlm);
        souvenirList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        souvenirList.setLayoutOrientation(JList.VERTICAL);

        scrollPane = new JScrollPane(souvenirList);
        scrollPane.setBounds(15, 8, 437, 330);
        c.add(scrollPane);
        
        JButton btnNewButton = new JButton("Write");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
//	    JOptionPane.showMessageDialog(null, "Привет");
				
		/*		String result;
				File file =new File("text.txt");
				
				
				byte[] data = new byte[100];
				int[] str = new int[100];
				
				for (int j = 0; j < 100; j++) {
	                
					str[j] = j; 
	            } */
				
       // 		try {
					
		/*		file.createNewFile();
				System.out.println("File is created");
				FileWriter writer = new FileWriter(file);
				
				for (int j = 0; j < str.length; j++) {
	              
					int s =  str[j];
					
					result = Integer.toString(s) + lineSeparator; 
					
					writer.write(result);
	            }
				
		        writer.flush();
		        writer.close();
		        System.out.println("Data is entered into file"); 
		        
		        //---------------- Стартуем поток ------------------
		        
    //    		Test1 t10 = new Test1();
    //    		int t45 = t10.getval(); */
        		
        		
        	//	Thread t1 = new Thread(new WritetofileTHR(), "t1");
		       // Thread t2 = new Thread(new SumtofileTHR(), "t2");
        	//	Thread t2 = new Thread(new WriteWaiter(), "t2"); 
		 //     System.out.println("Стартуем runnable потоки");
		      //  t1.start();
		      //  t2.start();
		        Message msg = new Message("");
		        
		        
		     /*   WriteWaiter waiter = new WriteWaiter(msg);
		        new Thread(waiter,"waiter").start(); */
		        
		        
		        
		        ThreadA thrda = new ThreadA(msg);
		     //   ThreadB thrdb = new ThreadB(thrda, msg);
		        new Thread(thrda,"thrda").start(); 
		        
		        
		        try {
					Thread.sleep(750);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       // WriteWaiter br = new WriteWaiter();
		  //     waiter.run = false;
		  //      waiter.flag = false;
		        System.out.println("Brake");
		  //      Notifier notifier = new Notifier(waiter, msg);
		    //    new Thread(notifier, "notifier").start();
		        
		        ThreadB thrdb = new ThreadB(thrda, msg);
			        new Thread(thrdb, "Thread B").start();
		        
		        
		  /*      try {
		            Thread.sleep(5500);
		        } catch (InterruptedException e1) {
		            e1.printStackTrace();
		        }
		        
		     //   waiter.setRun(false);
		        thrda.setRun(false);
		        
		        */
		        
		    //    Thread t3 = new testThread("t3");
		    //    System.out.println("Стартуем thread потоки");
		    //    t3.start();
		        
		//      System.out.println("Runnable потоки в работе");
					
				
		/*	} catch (IOException e2) {
	            e2.printStackTrace();
	        }
	
		        try { */
					
		     //   newCall();
				
        		
        //		} catch (InterruptedException e1) {
					
		//			e1.printStackTrace();
		//		} catch (ExecutionException e1) {
					
		//			e1.printStackTrace();
		//		}
		        
		/*		String root = System.getProperty("user.dir");
				 System.out.println(root); */
				 
		  	        		
        	}
        });
        btnNewButton.setBounds(477, 8, 89, 23);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Read");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	
        		try {	
    				FileReader fr = new FileReader("text.txt");
    				BufferedReader br = new BufferedReader(fr);
    				String fileread = br.readLine();
    				
    				String line = br.readLine();
    				while (line != null) {
    	                System.out.println(line);
    	               // textArea.append("лол"+ lineSeparator);
    	                dlm.addElement(line);
    	                
    	                line = br.readLine();
    	            }
    				
    					
    				br.close();
    				
    				} catch (FileNotFoundException e1) {
    		            e1.printStackTrace();
    		        } catch (IOException e1) {
    		            e1.printStackTrace();
    		        }
        		
        		
        		
        		
        	}
        });
        btnNewButton_1.setBounds(477, 39, 89, 23);
        getContentPane().add(btnNewButton_1);
		
		
	}
}

	
	
	
	
	
