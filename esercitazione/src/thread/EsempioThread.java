package thread;

public class EsempioThread implements Runnable {
	
	private int numeroThread;
	
	public EsempioThread(int n){
		setNumeroThread(n);
	}
	
	public void setNumeroThread(int numeroThread){
		this.numeroThread = numeroThread;
	}
	
	public int getNumeroThread(){
		return numeroThread;
	}
	
	public void run(){
		int n;
		for(n=0; n<6; n++){
			System.out.println("*** thread numero" + getNumeroThread() + " in esecuzione");
			System.out.println("l'indice n vale: " + n);
		}
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException exc){
			System.out.println("Errore");
		}
	}
}
