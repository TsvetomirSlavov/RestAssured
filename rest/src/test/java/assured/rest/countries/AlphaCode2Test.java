package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import assured.rest.BaseRest;

import com.jayway.restassured.response.Response;

public class AlphaCode2Test extends BaseRest{
	
	private static final String URI_PREFIX = getBaseUri() + getAlpha2Resource();	
	
	@Test (dataProvider = "Countries")
	public void search_for_countries_alpha2code(String country, String name, String aplha2, String alpha3) {
		final String URI = URI_PREFIX + country;
		final Response RESPONSE = get(URI);
		RESPONSE.then().assertThat().body(getResponseNameSingleResult(), equalTo(name));
		RESPONSE.then().assertThat().body(getResponseAlpha2SingleResult(), equalTo(aplha2));
		RESPONSE.then().assertThat().body(getResponseAlpha3SingleResult(), equalTo(alpha3));
		show_output_service_from_uri(URI);
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
