package online.goudan.internetweather;


public class WeatherData {

    private float mTemperatrue;
    private float mPressure;
    private float mHumidity;

    private CurrentConditions mCurrentConditions;

    public float getmTemperatrue() {
        return mTemperatrue;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }

    public void dataChange() {
        mCurrentConditions.update(mTemperatrue, mPressure, mHumidity);
    }

    public void setCurrentConditions(CurrentConditions mCurrentConditions) {
        this.mCurrentConditions = mCurrentConditions;
    }

    public void setData(float mTemperatrue, float mPressure, float mHumidity) {
        this.mTemperatrue = mTemperatrue;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        dataChange();
    }
}
