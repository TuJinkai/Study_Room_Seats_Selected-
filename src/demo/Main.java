package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

	public static void main(String[] args)  {
		// TODO 自动生成的方法存根
		 
		
		for(;;) {

			ChooseSeatLoop();		
			
		}
		
		 

	}
	
	//选座循环
	public static final void ChooseSeatLoop(){
		
		Calendar now2 = Calendar.getInstance();
		System.out.println("现在时间"+now2.get(Calendar.HOUR_OF_DAY)+"点"+now2.get(Calendar.MINUTE)+"分");

			ArrayList<String []> list = new ArrayList<>();
			list = ChooseSeatUser();
			
				System.out.println("Hello !!");
				//获取当前日期的后一天&生成提交POST用字符串
				now2 = getAfterDay(now2);
				String Day = now2.get(Calendar.YEAR)+"-"+(now2.get(Calendar.MONTH)+1)+"-"+(now2.get(Calendar.DAY_OF_MONTH));

                //选座
				for (int i = 0; i < list.size(); i++) {
    				System.out.println("现在选座的账号是："+list.get(i)[0]);
					FindSeat.FindSeat(list.get(i)[0],list.get(i)[1],list.get(i)[2],list.get(i)[3],Day);	
    			}
						
	}
	
	
	//读取选座信息并返回
		public static final  ArrayList<String []> ChooseSeatUser() {
			
//			File file = new File("/home/tu/SeatChoose-Linux/ChooseSeatUser.txt");
			File file = new File("C:\\ChooseSeatUser\\ChooseSeatUser.txt");
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String s = null;
				ArrayList<String []> list = new ArrayList<>();
				String [] str;
				while ((s = reader.readLine())!=null) {
					str = s.split(",");
					list.add(str);
				}
				//打印账号密码用于测试
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i)[0]+" "+list.get(i)[1]+" "+list.get(i)[2]+" "+list.get(i)[3]);
					
				}
				reader.close();
				return list;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return null;
			
		}
		
		
		private static final Calendar getAfterDay(Calendar cl) {   
	        // 使用roll方法进行回滚到后一天的时间  
	        // cl.roll(Calendar.DATE, 1);  
	        // 使用set方法直接设置时间值  
	        int day = cl.get(Calendar.DATE);  
	        cl.set(Calendar.DATE, day + 1);  
	        return cl;  
	    }  

}
