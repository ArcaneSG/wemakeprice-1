package com.keb.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharacterUtilTest {
	 @Test
	    public void test() {
		 	String text1 = "bafdsafda223114fdajkv;@@ㅁㅍ어ㅏㄴ;";
		 	String text2 = "bafdsafda";
		 	String text3 = "15214321512";
		 	String text4 = "!@#$@!%#@!$";
		 	String text5 = "";
	     
	    	assertEquals(CharacterUtil.sort(text1), "a1a1a2a2b3d4ddfffjksv");
	    	assertEquals(CharacterUtil.sort(text2), "aaabddffs");
	    	assertEquals(CharacterUtil.sort(text3), "11112223455");
	    	assertEquals(CharacterUtil.sort(text4), "");
	    	assertEquals(CharacterUtil.sort(text5), "");
	    }
}

