package br.com.danyswork.workshopandroidbasico;

public enum Components {

    TEXT_VIEW("Text View", TextViewFragment.getInstance()),
    SENSOR_ACCELEROMETER("Acelerômetro", SensorFragment.getInstance());

    private String name;
    private BaseFragment klass;

    Components(String name, BaseFragment fragment){
        this.name = name;
        this.klass = fragment;
    }

    public BaseFragment getKlass() {
        return klass;
    }

    public String getName() {
        return name;
    }
}
