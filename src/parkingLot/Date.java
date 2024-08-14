package parkingLot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    private LocalDate date;

    public Date(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
        validateDate();
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private void validateDate() {
        LocalDate minDate = LocalDate.of(1970, 1, 1);
        LocalDate maxDate = LocalDate.of(2099, 12, 31);

        if (date.isBefore(minDate) || date.isAfter(maxDate)) {
            throw new IllegalArgumentException("Date out of range (1970-01-01 to 2099-12-31)");
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
        validateDate();
    }
}
