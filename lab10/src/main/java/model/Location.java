package model;

import java.util.Objects;

public class Location {
    private String departurePlace;
    private String destinationPlace;

    public Location(String departurePlace, String destinationPlace) {
        this.departurePlace = departurePlace;
        this.destinationPlace = destinationPlace;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String placeOfDeparture) {
        this.departurePlace = placeOfDeparture;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String placeOfDestination) {
        this.destinationPlace = placeOfDestination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(departurePlace, location.departurePlace) &&
                Objects.equals(destinationPlace, location.destinationPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departurePlace, destinationPlace);
    }
}
