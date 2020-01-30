/**@author Abdias Baldiviezo
 * A program that does API calls to get the weather of 5 cities and sorts them
 * by temperature and then by wind speed
 * uses the google Json deserializer to interact the the API reponses
 * also uses lambda functions to execute the sort*/
import com.google.gson.Gson;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        /*System.out.println("Enter the city you want the weather for: \n");
        String city = scanner.nextLine();
        WeatherConditions weatherConditions = apiCall(city);
        apiCallHourly(weatherConditions.getId());*/

        List<WeatherForecast> mylist=new ArrayList<WeatherForecast>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the city you want the weather for: \n");
            String city = scanner.nextLine();
            WeatherConditions weatherConditions = apiCall(city);
            WeatherForecast weatherForecast = apiCallHourly(weatherConditions.getId(),weatherConditions.getName());
            mylist.add(weatherForecast);
        }
        FiveCities fiveCities = new FiveCities(mylist);
        fiveCities.sortMaxTemp();
        fiveCities.sortMaxWind();

    }
    /**makes an API call that returns the temperature in a city that the user determines
     * @return a WeatherConditions object that has the results from the API call*/
    public static WeatherConditions apiCall(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather";
        String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
        String param1 = city;
        String param2 = "insert API key here";
        String param3 = "imperial";
        String query = "";
        //here we build the query for the request
        try {
            query = String.format("q=%s&apiKey=%s&units=%s",
                    URLEncoder.encode(param1, charset),
                    URLEncoder.encode(param2, charset),
                    URLEncoder.encode(param3, charset));
        }
        //encode requires for error handling
        catch (java.io.UnsupportedEncodingException e) {
            System.out.println(e);
        }
        // HTTP GET method
        String responseBody = "";
        try {
            //establish the connection with our complete URL
            URLConnection connection = new URL(url + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream();
            //response
            Scanner scanner = new Scanner(response);
            responseBody = scanner.useDelimiter("\\A").next();
            //System.out.println("This is the response" + responseBody);
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
        //CREATE a GSON to deserialize
        Gson gson = new Gson();
        WeatherConditions weatherConditions = gson.fromJson(responseBody, WeatherConditions.class);
        System.out.println(weatherConditions);
        return weatherConditions;
    }
    /**makes an API call for the forecast of a city
     * @return an WeatherForecast object with the results of the API call*/
    public static WeatherForecast apiCallHourly(int city, String cityname) {
        String url = "https://api.openweathermap.org/data/2.5/forecast";
        String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
        String param1 = Integer.toString(city);
        String param2 = "insert API key here";
        String param3 = "imperial";
        String query = "";
        //here we build the query for the request
        try {
            query = String.format("id=%s&apiKey=%s&units=%s",
                    URLEncoder.encode(param1, charset),
                    URLEncoder.encode(param2, charset),
                    URLEncoder.encode(param3, charset));
        }
        //encode requires for error handling
        catch (java.io.UnsupportedEncodingException e) {
            System.out.println(e);
        }
        // HTTP GET method
        String responseBody = "";
        try {
            //establish the connection with our complete URL
            URLConnection connection = new URL(url + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream();
            //response
            Scanner scanner = new Scanner(response);
            responseBody = scanner.useDelimiter("\\A").next();
            //System.out.println("This is the response" + responseBody);
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
        //CREATE a GSON to deserialize
        Gson gson = new Gson();
        WeatherForecast weatherForecast = gson.fromJson(responseBody, WeatherForecast.class);
        weatherForecast.setName(cityname);
        System.out.println(weatherForecast);
        return weatherForecast;
    }
}
