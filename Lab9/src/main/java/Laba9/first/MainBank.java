package Laba9.first;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class MainBank {
	private static final Random random = new Random();
	private static final int TOTAL_ACCOUNTS = 777;
	private static final int TRANSFERS = 1000;

	public static void main(String[] args) {
		BankOperations bank = fillAccountsWithMoney();
		BigDecimal before = bank.totalMoney();
		randomTransfers(bank);
		BigDecimal after = bank.totalMoney();
		System.out.println("Before: " + before);
		System.out.println("After:  " + after);
	}

	private static BankOperations fillAccountsWithMoney() {
		BankOperations bank = new BankOperations();
		for (int i = 0; i < TOTAL_ACCOUNTS; i++) {
			BankAccount account = new BankAccount();
			account.addMoney(random.nextInt(100)*1000);
			bank.addAccount(account);
		}
		return bank;
	}

	private static void randomTransfers(BankOperations bank) {
		List<BankAccount> accounts = bank.getAccounts();
		for (int i = 0; i < TRANSFERS; i++) {
			new Thread(() -> {
				int fromI = random.nextInt(accounts.size());
				int toI = random.nextInt(accounts.size());
				BankAccount from = accounts.get(fromI);
				BankAccount to = accounts.get(toI);

				BigDecimal hasMoney = from.getMoney();
				double toTransfer = (hasMoney.doubleValue() * random.nextFloat());
				bank.transfer(from, to, toTransfer);
			}).start();
		}
	}
}
