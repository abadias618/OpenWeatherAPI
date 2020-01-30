import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class WeatherForecastItem {
    @SerializedName("dt_txt")
    private  String date;
    @SerializedName("main")
    private Map<String, Float> temperature;
    @SerializedName("weather")
    private List<Map<String,String>> weatherDescription;
    @SerializedName("wind")
    private Map<String,Float> windSpeed;

    public List<Map<String, String>> getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(List<Map<String, String>> weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Float> getTemperature() {
        return temperature;
    }

    public void setTemperature(Map<String, Float> temperature) {
        this.temperature = temperature;
    }

    public Map<String, Float> getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Map<String, Float> windSpeed) {
        this.windSpeed = windSpeed;
    }
}
