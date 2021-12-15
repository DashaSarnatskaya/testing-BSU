package service;

import model.Location;

public class LocationsCreator {

    public static final String TESTDATA_DEPARTURE_PLACE = "testdata.departure.place";
    public static final String TESTDATA_DESTINATION_PLACE = "testdata.destination.place";

    public static Location locationsFromProperty() {
        return new Location(TestDataReader.getTestData(TESTDATA_DEPARTURE_PLACE),
                TestDataReader.getTestData(TESTDATA_DESTINATION_PLACE));
    }
}
