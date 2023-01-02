package Laba9.second;

import java.util.concurrent.atomic.AtomicInteger;

public class MainBuffer {
	private static final CircuitBuffer<String> circuitBuffer1 = new CircuitBuffer<>(10);
	private static final CircuitBuffer<String> circuitBuffer2 = new CircuitBuffer<>(10);
	private static final AtomicInteger prodCounter = new AtomicInteger(0);

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread generator = new Thread(() -> {
				while (!Thread.interrupted()) {
					String toPut = Thread.currentThread().getName() + " generate message: " + prodCounter.getAndIncrement();
					circuitBuffer1.put(toPut);
				}
			});
			generator.setDaemon(true);
			generator.start();
		}
		for (int i = 0; i < 2; i++) {
			Thread transfer = new Thread(() -> {
				while (!Thread.interrupted()) {
					String msg = circuitBuffer1.get();
					String toPut = Thread.currentThread().getName() + " transfer message: " + msg;
					circuitBuffer2.put(toPut);
				}
			});
			transfer.setDaemon(true);
			transfer.start();
		}

		for (int i = 0; i < 100; i++) {
			String msg = circuitBuffer2.get();
			System.out.println(msg);
		}
	}
}
