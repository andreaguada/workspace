package ereditarietà;

public class ResponsabileDiProgetto extends Dipendente {
	int bonus;

	public int stipendio(){
		int stipendioBase = (getOreLavorativeMensili() * getRetribuzioneOraria());
		return stipendioBase + bonus;

	}

	public ResponsabileDiProgetto(String n, String c, int o, int r, int b) {
		super(n,c,o,r);
		bonus=b;
	}

}
