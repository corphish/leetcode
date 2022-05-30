import java.time.LocalDate;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        return new String[] {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
        } [
            LocalDate.of(year, month, day).getDayOfWeek().getValue() - 1
        ];
    }
}