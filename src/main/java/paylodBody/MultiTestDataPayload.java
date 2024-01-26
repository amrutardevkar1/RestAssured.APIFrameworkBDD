package paylodBody;

import java.util.ArrayList;
import java.util.List;

import pojoClasses.AddPlacePojo;
import pojoClasses.LocationPojo;

public class MultiTestDataPayload {
	
	public AddPlacePojo multiTestdataBody(String name, String address, String language)
	{
		AddPlacePojo mtd = new AddPlacePojo();
		LocationPojo lo = new LocationPojo();
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		
		mtd.setLocation(lo);
		mtd.setAccuracy(50);
		mtd.setName(name);
		mtd.setAddress(address);
		mtd.setPhone_number("(+91) 983 893 3937");
		mtd.setTypes(types);
		mtd.setWebsite("http://rahulshettyacademy.com");
		mtd.setLanguage(language);
		
		return mtd;
	}

}
