package thread;

import java.util.ArrayList;
import java.util.Calendar;

import demo.FindSeat;
import demo.SeatMessage;
/**
 * 
 * @author TuJinkai
 * �Զ�ѡ����PC�汾
 *
 */
public class Main3 {

	public static void main(String[] args)  {
		// TODO �Զ����ɵķ������
		ArrayList<Thread> threads = new ArrayList<>();
    	for(int i=0;i<=2;i++){
    		Thread thread = new SeatThreadMain();
    		threads.add(thread);
        }

    	for(int i=0;i<=2;i++){
    		threads.get(i).start();
        }
    }
	


		//ѡ��ѭ��
		public final void ChooseSeatLoop() throws InterruptedException{
			//��ȡ��ǰʱ��
			Calendar now2 = Calendar.getInstance();
			System.out.println("����ʱ��"+now2.get(Calendar.HOUR_OF_DAY)+"��"+now2.get(Calendar.MINUTE)+"��");
			Thread.sleep(1000);
			
			//��ȡѡ���˺���Ϣ
			ArrayList<String []> list = new ArrayList<>();
			list = SeatMessage.ChooseSeatUser();
			
			//��ȡ��ǰ���ڵĺ�һ��
			now2 = SeatMessage.getAfterDay(now2);
			String Day = now2.get(Calendar.YEAR)+"-"+(now2.get(Calendar.MONTH)+1)+"-"+(now2.get(Calendar.DAY_OF_MONTH));
			
			//��̬�̴߳���
			ArrayList<Thread> threads = new ArrayList<>();
	    	for(int i=0;i<list.size();i++){
	    		Thread thread = new SeatChooseThread(list.get(i)[0],list.get(i)[1],list.get(i)[2],list.get(i)[3],Day);
	    		threads.add(thread);
	        }
	    	//ִ���߳�
	    	for(int i=0;i<list.size();i++){
	    		threads.get(i).start();
	        }
							
		}


			
}
//ѡ�����߳�
class SeatThreadMain extends Thread{
		public void run() {
			try {
				Main3 main = new Main3();
				main.ChooseSeatLoop();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

//ѡ�����߳�
class SeatChooseThread extends Thread{
	
	private String Day;
	private String list0;
	private String list1;
	private String list2;
	private String list3;

	public void run() {
		System.out.println("����ѡ�����˺��ǣ�"+list0);
		//ѭ��ѡ��
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
	