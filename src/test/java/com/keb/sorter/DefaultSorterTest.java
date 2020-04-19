package com.keb.sorter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DefaultSorterTest {
	 @Test
	    public void test() {
		 	String text1 = "bafdsafda223114fdajkv;@@ㅁㅍ어ㅏㄴ;";
		 	String text2 = "bafdsafda";
		 	String text3 = "15214321512";
		 	String text4 = "!@#$@!%#@!$";
		 	String text5 = "";
		 	
		 	AbstractSorter sorter = new DefaultSorter();
		 	
	    	assertEquals(sorter.getResult(text1), "a1a1a2a2b3d4ddfffjksv");
	    	assertEquals(sorter.getResult(text2), "aaabddffs");
	    	assertEquals(sorter.getResult(text3), "11112223455");
	    	assertEquals(sorter.getResult(text4), "");
	    	assertEquals(sorter.getResult(text5), "");
	    }
}

