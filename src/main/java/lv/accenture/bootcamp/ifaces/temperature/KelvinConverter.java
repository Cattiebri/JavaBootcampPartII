package lv.accenture.bootcamp.ifaces.temperature;

public class KelvinConverter implements TemperatureConverter {
    @Override
    public double convert(double cDegrees) {
        return cDegrees + 273.15;
    }
}
