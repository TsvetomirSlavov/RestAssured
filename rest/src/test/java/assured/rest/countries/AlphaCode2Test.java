package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class AlphaCode2Test {
	
	private static final String URI = "http://services.groupkt.com/country/get/iso2code/";
	private static final String KEY_PREFIX = "RestResponse.result.";
	private static final String KEY_NAME = "name";
	private static final String KEY_ALPHA_CODE_2 = "alpha2_code";
	private static final String KEY_ALPHA_CODE_3 = "alpha3_code";
	
	
	@Test (dataProvider = "Countries")
	public void search_for_countries_alpha2code(String country, String name, String aplha2, String alpha3) {
		final Response RESPONSE = get(URI + country);
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_NAME, equalTo(name));
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_2, equalTo(aplha2));
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_3, equalTo(alpha3));
	}
	
	
	@DataProvider(name = "Countries")
	 
	  public static Object[][] countries() {
	 
	        return new Object[][] { 
	        		{ "IN", "India" , "IN" , "IND" }, 
	        		{ "GB", "United Kingdom of Great Britain and Northern Ireland" , "GB" , "GBR"},
	        		{ "NL", "Netherlands", "NL", "NLD"}
	        		};
	  }

}
