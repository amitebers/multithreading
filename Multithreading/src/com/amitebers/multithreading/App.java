package com.amitebers.multithreading;


class Myclass extends Thread{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	
}
public class App {

	public static void main(String[] args) {
		
		 Myclass m1=new Myclass();
		 Myclass m2=new Myclass();
		 m1.start();
		 m2.start();

		 System.out.println(Thread.currentThread().getName());
		 
	}

}
