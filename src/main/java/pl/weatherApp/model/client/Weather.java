package pl.weatherApp.model.client;

public interface Weather {
    public static String cityName = "Warszawa";
    public Double temp = null;  //oC
    public Long humidity = null;   //%
    public Long pressure= null; //hPa
    public Double feels_like= null;
    public Long visibility= null; //km
    public String description= null;
    public Long clouds= null; //%
}
