package smartbear;

import java.util.Scanner;

public class TimeSpokenApplication {
	public static void main(String[] args) {
		CountrySpokenTime countrySpokenTime = CountrySpokenTimeFactory.getCountSpokenTime(NumnerToWordConverterConstant.BRITISH_LANGUAGE);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the time format in 'HH:MM' format ");
		String input = sc.nextLine();
		System.out.println(countrySpokenTime.getSpokenTime(input, TimeFormatType.TWELVE_HOUR_FORMAT));
		sc.close();
	}
}
