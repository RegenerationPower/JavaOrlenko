package Laba9.second;

public class CircuitBuffer<T> {
	private final Object lock = new Object();
	private final int size;
	private final T[] buffer;
	private int head;
	private int tail;
	private volatile int count;

	@SuppressWarnings("unchecked")
	public CircuitBuffer(int size) {
		this.size = size;
		buffer = (T[]) new Object[size];
		count = 0;
		head = 0;
		tail = 0;
	}

	public void put(T value) {
		synchronized (lock) {
			while (count == size) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			buffer[tail] = value;
			tail = (tail + 1) % size;
			count++;
			lock.notifyAll();
		}
	}

	public T get() {
		synchronized (lock) {
			while (count == 0) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			T value = buffer[head];
			head = (head + 1) % size;
			count--;
			lock.notifyAll();
			return value;
		}
	}
}
