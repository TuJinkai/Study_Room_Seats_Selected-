package demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SeatChoose {
	public static final void SeatChoose(String Url,CloseableHttpClient httpclient) {
		// 创建httppost    
        HttpPost httppost = new HttpPost(Url);  
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("spanSelect", "7:00"));
        formparams.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", "7629D439"));  
        formparams.add(new BasicNameValuePair("__VIEWSTATE", "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"));  
        formparams.add(new BasicNameValuePair("__EVENTVALIDATION", "/wEWAwKYiKy+BAL0ntKNAwLCi9reA8JSa6o9NW7k7/R0o6OG4pguc9ishpz0Dka0Yb+VASn7")); 
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
                    System.out.println("选座尝试！！！  ");  
                    System.out.println("--------------------------------------"); 
                    System.out.println(EntityUtils.toString(entity));
                                     
                }  

		
	}catch (Exception e) {
		// TODO: handle exception
	}
        
		
		
	}

}
