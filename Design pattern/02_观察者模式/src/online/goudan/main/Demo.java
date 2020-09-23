package online.goudan.main;

import com.sun.org.apache.regexp.internal.RE;
import online.goudan.internetweather.CurrentConditions;
import online.goudan.internetweather.WeatherData;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
      /*   CurrentConditions mCurrentConditions = new CurrentConditions();
        WeatherData mWeatherData = new WeatherData();
        mWeatherData.setCurrentConditions(mCurrentConditions);
        mWeatherData.setData(10f,23f,34f);*/


//        aa();

        try {
            Class<?> clazz = Class.forName("online.goudan.main.Person");
            Annotation[] annotations = clazz.getAnnotations();
            Arrays.stream(annotations).forEach(System.out::println);
            List<String> list = new ArrayList<>();
            list.add("aa");
            list.add("bb");
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void aa() {
        try {
            Class<?> clazz = Class.forName("online.goudan.main.Person");
            Constructor<?> co = clazz.getDeclaredConstructor();
            co.setAccessible(true);
            Person person = (Person) co.newInstance();

            Method speak = clazz.getDeclaredMethod("speak", String.class);
            speak.setAccessible(true);
            speak.invoke(person, "嗯哼");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
