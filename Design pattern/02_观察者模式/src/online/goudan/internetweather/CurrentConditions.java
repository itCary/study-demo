package online.goudan.internetweather;

/**
 * @author chenglongliu
 */
public class CurrentConditions {
    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    public void update(float mTemperature, float mPressure, float mHumidity) {
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();
    }

    public void display() {
        System.out.println("温度:" + mTemperature);
        System.out.println("气压:" + mPressure);
        System.out.println("湿度:" + mHumidity);
    }
}
