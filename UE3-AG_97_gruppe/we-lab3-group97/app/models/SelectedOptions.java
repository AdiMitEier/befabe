package models;

import java.util.List;

public class SelectedOptions {
	public List<String> choice;
	public String toString(){
		if(choice!=null){
			String ret="";
			for(String c:choice){
				ret=ret+c;
			}
			return ret;
			
		}else {return "no value selected";}
	}
}
