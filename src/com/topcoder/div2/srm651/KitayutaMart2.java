package com.topcoder.div2.srm651;

public class KitayutaMart2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int numBought(int K, int T){
		return (int) (Math.log(T/K +1) / Math.log(2));
	}
}
