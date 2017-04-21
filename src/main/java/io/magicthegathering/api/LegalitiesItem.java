package io.magicthegathering.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class LegalitiesItem{

	@JsonProperty("legality")
	private String legality;

	@JsonProperty("format")
	private String format;

	public void setLegality(String legality){
		this.legality = legality;
	}

	public String getLegality(){
		return legality;
	}

	public void setFormat(String format){
		this.format = format;
	}

	public String getFormat(){
		return format;
	}

	@Override
 	public String toString(){
		return 
			"LegalitiesItem{" + 
			"legality = '" + legality + '\'' + 
			",format = '" + format + '\'' + 
			"}";
		}
}