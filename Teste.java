public class Teste {

	
	public static void main(String[] args ) {
		Mesa m = new Mesa();
		Cozinheiro c1 = new Cozinheiro(1, m);
		Cozinheiro c2 = new Cozinheiro(2, m);
		Glutao g1 = new Glutao(1, m);
		Glutao g2 = new Glutao(2, m);
		c1.start();
		g1.start();
		
	}
}
