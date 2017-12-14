package com.nagarro.rouletteClient.models.betCalculation;

import java.util.concurrent.ThreadLocalRandom;

import com.nagarro.rouletteClient.models.RouletteBet;

public class BetAmountCalculation {
		
	public int[] calculate(RouletteBet rouletteBet){
		
		int data[] = new int[2]; 
		int randomNum = ThreadLocalRandom.current().nextInt(0, 36 + 1);
		data[0]=randomNum;
		System.out.println("/n/n/n/n/n");
		System.out.println("####################### RANDOMNUMBER IS \n\n\n"+randomNum+"\n\n\n");
		System.out.println("\n\n\n");
		int netAmount=0;		

		if(randomNum>=1&&randomNum<=12){
			System.out.println("executing : 1-12");
			netAmount+=rouletteBet.getFirstTwelvePosition()*1.5;
		}
		if(randomNum>12&&randomNum<=24){
			System.out.println("executing : 12-24");
			netAmount+=rouletteBet.getSecondTwelvePosition()*1.5;
		}
		if(randomNum>24&&randomNum<=36){
			System.out.println("executing : 24-36");
			netAmount+=rouletteBet.getThirdTwelvePosition()*1.5;
		}
		
		if(randomNum==0){
			System.out.println("executing : 0");
			netAmount+=rouletteBet.getZerothPosition()*10;
		}
		if(randomNum>=1&&randomNum<=18){
			System.out.println("executing : 1-18");
			netAmount+=rouletteBet.getOneToEighteen()*1.25;
		}
		if(randomNum>=19&&randomNum<=36){
			System.out.println("executing : 19-36");
			netAmount+=rouletteBet.getNinteenToThirtysix()*1.25;
		}
		if(randomNum>0&&randomNum%2==0){
			System.out.println("executing : EVEN");
			netAmount+=rouletteBet.getEvenPosition()*1.25;
		}
		if(randomNum%2!=0){
			System.out.println("executing : ODD");
			netAmount+=rouletteBet.getOddPosition()*1.25;		
		}
		
		//return netAmount;
		data[1]=netAmount;
		return data;
	}

	
}	