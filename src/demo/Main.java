package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

	public static void main(String[] args)  {
		// TODO �Զ����ɵķ������
		 
		
		for(;;) {

			ChooseSeatLoop();		
			
		}
		
		 

	}
	
	//ѡ��ѭ��
	public static final void ChooseSeatLoop(){
		
		Calendar now2 = Calendar.getInstance();
		System.out.println("����ʱ��"+now2.get(Calendar.HOUR_OF_DAY)+"��"+now2.get(Calendar.MINUTE)+"��");

			ArrayList<String []> list = new ArrayList<>();
			list = ChooseSeatUser();
			
				System.out.println("Hello !!");
				//��ȡ��ǰ���ڵĺ�һ��&�����ύPOST���ַ���
				now2 = getAfterDay(now2);
				String Day = now2.get(Calendar.YEAR)+"-"+(now2.get(Calendar.MONTH)+1)+"-"+(now2.get(Calendar.DAY_OF_MONTH));

                //ѡ��
				for (int i = 0; i < list.size(); i++) {
    				System.out.println("����ѡ�����˺��ǣ�"+list.get(i)[0]);
					FindSeat.FindSeat(list.get(i)[0],list.get(i)[1],list.get(i)[2],list.get(i)[3],Day);	
    			}
						
	}
	
	
	//��ȡѡ����Ϣ������
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
				//��ӡ�˺��������ڲ���
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
	        // ʹ��roll�������лع�����һ���ʱ��  
	        // cl.roll(Calendar.DATE, 1);  
	        // ʹ��set����ֱ������ʱ��ֵ  
	        int day = cl.get(Calendar.DATE);  
	        cl.set(Calendar.DATE, day + 1);  
	        return cl;  
	    }  

}
