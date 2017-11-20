package demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestFid {
	public static final void TestFid(CloseableHttpClient httpclient) {
		
		// 创建httppost    
        HttpPost httppost = new HttpPost("http://zwfp.jxnu.jadl.net/BookSeat/BookSeatListForm.aspx");  
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("hidBookDate", ""));
        formparams.add(new BasicNameValuePair("hidRrId", "")); 
        formparams.add(new BasicNameValuePair("selReadingRoom", "101003")); 
        formparams.add(new BasicNameValuePair("txtBookDate", "2017-9-10")); 
        formparams.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", "871AA8B3"));  
        formparams.add(new BasicNameValuePair("__VIEWSTATE", "/wEPDwUKMTM5MDYwMzc1OA9kFgICAw9kFgYCBw8QZA8WBWYCAQICAgMCBBYFEAUR6Ieq5Lmg5a6kMTAxKOWNlykFBjEwMTAwMWcQBRHoh6rkuaDlrqQyMDEo5Y2XKQUGMTAxMDAyZxAFEeiHquS5oOWupDIwMijljJcpBQYxMDEwMDNnEAUR6Ieq5Lmg5a6kMzAxKOWNlykFBjEwMTAwNGcQBRHoh6rkuaDlrqQzMDIo5YyXKQUGMTAxMDA1Z2RkAgkPFgQeCWlubmVyaHRtbGUeB1Zpc2libGVoZAILDzwrAAkAZGTx+ukjUIPRsKDM56UDnVvXNZuCLN9TkcbAge3Mz7zTZQ=="));  
        formparams.add(new BasicNameValuePair("__EVENTVALIDATION", "/wEWBQKt5JrACQKP25+PBwKozKffBwKe8pjrCQLbhOG0Aql5TSJ0nhtEutd/JRVIFbzcy0tbYY4shPyNbOh7kYaY")); 
        formparams.add(new BasicNameValuePair("subCmd", "query"));  

        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
 
                HttpEntity entity = response.getEntity();  
                if (entity != null) {
                	
                    System.out.println("--------------------------------------");  
                    System.out.println("程序执行  ");  
                    System.out.println("--------------------------------------"); 
//                    System.out.println(EntityUtils.toString(entity));
                                     
                }  

		
	}catch (Exception e) {
		// TODO: handle exception
	}
        }
	


}
