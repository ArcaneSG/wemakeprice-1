package com.keb.converter;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConverterTypeTest {
    @Test
    public void onlyTextConvert() {
    	String text = "<!DOCTYPE html>\n" + 
    			"<html>\n" + 
    			"  <head>\n" + 
    			"    <meta charset=\"utf-8\">\n" + 
    			"    <title>My test page</title>\n" + 
    			"  </head>\n" + 
    			"  <body>\n" + 
    			"    <img src=\"images/firefox-icon.png\" alt=\"My test image\">\n" + 
    			"  </body>\n" + 
    			"</html>";
    	
    	String result = text.replaceAll(ConverterType.ONLY_TEXT.getRegex(), "");
    	assertEquals(result, "DOCTYPEhtmlhtmlheadmetacharsetutf8titleMytestpagetitleheadbodyimgsrcimagesfirefoxiconpngaltMytestimagebodyhtml");
    }
    
    @Test
    public void tagRemoveConvert() {
    	String text = "<!DOCTYPE html>" + 
    			"<html>\n" + 
    			"  <head>\n" + 
    			"    <meta charset=\"utf-8\">\n" + 
    			"    <title>My test page</title>\n" + 
    			"  </head>\n" + 
    			"  <body>\n" + 
    			"    <img src=\"images/firefox-icon.png\" alt=\"My test image\">\n" + 
    			"  </body>\n" + 
    			"</html>";
    	
    	
    	String result = text.replaceAll(ConverterType.TAG_REMOVE.getRegex(), "");
    	assertEquals(result, "\n" + 
			    			"  \n" + 
			    			"    \n" + 
			    			"    My test page\n" + 
			    			"  \n" + 
			    			"  \n" + 
			    			"    \n" + 
			    			"  \n");
    }
}