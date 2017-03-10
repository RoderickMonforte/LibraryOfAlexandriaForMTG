package io.magicthegathering.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Result{

	@JsonProperty("cards")
	private List<CardsItem> cards;

	public void setCards(List<CardsItem> cards){
		this.cards = cards;
	}

	public List<CardsItem> getCards(){
		return cards;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"cards = '" + cards + '\'' + 
			"}";
		}
}