package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class FindSeat {
	
	public static final void  FindSeat(String txt_LoginID,String txt_Password,String RoomNo,String SeatNo,String Date) {
		// ����Ĭ�ϵ�httpClientʵ��.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // ����httppost    
        HttpPost httppost = new HttpPost("http://zwfp.jxnu.jadl.net/Login.aspx");  
        // ������������    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("txt_LoginID", txt_LoginID));  
        formparams.add(new BasicNameValuePair("txt_Password", txt_Password));  
        formparams.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", "C2EE9ABB"));  
        formparams.add(new BasicNameValuePair("__VIEWSTATE", "/wEPDwUKLTI1Nzg1ODIyMGQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFEGNoa19SZW1QYXNzcHdvcmTiU5zolo6/Gtin2EhtwQjwibMyu11t2YOmrWpFNSXQOw=="));  
        formparams.add(new BasicNameValuePair("__EVENTVALIDATION", "/wEWBALGu8H0CwK1lMLgCgLS9cL8AgKXzJ6eD1PrwC/+tEuQt/W6kERZa2FJGBofrpzrzMbXnOcWuVzp")); 
        formparams.add(new BasicNameValuePair("subCmd", "Login"));  
//        formparams.add(new BasicNameValuePair("chk_RemPasspword", "true"));  
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
//            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {
                	
                    System.out.println("--------------------------------------");  
                    System.out.println("����ִ�е�¼ "+txt_LoginID+EntityUtils.toString(entity));  
                    System.out.println("--------------------------------------"); 
                    
                    String urlAfter1 = "http://zwfp.jxnu.jadl.net/MainFunctionPage.aspx";
                    String s = HttpGet(urlAfter1,httpclient);
                    String urlAfter2 = "http://zwfp.jxnu.jadl.net/BookSeat/BookModelChoose.aspx";
                    HttpGet(urlAfter2,httpclient);
                    String urlAfter3 = "http://zwfp.jxnu.jadl.net/BookSeat/BookSeatListForm.aspx";
                    HttpGet(urlAfter3,httpclient);
                    System.out.println(Retrun__VIEWSTATE(s)); 
                    TestFid.TestFid(httpclient);
                    String urlAfter4 = CreatSeatURl(RoomNo, SeatNo, Date);
                    s = HttpGet(urlAfter4, httpclient);
                    SeatChoose.SeatChoose(urlAfter4, httpclient);
                    
                    
                   
                }  
            } finally {  
                response.close(); 
                
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // �ر�����,�ͷ���Դ    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
		
	}
	
	//Getҳ����ʺ���
	public static final String HttpGet(String urlAfter,CloseableHttpClient httpclient) {
		
		try {
			HttpGet httpget = new HttpGet(urlAfter);
	        CloseableHttpResponse response2;
	        httpget.addHeader("Cache-Control", "max-age=0");
	        httpget.addHeader("Accept" , "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
	        httpget.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
	        httpget.addHeader("Upgrade-Insecure-Requests", "1");
	        httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");
	        httpget.addHeader("Accept-Encoding", "gzip, deflate, sdch");
			response2 = httpclient.execute(httpget);
			HttpEntity entity2 = response2.getEntity();
			String s = EntityUtils.toString(entity2, "UTF-8");
			System.out.println("--------------------------------------");  
			System.out.println("ҳ�����: " + urlAfter);
//			System.out.println(s);
		    return s;
		        
		} catch (ClientProtocolException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
       
		
		return null;
		
	}
	
	public static final String Retrun__VIEWSTATE(String s) {
		// ��ָ��ģʽ���ַ�������
    	String str = "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/wEPDwUKMTI4NTE4MjA1NQ9kFgICAw9kFhQCAQ8WAh4JaW5uZXJodG1sBRHoh6rkuaDlrqQzMDIo5YyXKWQCAg8WAh8ABQNEMDlkAgMPFgIfAAUG5Zyo5bqnZAIEDxYCHwAFCDExOjAzOjI0ZAIFDxYCHwAFTOWcqOe7iOerrzIwMTUwMzA5MDEzMDPliLfljaHlu7bplb/oh6rkuaDlrqQzMDIo5YyXKSBEMDnlj7fluqfkvY3kvb/nlKjml7bpl7RkAgYPFgIeB1Zpc2libGVnZAIKDxYCHwFnZAILDxYCHwFoZAIMDxYCHwFnZAINDxYEHwBlHwFoZGTkf9Or2mHHTz+p3rlGnbKlPFDptvJ3jymqfqA81zpucA==\" />";
        Matcher m = Pattern.compile("<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"([\\s\\S]*)\"").matcher(str);
        while(m.find()){
            System.out.println("AAA"+m.group(1));
            s=m.group(1).toString();
        }
		return s;
		
	}
	
	//����ѡ��ҳ���URL
	public static final String CreatSeatURl(String RoomNo,String SeatNo,String Date) {
		String S = "http://zwfp.jxnu.jadl.net/BookSeat/BookSeatMessage.aspx?seatNo="+RoomNo+SeatNo+"&seatShortNo="+SeatNo+"&roomNo="+RoomNo+"&date="+Date+"&timeSpan=";
		System.out.println(S);
		return S;
	}
	
}
	
	