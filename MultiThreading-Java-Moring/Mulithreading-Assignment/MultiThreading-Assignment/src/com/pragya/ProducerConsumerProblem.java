package com.pragya;

import java.util.LinkedList;
import java.util.Queue;


public class ProducerConsumerProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("How to use wait and notify method in Java");
		System.out.println("Solving Producer Consumper Problem");
		Queue<Integer> buffer = new LinkedList<>();
		int maxSize = 10;
		Producer producer = new Producer(buffer, maxSize, "PRODUCER");
		Consumer consumer = new Consumer(buffer, maxSize, "CONSUMER");
		producer.start(); 
		consumer.start();



	}

}
