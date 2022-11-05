
public class Cozinheiro extends Thread {

	private int id;
	private int Nordem = 0;
	private Mesa m;

	public Cozinheiro(int id, Mesa m) {
		this.id = id;
		this.m = m;
	}

	public int getIdC() {
		return id;
	}

	public Javali produzJavali() {
		Javali j = new Javali(Nordem, id);
		Nordem++;
		return j;
	}

	public void run() {
		/*
		 * for (int i = 0; i < 10; i++) { Javali j = produzJavali(); try { m.put(j); }
		 * catch (InterruptedException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } }
		 */
		double start = System.currentTimeMillis();
		double end = start + 0.5 * 1000;
		while (System.currentTimeMillis() < end) {
			Javali j = produzJavali();
			try {
				System.out.println("javali feito: " + j.getId());
				System.out.println();
				m.put(j);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
