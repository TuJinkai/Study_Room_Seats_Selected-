package thread;

import java.util.ArrayList;
import java.util.Calendar;

import demo.FindSeat;

/**
 * 测试线程
 */
public class Demo {
	
    public static void main(String[] args) {
    	
    	ArrayList<Thread> threads = new ArrayList<>();
    	for(int i=0;i<=10;i++){
    		Thread thread = new MyThread();
    		threads.add(thread);
        }

    	for(int i=0;i<=10;i++){
    		threads.get(i).start();
        }
    }
    
    
}
/**
 * 线程
 */
class MyThread extends Thread{
    public void run(){
    	
    	Calendar now3 = Calendar.getInstance();
		System.out.println("Hello !!");
		//获取当前日期的后一天&生成提交POST用字符串
		now3 = getAfterDay(now3);
		String Day = now3.get(Calendar.YEAR)+"-"+(now3.get(Calendar.MONTH)+1)+"-"+(now3.get(Calendar.DAY_OF_MONTH));
		System.out.println("Hello !!"+Day);
    	
		for(;;)
    		FindSeat.FindSeat("201467003082","201467003082","101002","B07", Day);
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



