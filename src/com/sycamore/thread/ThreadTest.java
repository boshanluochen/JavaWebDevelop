/*
 * Copyright (c) 2015-2017, Zhejiang QiZhi Technologies Co., Ltd.
 * <http://www.shterm.com/>
 */
package com.sycamore.thread;

public class ThreadTest implements Runnable{

	private String name;
	
	public ThreadTest(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for ( int i = 0; i < 5; i++){
			System.out.println(name + "ÔËÐÐ  £º" + i);
			try {
				Thread.sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		new Thread(new ThreadTest("C")).start();
		new Thread(new ThreadTest("D")).start();
	}

}
