package online.goudan.internetweather;

public class CurrentConditions {
    private float mTemperatrue;
    private float mPressure;
    private float mHumidity;

    public void update(float mTemperatrue, float mPressure, float mHumidity) {
        this.mTemperatrue = mTemperatrue;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();
    }

    public void display() {
        System.out.println("温度:" + mTemperatrue);
        System.out.println("气压:" + mPressure);
        System.out.println("湿度:" + mHumidity);
    }
}
