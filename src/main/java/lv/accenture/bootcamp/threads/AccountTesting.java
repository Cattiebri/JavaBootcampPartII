package lv.accenture.bootcamp.threads;

public class AccountTesting {

    private Account acct = new Account();

    public static void main(String[] args) {
        AccountTesting accountTesting = new AccountTesting();
        Thread one = new Thread(accountTesting.new DepositThread());
        Thread two = new Thread(accountTesting.new DepositThread());
        one.setName("Vasya");
        two.setName("Masha");
        one.start();
        two.start();
    }

    private synchronized void makeWithdrawal(int amt) {
        if (acct.getBalance() >= amt) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
            acct.withdraw(amt);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
        } else {
            System.out.println("Not enough in account for " + Thread.currentThread().getName()
                    + " to withdraw | Current balance : " + acct.getBalance());
        }
    }

    private class DepositThread implements Runnable {
        @Override
        public void run() {
            for (int x = 0; x < 5; x++) {
                makeWithdrawal(10);
                if (acct.getBalance() < 0) {
                    System.out.println("account is overdrawn!");
                }
            }
        }
    }

}
