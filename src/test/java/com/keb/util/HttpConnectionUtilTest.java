package com.keb.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class HttpConnectionUtilTest {
    @Test
    public void testHttpConnection() {
        String result1 = HttpConnectionUtil.httpConnection("https://www.naver.com");
        assertTrue(result1.contains("네이버"));
        
        String result2 = HttpConnectionUtil.httpConnection("https://www.google.com/search?q=인코딩");
        assertTrue(result2.contains("/search?q=%EC%9D%B8%EC%BD%94%EB%94%"));
        
        String result3 = HttpConnectionUtil.httpConnection("https://www.google.com/search?q=漢");
        assertTrue(result3.contains("/search?q=%E6%BC%A2"));
    }
}