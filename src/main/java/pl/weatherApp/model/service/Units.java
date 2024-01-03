package pl.weatherApp.model.service;

public class Units {
    private String temp;
    private String speed;
    private String direction;
    private String precipitation;
    public static String degree = Character.toString((char)186);
    public static String temperature = (char)186 +"C";
    public static String pressure = "hPa";
    public static String wind = "km/h";
    public static String cloud ="%";
    public static String humidity ="%";
    public static String visibility ="m";
    public static String precipitation2 ="mm";  //TODO porządek z jednostkami

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}
