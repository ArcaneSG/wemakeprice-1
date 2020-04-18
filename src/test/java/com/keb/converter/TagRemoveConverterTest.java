package com.keb.converter;

import org.junit.Test;
import static org.junit.Assert.*;

public class TagRemoveConverterTest {
    @Test
    public void testConvert() {
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
    	
    	TagRemoveConverter tagRemoveConverter = new TagRemoveConverter();
    	assertEquals(tagRemoveConverter.convert(text),  "\n" + 
										    			"  \n" + 
										    			"    \n" + 
										    			"    My test page\n" + 
										    			"  \n" + 
										    			"  \n" + 
										    			"    \n" + 
										    			"  \n");
    }
}