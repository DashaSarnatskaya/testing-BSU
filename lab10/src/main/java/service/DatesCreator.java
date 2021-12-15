package service;

import model.Date;

public class DatesCreator {
    public static final String TESTDATA_DEPART_DATE = "testdata.depart.date";
    public static final String TESTDATA_RETURN_DATE = "testdata.return.date";

    public static Date datesFromProperty() {
        return new Date(TestDataReader.getTestData(TESTDATA_DEPART_DATE),
                TestDataReader.getTestData(TESTDATA_RETURN_DATE));

    }
}
