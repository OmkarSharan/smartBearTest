package smartbear;

public class CountrySpokenTimeFactory {
	public static CountrySpokenTime getCountSpokenTime(String countryLanguage) {
		if(countryLanguage.equals("BRITISH")) {
			return new BritishSpokenTime();
		}else {
			System.out.println("Opps!!! Country spoken time is not implemented yet.");
		}
		return null;
	}
}
