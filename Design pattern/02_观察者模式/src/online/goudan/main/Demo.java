package online.goudan.main;

import online.goudan.internetweather.CurrentConditions;
import online.goudan.internetweather.WeatherData;


/**
 * @author chenglongliu
 */
public class Demo {
    public static void main(String[] args) {
        CurrentConditions mCurrentConditions = new CurrentConditions();
        WeatherData mWeatherData = new WeatherData();
        mWeatherData.setCurrentConditions(mCurrentConditions);
        mWeatherData.setData(10f, 23f, 34f);
    }
}
