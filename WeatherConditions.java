import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class WeatherConditions {
    private int id;
    private String name;
    @SerializedName("main")
    private Map<String , Float> measurements;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "WeatherConditions: " + '\n' +
                "id=" + id + '\n' +
                "City='" + name + '\'' + '\n' +
                "The temperature is : " + measurements.get("temp") + " degrees Fahrenheit.";
    }
}
