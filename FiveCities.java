import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FiveCities {

    /**the 5 city list to be sorted*/
    private List<WeatherForecast> cityList;

    private List<WeatherForecastItem> sortedTemp = new ArrayList<WeatherForecastItem>();
    private List<WeatherForecastItem> sortedWind = new ArrayList<WeatherForecastItem>();

    /**@param cityList contains 5 cities
     * the constructor authomatically sorts through the list
     * by wind speed and temperature*/
    public FiveCities(List<WeatherForecast> cityList) {

        this.cityList = cityList;
        sortTemperature();
        sortWind();
    }


    /**sorts each internal list from the 5 cities list by temperature*/
    private void sortTemperature() {
        for (int i = 0; i < cityList.size(); i++) {
            WeatherForecast weatherForecast = cityList.get(i);
            Comparator<WeatherForecastItem> compareTemps = (WeatherForecastItem w1, WeatherForecastItem w2)
            -> w1.getTemperature().get("temp").compareTo(w2.getTemperature().get("temp"));
            Collections.sort(weatherForecast.getItemList(), compareTemps);

        }
    }
    /**sorts each internal list from the 5 cities list by wind speed*/
    private void sortWind() {
        for (int i = 0; i < cityList.size(); i++) {
            WeatherForecast weatherForecast = cityList.get(i);
            Comparator<WeatherForecastItem> compareWind = (WeatherForecastItem w1, WeatherForecastItem w2)
                    -> w1.getWindSpeed().get("speed").compareTo(w2.getWindSpeed().get("speed"));
            Collections.sort(weatherForecast.getItemList(), compareWind);

        }
    }

    /**sorts the @param cityList by temperature
     * */
    public void sortMaxTemp() {
        List<WeatherForecast> cities = cityList;
        Comparator<WeatherForecast> compareTemp = (WeatherForecast w1, WeatherForecast w2)
                -> w1.getItemList().get(w1.getItemList().size()-1).getTemperature().get("temp").
                compareTo(w2.getItemList().get(w2.getItemList().size()-1).getTemperature().get("temp"));
        Collections.sort(cities, compareTemp);
        this.cityList=cities;
        System.out.println("\nSorted by max temperature:\n");
        display(cityList);
    }
    /**sorts the @param cityList by wind speed
     * */
    public void sortMaxWind() {
        List<WeatherForecast> cities = cityList;
        Comparator<WeatherForecast> compareWind = (WeatherForecast w1, WeatherForecast w2)
                -> w1.getItemList().get(w1.getItemList().size()-1).getWindSpeed().get("speed").
                compareTo(w2.getItemList().get(w2.getItemList().size()-1).getWindSpeed().get("speed"));
        Collections.sort(cities, compareWind);
        this.cityList=cities;
        System.out.println("\nSorted by max wind speed:\n");
        display(cityList);
    }
    /**prints the ranking of the cities according to the sort*/
    private void display(List<WeatherForecast> myList) {
        int j = myList.size()-1;
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("city # "+(i+1)+"-"+myList.get(j).getName()+" max temperature: "+myList.get(j).getItemList().get(myList.get(j).getItemList().size()-1).getTemperature().get("temp"));
            System.out.println("\t\t max wind speed: "+myList.get(j).getItemList().get(myList.get(j).getItemList().size()-1).getWindSpeed().get("speed"));
            j--;
        }
    }

}
