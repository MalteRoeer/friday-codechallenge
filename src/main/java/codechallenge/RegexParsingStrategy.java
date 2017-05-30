package codechallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParsingStrategy {

	private Pattern pattern;
	
	
	public RegexParsingStrategy(String numberRegex){
		pattern = Pattern.compile(numberRegex);
	}
	
	public String[] buildResultArray(String line) throws RegexParsingException{
		
		Matcher matcher = pattern.matcher(line);
		
		if(!matcher.find()){
			throw new RegexParsingException();
		}
		
		String number = matcher.group(); 		
		StringBuffer sb = new StringBuffer();
		
		matcher.appendReplacement(sb, "");
		matcher.appendTail(sb);
		
		String street = sb.toString().trim();		
		
		String[] result = {street, number};
		
		return result;
	}
}
