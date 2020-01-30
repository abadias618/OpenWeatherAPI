import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherForecast {

    private String name;

    @SerializedName("list")
    private List<WeatherForecastItem> itemList;

    public List<WeatherForecastItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<WeatherForecastItem> itemList) {
        this.itemList = itemList;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**prints each element in the itemList with all it's fields */
    @Override
    public String toString() {
        String result="";
        int day=1;
        System.out.println(name+":\n");
        for (int i = 0; i < itemList.size(); i++) {
            result += "Day-> "+ day + " Date/Time: " + itemList.get(i).getDate() + " "
                    + "Temperature: " + itemList.get(i).getTemperature().get("temp") + " .F "
                    + "Description: " + itemList.get(i).getWeatherDescription().get(0).get("description") + " "
                    + "Wind Speed: " + itemList.get(i).getWindSpeed().get("speed") + " mph \n";
            if (i%8==0 && i!=0)day++;
        }
        return result;
    }
}
