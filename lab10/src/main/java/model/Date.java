package model;

import java.util.Objects;

public class Date {
    private String departDate;
    private String returnDate;

    public Date(String departDate, String returnDate) {
        this.departDate = departDate;
        this.returnDate = returnDate;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(departDate, date.departDate) &&
                Objects.equals(returnDate, date.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departDate, returnDate);
    }
}
