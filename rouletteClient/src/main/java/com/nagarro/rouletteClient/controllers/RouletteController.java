package com.nagarro.rouletteClient.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.nagarro.rouletteClient.models.RouletteBet;
import com.nagarro.rouletteClient.models.betCalculation.BetAmountCalculation;
import com.nagarro.rouletteClient.models.betCalculation.BlockAmount;


@RestController
public class RouletteController {
	
	private String baseUrl="http://localhost:8080/";
	
	/**
	 * function to check uuid exits or not
	 * @param uuid 
	 * @return customer data in string
	 */
	
	@CrossOrigin("*")
	@GetMapping(value="checkClientUuid/{uuid}")
	public String CheckUuid(@PathVariable("uuid") String uuid){
		
		final String uri = baseUrl+"checkClientUuid/"+uuid;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri,String.class);		
		return result;
	}
	
	/**
	 * function to block the required amount
	 * @param id
	 * @param blockedAmount
	 * @return void
	 */
	@CrossOrigin("*")
	@GetMapping(value="blockAmount/{id}/{blockedAmount}")
	public String blockThisAmount(@PathVariable("id") String id,@PathVariable("blockedAmount") String blockedAmount){
		
		final String uri = baseUrl+"blockAmount/"+id+"/"+blockedAmount;
		RestTemplate restTemplate = new RestTemplate();
		String result=restTemplate.getForObject(uri,String.class);
		return result;
		
	}
		
	//*****************************play game for this id ***************************************
	@CrossOrigin("*")
	@PostMapping(value="/playgame/{id}")
	public String gameResult(@PathVariable("id") String id,@RequestBody RouletteBet rouletteBet){
		
		// ***********************Api call for blocking the Amount*****************************
		BlockAmount blockSum=new BlockAmount();
		final int blockCurrentSum=blockSum.blockThisAmount(rouletteBet);
		final String url=baseUrl+"blockAmount/"+id+"/"+blockCurrentSum;
		RestTemplate restTemplateOne = new RestTemplate();
		restTemplateOne.getForObject(url,String.class);
		
		
		/* ************************ API to calculate bet amount and update *************************************/
		BetAmountCalculation calculateBet=new BetAmountCalculation();		
		int data1[] = new int[2];
		data1=calculateBet.calculate(rouletteBet);
		final int netAmount=data1[1];				
		final String uri=baseUrl+"updateBalance/"+id+"/"+netAmount;
		
		RestTemplate restTemplate = new RestTemplate();
		String result=restTemplate.getForObject(uri,String.class);
		result=result.substring(0, result.length() - 1);
		String randomNumberGenerated = Integer.toString(data1[0]);
		result=result+ ",\"randomNumberGenerated\""+":"+randomNumberGenerated+"}";		
		return result;
	}
	
}
