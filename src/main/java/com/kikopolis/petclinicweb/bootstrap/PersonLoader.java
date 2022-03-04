package com.kikopolis.petclinicweb.bootstrap;

import java.util.Random;

abstract class PersonLoader {
	private final   String[] firstNames;
	private final   String[] lastNames;
	private final   String[] streets;
	private final   String[] cities;
	private final   String[] addresses;
	protected final Random   random;
	
	public PersonLoader(Random random) {
		this.random     = random;
		this.firstNames = this.firstNames();
		this.lastNames  = this.lastNames();
		this.streets    = this.streets();
		this.cities     = this.cities();
		this.addresses  = this.addresses();
	}
	
	public String randomFirstName() {
		return this.firstNames[this.random.nextInt(0, this.firstNames.length)];
	}
	
	public String randomLastName() {
		return this.lastNames[this.random.nextInt(0, this.lastNames.length)];
	}
	
	public String randomStreet() {
		return this.streets[this.random.nextInt(0, this.streets.length)];
	}
	
	public String randomCity() {
		return this.cities[this.random.nextInt(0, this.cities.length)];
	}
	
	public String randomAddress() {
		return this.addresses[this.random.nextInt(0, this.addresses.length)];
	}
	
	public String randomTelephone() {
		StringBuilder phoneNumber = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			phoneNumber.append(this.random.nextInt(0, 9));
		}
		return phoneNumber.toString();
	}
	
	private String[] firstNames() {
		return new String[]{
				"Patrick",
				"Keith",
				"Philip",
				"Felix",
				"Brian",
				"Noah",
				"Jordan",
				"Dylan",
				"Morgan",
				"Stephen",
				"Antonio",
				"William",
				"Erica",
				"Alexandra",
				"Andrea",
				"Carla",
				"Charlotte",
				"Marina",
				"Ingrid",
				"Bryce",
				"Emma",
				"Anna",
				"Elizabeth",
				"Marilyn",
				"Louise"};
	}
	
	private String[] lastNames() {
		return new String[]{
				"Robertson",
				"Smith",
				"Johnson",
				"Williams",
				"Brown",
				"Jones",
				"Garcia",
				"Miller",
				"Davis",
				"Rodriguez",
				"Martinez",
				"Lopez",
				"Wilson",
				"Anderson"
		};
	}
	
	private String[] streets() {
		return new String[]{
				"Adams",
				"Beverly",
				"Century",
				"Exposition",
				"Hollywood",
				"Jefferson",
				"Olympic",
				"Pico",
				"Roscoe",
				"Sunset",
				"Venice",
				"Ventura",
				"Victory",
				"Wilshire",
				"Avalon",
				"Beverly Glen",
				"Glendale",
				"Crenshaw",
				"Laurel",
				"Reseda",
				"Sepulveda",
				"Topanga",
				"Van Nuys",
				"Westwood",
				"Alameda",
				"Slauson",
				"Broadway",
				"Bundy",
				"Fairfax",
				"Figueroa",
		};
	}
	
	private String[] cities() {
		return new String[]{
				"El Paso",
				"Memphis",
				"Fresno",
				"Mesa",
				"Omaha",
				"Raleigh",
				"Miami",
				"Oakland",
				"Tulsa",
				"Bakersfield",
				"Wichita",
				"Arlington",
				"Aurora",
				"Tampa",
				"Honolulu",
				"Anaheim"
		};
	}
	
	private String[] addresses() {
		String[] arr = new String[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = this.random.nextInt(9999) + " " + this.randomStreet();
		}
		return arr;
	}
}
