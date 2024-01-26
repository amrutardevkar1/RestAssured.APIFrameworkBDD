package paylodBody;

import java.util.ArrayList;
import java.util.List;

import pojoClasses.AddPlacePojo;
import pojoClasses.LocationPojo;

public class AddPlacePayload {
	
	public AddPlacePojo AddPlacePayloadBody()
	{
		AddPlacePojo ap = new AddPlacePojo();
		LocationPojo lp = new LocationPojo();
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		
		lp.setLat(-38.383494);
		lp.setLng(33.427362);
		
		ap.setLocation(lp);
		ap.setAccuracy(50);
		ap.setName("Rahul Shetty Academy");
		ap.setAddress("29, side layout, cohen 09");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setTypes(types);
		ap.setWebsite("http://rahulshettyacademy.com");
		ap.setLanguage("French-IN");
		
		return ap;
		
		
	}
	
	

}
