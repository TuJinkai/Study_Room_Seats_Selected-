package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

public class SeatMessage {
	//��ȡѡ����Ϣ������
	public static final  ArrayList<String []> ChooseSeatUser() {
		
//		File file = new File("/home/tu/SeatChoose-Linux/ChooseSeatUser.txt");
//		File file = new File("C:\\ChooseSeatUser\\ChooseSeatUser.txt");
		File file = new File("User.txt");
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
	
	
	public static final Calendar getAfterDay(Calendar cl) {   
        // ʹ��roll�������лع�����һ���ʱ��  
        // cl.roll(Calendar.DATE, 1);  
        // ʹ��set����ֱ������ʱ��ֵ  
        int day = cl.get(Calendar.DATE);  
        cl.set(Calendar.DATE, day + 1);  
        return cl;  
    }  

}
