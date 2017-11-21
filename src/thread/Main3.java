package thread;

import java.util.ArrayList;
import java.util.Calendar;

import demo.FindSeat;
import demo.SeatMessage;
/**
 * 
 * @author TuJinkai
 * 自动选座的PC版本
 *
 */
public class Main3 {

	public static void main(String[] args)  {
		// TODO 自动生成的方法存根
		ArrayList<Thread> threads = new ArrayList<>();
    	for(int i=0;i<=2;i++){
    		Thread thread = new SeatThreadMain();
    		threads.add(thread);
        }

    	for(int i=0;i<=2;i++){
    		threads.get(i).start();
        }
    }
	


		//选座循环
		public final void ChooseSeatLoop() throws InterruptedException{
			//获取当前时间
			Calendar now2 = Calendar.getInstance();
			System.out.println("现在时间"+now2.get(Calendar.HOUR_OF_DAY)+"点"+now2.get(Calendar.MINUTE)+"分");
			Thread.sleep(1000);
			
			//获取选座账号信息
			ArrayList<String []> list = new ArrayList<>();
			list = SeatMessage.ChooseSeatUser();
			
			//获取当前日期的后一天
			now2 = SeatMessage.getAfterDay(now2);
			String Day = now2.get(Calendar.YEAR)+"-"+(now2.get(Calendar.MONTH)+1)+"-"+(now2.get(Calendar.DAY_OF_MONTH));
			
			//动态线程创建
			ArrayList<Thread> threads = new ArrayList<>();
	    	for(int i=0;i<list.size();i++){
	    		Thread thread = new SeatChooseThread(list.get(i)[0],list.get(i)[1],list.get(i)[2],list.get(i)[3],Day);
	    		threads.add(thread);
	        }
	    	//执行线程
	    	for(int i=0;i<list.size();i++){
	    		threads.get(i).start();
	        }
							
		}


			
}
//选座主线程
class SeatThreadMain extends Thread{
		public void run() {
			try {
				Main3 main = new Main3();
				main.ChooseSeatLoop();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

//选座子线程
class SeatChooseThread extends Thread{
	
	private String Day;
	private String list0;
	private String list1;
	private String list2;
	private String list3;

	public void run() {
		System.out.println("现在选座的账号是："+list0);
		//循环选座
		for(;;)
			FindSeat.FindSeat(list0,list1,list2,list3,Day);
	}
	
	public SeatChooseThread(String list0,String list1,String list2,String list3,String Day) {
		this.Day = Day;
		this.list0 = list0;
		this.list1 = list1;
		this.list2 = list2;
		this.list3 = list3;
	}	

}
	