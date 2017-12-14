package com.nagarro.rouletteClient.models.betCalculation;

import com.nagarro.rouletteClient.models.RouletteBet;

public class BlockAmount {
	
	public int blockThisAmount(RouletteBet rouletteBet){
		int netAmount=0;
		netAmount+=rouletteBet.getFirstTwelvePosition();
		netAmount+=rouletteBet.getSecondTwelvePosition();
		netAmount+=rouletteBet.getThirdTwelvePosition();
		netAmount+=rouletteBet.getZerothPosition();
		netAmount+=rouletteBet.getOneToEighteen();
		netAmount+=rouletteBet.getNinteenToThirtysix();
		netAmount+=rouletteBet.getEvenPosition();
		netAmount+=rouletteBet.getOddPosition();
		
		return netAmount;
	}
}
