
public class Glutao extends Thread {

	private int id;
	private Mesa m;

	public Glutao(int id, Mesa m) {
		this.id = id;
		this.m = m;
	}

	public int getIdG() {
		return id;
	}

	public void run() {
		/*
		 * for (int i = 0; i < 10; i++) { try { Javali j = m.get(); } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 * 
		 * }
		 */
		double start = System.currentTimeMillis();
		double end = start + 0.5 * 1000;
		while (System.currentTimeMillis() < end) {
			try {
				Javali j = m.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
