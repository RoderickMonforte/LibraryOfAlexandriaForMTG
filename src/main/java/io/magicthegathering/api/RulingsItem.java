package io.magicthegathering.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class RulingsItem{

	@JsonProperty("date")
	private String date;

	@JsonProperty("text")
	private String text;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"RulingsItem{" + 
			"date = '" + date + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}