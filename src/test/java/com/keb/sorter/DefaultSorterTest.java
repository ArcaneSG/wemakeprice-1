package com.keb.sorter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DefaultSorterTest {
	String text1 = "bafdsafda223114fdajkv;@@ㅁㅍ어ㅏㄴ;";
 	String text2 = "bafdsafda";
 	String text3 = "15214321512";
 	String text4 = "!@#$@!%#@!$";
 	String text5 = "";
 	
	@Test
    public void test() {
	 	AbstractSorter sorter = new DefaultSorter();
	 	
    	assertEquals(sorter.getResult(text1), "a1a1a2a2b3d4ddfffjksv");
    	assertEquals(sorter.getResult(text2), "aaabddffs");
    	assertEquals(sorter.getResult(text3), "11112223455");
    	assertEquals(sorter.getResult(text4), "");
    	assertEquals(sorter.getResult(text5), "");
    }
	
	@Test
    public void test2() {
    	DefaultSorter sorter = new DefaultSorter();
    	 
 	 	Thread thread1 = new Thread(()->{
 	 		try {
 	 			System.out.println(sorter.getResult(text1));
 	 			System.out.println(sorter.hashCode());
 	 			System.out.println(sorter.getManagers().hashCode());
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		});

 	 	
 	 	Thread thread2 = new Thread(()->{
 	 		try {
 	 			System.out.println(sorter.getResult(text2));
 	 			System.out.println(sorter.hashCode());
 	 			System.out.println(sorter.getManagers().hashCode());
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		});
 	 	
 	 	thread1.start();
 	 	thread2.start();
 	 	//input과 output은 안전하지 않음
    } 
	 
	@Test
    public void test3() {
 	 	Thread thread1 = new Thread(()->{
 	 		try {
 	 			DefaultSorter sorter = new DefaultSorter();
 	 			System.out.println(sorter.getResult(text1));
 	 			System.out.println(sorter.hashCode());
 	 			System.out.println(sorter.getManagers().hashCode());
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		});
 	 	
 	 	Thread thread2 = new Thread(()->{
 	 		try {
 	 			DefaultSorter sorter = new DefaultSorter();
 	 			System.out.println(sorter.getResult(text1));
 	 			System.out.println(sorter.hashCode());
 	 			System.out.println(sorter.getManagers().hashCode());
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		});
 	 	
 	 	thread1.start();
 	 	thread2.start();
    }	
}

