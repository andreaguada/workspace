package thread;

public class ImplementazioneThread {
	public static void main (String args[]){
		EsempioThread r1 = new EsempioThread(1);
		EsempioThread r2 = new EsempioThread(2);
		
		Thread nuovoThread1 = new Thread(r1);
		Thread nuovoThread2 = new Thread(r2);
		
		nuovoThread1.start();
		nuovoThread2.start();
	}
}
