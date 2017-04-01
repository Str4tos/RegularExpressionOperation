package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularAction {

	public int minimalValue = 0;
	public int value = 0;
	public String startSymbls;
	public String endSymbls;
	public String searchRegular;
	public enum TypeOfAction{
		Addition,
		Deduct,
		Multiply,
		Divide
	}
	private TypeOfAction typeAction;
	private Pattern regularPattern;

	public RegularAction(String searchRegular, String startSymbls, String endSymbls, int value, int minimalValue, TypeOfAction typeAction){
		this.startSymbls = startSymbls;
		this.searchRegular = searchRegular;
		this.endSymbls = endSymbls;
		this.value = value;
		this.minimalValue = minimalValue;
		this.typeAction = typeAction;
		regularPattern = Pattern.compile(startSymbls + searchRegular + endSymbls);
	}
	public String getResult(String fileString) {
		String resultFiileString = fileString;
		Matcher resultMatcher = regularPattern.matcher(fileString);
		while (resultMatcher.find()) {
			int oldValue = Integer.parseInt(resultMatcher.group().substring(1));
			if (oldValue < minimalValue)
				break;
			int newValue = 0;
			
			switch(typeAction){
			case Addition:
				newValue = oldValue + value;
				break;
			case Deduct:
				newValue = oldValue - value;
				break;
			case Multiply:
				newValue = oldValue * value;
				break;
			case Divide:
				newValue = oldValue / value;
				break;
			
			}
			resultFiileString = resultFiileString.replaceFirst(resultMatcher.group(), startSymbls + newValue + endSymbls);
		}
		return resultFiileString;
	}
}
