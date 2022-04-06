package com.lec.ex5_atm;

//ATM card = new ATM(20000) 
//ATM_Target target = new ATM_target(20000) 
public class ATM_Target implements Runnable {

	private boolean flag;
	private ATM card;

	public ATM_Target(ATM card) {
		this.card = card;
	}

	@Override
	public void run() {
		// 저금 출금 반복
		for (int i = 0; i < 10; i++) {
			if (flag) {// 출금
				card.withdrow(1000, Thread.currentThread().getName());
				flag = false;
			} else {// 적금
				card.deposit(1000, Thread.currentThread().getName());
				flag = true;
			}
		}

	}
}
