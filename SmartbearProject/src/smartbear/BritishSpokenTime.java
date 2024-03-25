package smartbear;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BritishSpokenTime implements CountrySpokenTime{

	/**
	 * Creates a matcher that will match the given input against this pattern.
	 *
	 * @param input The String to be matched
	 *
	 * @return true : if input match with REGEX, false if not match
	 */

	public boolean isValidInput(String input, String regex) {
		if (input == null || input.isEmpty()) {
			return false;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		// System.out.println(matcher.find());
		return matcher.find();
	}

	public  String spokenTime(String input) {
		String inputArray[] = input.split(":");
		String hourPart = inputArray[0];
		String minutePart = inputArray[1];
		if (hourPart.equals(NumnerToWordConverterConstant.ZERO_FORMAT)) {
			return handleMidNightTime(minutePart);
		}
		if (hourPart.equals(NumnerToWordConverterConstant.NOON_FORMAT)) {
			return handleNoonTime(minutePart);
		}
		if (minutePart.equals(NumnerToWordConverterConstant.ZERO_FORMAT)) {
			return exactCloclTime(hourPart);
		}
		return otherTime(hourPart, minutePart);

	}

	private  String handleMidNightTime(String minutePart) {
		if (minutePart.equals(NumnerToWordConverterConstant.ZERO_FORMAT))
			return NumnerToWordConverterConstant.MID_NIGHT;
		else {
			int minuteValue = getStringToIntegerValue(minutePart);

			if (minuteValue <= 30) {
				return getTimeBeforeHalf(minuteValue, NumnerToWordConverterConstant.MID_NIGHT);
			} else {
				return getTimeAfterHalf(minuteValue, NumnerToWordConverterConstant.ONE);
			}

		}
	}

	private  String handleNoonTime(String minutePart) {
		if (minutePart.equals(NumnerToWordConverterConstant.ZERO_FORMAT))
			return NumnerToWordConverterConstant.NOON;
		else {
			int minuteValue = getStringToIntegerValue(minutePart);
			if (minuteValue <= 30) {
				return getTimeBeforeHalf(minuteValue, NumnerToWordConverterConstant.TWELVE);
			} else {
				return getTimeAfterHalf(minuteValue, NumnerToWordConverterConstant.ONE);
			}
		}

	}

	private  String exactCloclTime(String hourPart) {
		int hourValue = getStringToIntegerValue(hourPart);
		return NumnerToWordConverterConstant.covertNumerToWord(hourValue) + " o'clock";
	}

	private static String getTimeBeforeHalf(int minuteValue, String spokenHour) {
		if (minuteValue <= 10 || minuteValue == 15 || minuteValue % 10 == 0)
			return NumnerToWordConverterConstant.covertNumerToWord(minuteValue) + " " + NumnerToWordConverterConstant.PAST + " "
					+ spokenHour;
		else {
			int rem = minuteValue % 10;
			return NumnerToWordConverterConstant.covertNumerToWord(10 * (minuteValue / 10)) + " "
					+ NumnerToWordConverterConstant.covertNumerToWord(rem) + " " + NumnerToWordConverterConstant.PAST + " " + " "
					+ spokenHour;
		}
	}

	private String getTimeAfterHalf(int minuteValue, String spokenHour) {
		int remainingMinute = 60 - minuteValue;
		int rem = remainingMinute % 10;
		if (minuteValue == 45) {
			return NumnerToWordConverterConstant.covertNumerToWord(minuteValue) + " " + NumnerToWordConverterConstant.TO + " " + " "
					+ spokenHour;
		}
		if (rem == 0 || remainingMinute < 10)
			return NumnerToWordConverterConstant.covertNumerToWord(remainingMinute) + " " + NumnerToWordConverterConstant.TO + " " + " "
					+ spokenHour;
		else
			return NumnerToWordConverterConstant.covertNumerToWord(10 * (remainingMinute / 10))
					+ NumnerToWordConverterConstant.covertNumerToWord(remainingMinute % 10) + " " + NumnerToWordConverterConstant.TO
					+ " " + spokenHour;
	}

	private int getStringToIntegerValue(String input) {
		int minuteValue;
		if (Integer.valueOf(input.charAt(0)) == 0) {
			minuteValue = Integer.valueOf(input.charAt(1));
		} else {
			minuteValue = Integer.valueOf(input);
		}
		return minuteValue;
	}

	private String otherTime(String hourTime, String minutePart) {
		int hourValue = getStringToIntegerValue(hourTime);
		int minValue = getStringToIntegerValue(minutePart);

		String hourWord = NumnerToWordConverterConstant.covertNumerToWord(hourValue);
		if (minValue <= 30) {
			return getTimeBeforeHalf(minValue, hourWord);
		} else {
			return getTimeAfterHalf(minValue, NumnerToWordConverterConstant.covertNumerToWord(hourValue + 1));

		}
	}
	
	@Override
	public String getSpokenTime(String input, TimeFormatType timeFormatType) {
		if(timeFormatType.equals(TimeFormatType.TWELVE_HOUR_FORMAT)) {
			if(isValidInput(input, NumnerToWordConverterConstant.TWELVE_HOUR_TIME_REGEX)) {
				return spokenTime(input);
			}else {
				return "Wrong input time format, eccepted format is : 'HH:MM'";
			}
		}
		return "Time format not supported yet";
	}
}
