package study.importjar;

import study.impl.HifiCalc;

public class user {

	public static void main(String[] args) {
		HifiCalc c =new HifiCalc();
		
		System.out.println(c.add(12,23));
		System.out.println(c.integerDivision(24,2));

	}

}
