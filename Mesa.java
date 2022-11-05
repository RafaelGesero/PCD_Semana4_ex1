import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {

	private int capMax = 1;
	private LinkedList<Javali> javalis = new LinkedList<>();
	private Lock l = new ReentrantLock();
	private Condition novoJavaliMesa = l.newCondition();
	private Condition mesaVazia = l.newCondition();
	private Javali javaliConsumido = null;

	public Mesa() {
	}

	public void put(Javali newJavali) throws InterruptedException {
		l.lock();
		try {
			while (javalis.size() == capMax ) {
				mesaVazia.await();
				System.out.println();
			}

			javalis.add(newJavali);
			System.out.println("Um Javali foi adicionada á mesa");
			novoJavaliMesa.signalAll();
		} finally {
			l.unlock();
		}

	}

	public Javali get() throws InterruptedException {
		l.lock();
		try {
			while (javalis.isEmpty())
				novoJavaliMesa.await();
			javaliConsumido = javalis.removeFirst();
			mesaVazia.signalAll();
		} finally {
			l.unlock();
		}
		System.out.println("Um Javali foi consumido: " + javaliConsumido.getId());
		return javaliConsumido;
	}
}