package com.tieto.wro.java.a17.wunderground.client;

import com.tieto.wro.java.a17.wunderground.model.ErrorResponse;
import com.tieto.wro.java.a17.wunderground.model.IResponse;
import com.tieto.wro.java.a17.wunderground.model.MultipleResponse;
import com.tieto.wro.java.a17.wunderground.model.SingleResponse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by KR.
 */
public class WundergroundCLI {
    private static final String URL_API = "http://api.wunderground.com/api/31c81b32dea6da45/conditions";

    private static String makeURLFromMultipleChoices(MultipleResponse multipleResponse) throws Exception {
        return URL_API + getUniqueURI(multipleResponse) + ".xml";
    }

    private static WundergroundClient makeClientWithGivenCountryAndCity() throws MalformedURLException {
        return new WundergroundClient(new URL(URL_API+"/"));
    }

    private static String getUniqueURI(MultipleResponse multipleResponse) throws Exception {
        System.out.println("Multiple options, choose one or exit: ");
        List<MultipleResponse.Results.Result> arrayOfChoices = new ArrayList<>(multipleResponse.getResults().getResult());
        int i = 1;
        for (MultipleResponse.Results.Result e : arrayOfChoices) {
            System.out.println(i + ") " + e.getCity() + " in " + e.getState());
            i++;
        }
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice < 1 || choice > arrayOfChoices.size()) {
            in.close();
            throw new Exception( "Bad option!");
        }
        in.close();
        return arrayOfChoices.get(choice - 1).getL();
    }

    private static void handleErrorINFO(ErrorResponse errorResponse) {
        System.out.println("Type: " + errorResponse.getError().getType());
        System.out.println("Description: " + errorResponse.getError().getDescription());
    }
    private static void handleSingleINFO(SingleResponse singleResponse) {
        System.out.println(singleResponse.getCurrentObservation().getDisplayLocation().getFull());
        System.out.println("Temp in Celsius: " + singleResponse.getCurrentObservation().getTempC());
        System.out.println("Wind kph: " + singleResponse.getCurrentObservation().getWindKph());
    }

    private static void launchCLIWeatherApp(String country, String city) throws Exception {
        WundergroundClient weatherClient = makeClientWithGivenCountryAndCity();
        IResponse firstResponseOfWeatherAPI = weatherClient.getWeather(country, city);
        if (firstResponseOfWeatherAPI instanceof SingleResponse) {
            handleSingleINFO((SingleResponse) firstResponseOfWeatherAPI);
        }
        else if (firstResponseOfWeatherAPI instanceof ErrorResponse) {
            handleErrorINFO((ErrorResponse) firstResponseOfWeatherAPI);
        }
        else if (firstResponseOfWeatherAPI instanceof MultipleResponse){
            String uniqueURL = makeURLFromMultipleChoices((MultipleResponse) firstResponseOfWeatherAPI);
            handleSingleINFO(weatherClient.getSingleResponseFromMultipleChoices(uniqueURL));
        }
        else {
            throw new Exception("WE CAN NOT FIND THE TYPE OF RESPONSE");
        }
    }

    public static void main(String... args) {
        try {
            Scanner in = new Scanner(System.in);
            String country = in.nextLine();
            String city = in.nextLine();
            launchCLIWeatherApp(country, city);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
