package homework9;

import java.util.ArrayList;

public class ThreadControl extends Thread {
	
	private static ArrayList<fusionThread> threads = new ArrayList<>();
	
	public synchronized void checkPoint(){
		fusionThread current = (fusionThread) Thread.currentThread();
		try
        {
            current.wait();        //releases the lock of this object and waits
            current.setCheckPoint(true);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
	}
	
	public synchronized void releaseAll(){
		for (int i=0; i<4; i++){
			if (threads.get(i).isCheckPoint()){
				threads.get(i).resume();
			}
		}
		
	}
	
	public synchronized void pause(){
		fusionThread current = (fusionThread) Thread.currentThread();
		try
        {
            current.wait();        //releases the lock of this object and waits
            current.setCheckPoint(true);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
		
	}
	
	public synchronized void release(fusionThread t) throws Exception{
		if (t==null) {
			throw new Exception();
		}
		for (int i=0; i<4; i++){
			if (threads.get(i).isPause() && threads.get(i) == t){
				threads.get(i).resume();
			}
		}
	}
	
	public static void main (){
		fusionThread t1 = new fusionThread();
		fusionThread t2 = new fusionThread();
		fusionThread t3 = new fusionThread();
		fusionThread t4 = new fusionThread();
		
		threads.add(t1);
		threads.add(t2);
		threads.add(t3);
		threads.add(t4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		ThreadControl tc = new ThreadControl();
	}
}
