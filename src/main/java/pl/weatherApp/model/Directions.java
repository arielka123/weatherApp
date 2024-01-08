package pl.weatherApp.model;

public class Directions {

    public static String findDirectionName(int windValue) {
        if (windValue == 0 || windValue == 360) {
            return "N";
        }
        if (windValue > 0 && windValue < 90) {
            return "NE";
        }
        if (windValue == 90) {
            return "E";
        }
        if (windValue > 90 && windValue < 180) {
            return "SE";
        }
        if (windValue == 180) {
            return "S";
        }
        if (windValue > 180 && windValue < 270) {
            return "SW";
        }
        if (windValue == 270) {
            return "W";
        }
        if (windValue > 270 && windValue < 360) {
            return "NW";
        }
        return null;
    }
}
