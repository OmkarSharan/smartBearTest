package smartbear;

import java.util.HashMap;
import java.util.Map;

public class NumnerToWordConverterConstant {
	
	public static final String MID_NIGHT = "midnight";
	public static final String NOON = "noon";
	public static final String PAST = "past";
	public static final String TO = "to";
	public static final String ZERO_FORMAT = "00";
	public static final String NOON_FORMAT = "12";
	public static final String TWELVE = "twelve";
	public static final String ONE = "one";
	public static final String BRITISH_LANGUAGE = "BRITISH";
	
	public static String TWELVE_HOUR_TIME_REGEX = "^(00|0[0-9]|[1-9]|1[012]):[0-5][0-9]";
	
	public static Map<Integer, String> specialSpokenWords;
	static {
		specialSpokenWords = new HashMap<>();
		specialSpokenWords.put(15, "quarter");
		specialSpokenWords.put(30, "half");
		specialSpokenWords.put(45, "quarter");
		specialSpokenWords.put(1, "one");
		specialSpokenWords.put(2, "two");
		specialSpokenWords.put(3, "three");
		specialSpokenWords.put(4, "four");
		specialSpokenWords.put(5, "five");
		specialSpokenWords.put(6, "six");
		specialSpokenWords.put(7, "seven");
		specialSpokenWords.put(8, "eight");
		specialSpokenWords.put(9, "nine");
		specialSpokenWords.put(10, "ten");
		specialSpokenWords.put(11, "eleven");
		specialSpokenWords.put(12, "twelve");
		specialSpokenWords.put(13, "thirtheen");
		specialSpokenWords.put(14, "fourteen");
		specialSpokenWords.put(16, "sixteen");
		specialSpokenWords.put(17, "seventeen");
		specialSpokenWords.put(18, "eighteen");
		specialSpokenWords.put(19, "ninteen");
		specialSpokenWords.put(20, "twenty");
		specialSpokenWords.put(40, "fourty");
		specialSpokenWords.put(50, "fifty");
		specialSpokenWords.put(60, "sixty");
		
	}
	
	public static String covertNumerToWord(Integer number) {
		if(specialSpokenWords.containsKey(number))
			return specialSpokenWords.get(number);
		return null;
	}
}
