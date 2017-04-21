package io.magicthegathering.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Result{

	@JsonProperty("card")
	private Card card;

	public void setCard(Card card){
		this.card = card;
	}

	public Card getCard(){
		return card;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"card = '" + card + '\'' + 
			"}";
		}
}