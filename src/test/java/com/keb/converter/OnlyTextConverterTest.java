package com.keb.converter;

import org.junit.Test;
import static org.junit.Assert.*;

public class OnlyTextConverterTest {
    @Test
    public void testConvert() {
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
    	
    	OnlyTextConverter onlyTextConverter = new OnlyTextConverter();
    	assertEquals(onlyTextConverter.convert(text), "DOCTYPEhtmlhtmlheadmetacharsetutf8titleMytestpagetitleheadbodyimgsrcimagesfirefoxiconpngaltMytestimagebodyhtml");
    }
}