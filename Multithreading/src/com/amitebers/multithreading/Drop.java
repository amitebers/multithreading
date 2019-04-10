package com.amitebers.multithreading;



	public class Drop {
	    // Message sent from producer
	    // to consumer.
	    private String message;
	    // True if consumer should wait
	    // for producer to send message,
	    // false if producer should wait for
	    // consumer to retrieve message.
	    private boolean empty = true;

	    public synchronized String take() {
	        // Wait until message is
	        // available.
	    	System.out.println("take method :"+empty);
	        while (empty) {
	            try {
	                wait();
	                System.out.println("take method :"+empty);
	            } catch (InterruptedException e) {}
	        }
	        // Toggle status.
	        System.out.println("take method :"+empty);
	        empty = true;
	        System.out.println("take method :"+empty);
	        // Notify producer that
	        // status has changed.
	        notifyAll();
	        return message;
	    }

	    public synchronized void put(String message) {
	        // Wait until message has
	        // been retrieved.
	    	System.out.println("put method :"+empty);
	        while (!empty) {
	            try { 
	                wait();
	                System.out.println("put method :"+empty);
	            } catch (InterruptedException e) {}
	        }
	        // Toggle status.
	        System.out.println("put method :"+empty);
	        empty = false;
	        System.out.println("put method :"+empty);
	        // Store message.
	        this.message = message;
	        // Notify consumer that status
	        // has changed.
	        notifyAll();
	    }
	}

