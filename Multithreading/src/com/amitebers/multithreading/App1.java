package com.amitebers.multithreading;

public class App1 {

	public static int count = 0;
	public static synchronized void increment() {
		count++;
	}
	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					//count++;
					increment();
				}
				
			}
			
		});
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					//count++;
					increment();
				}
				
			}
			
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count:"+count);

	}

}
