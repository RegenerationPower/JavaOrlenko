package Laba9.first;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private final ReentrantLock reentrantLock = new ReentrantLock();
	private BigDecimal money;
	private final UUID id;

	public BankAccount() {
		this.money = BigDecimal.valueOf(0);
		this.id = UUID.randomUUID();
	}

	public BigDecimal getMoney() {
		reentrantLock.lock();
		BigDecimal result = new BigDecimal(money.toString());
		reentrantLock.unlock();
		return result;
	}

	public void addMoney(double amount) {
		if (amount > 0) {
			BigDecimal decimal = BigDecimal.valueOf(amount);
			reentrantLock.lock();
			money = money.add(decimal);
			reentrantLock.unlock();
		}
	}

	public boolean withdrawMoney(double amount) {
		if (amount > 0) {
			BigDecimal decimal = BigDecimal.valueOf(amount);
			reentrantLock.lock();
			boolean ready = money.compareTo(decimal) >= 0;
			if (ready) {
				money = money.subtract(decimal);
			}
			reentrantLock.unlock();
			return ready;
		}
		return false;
	}

	public UUID getId() {
		return id;
	}
}
