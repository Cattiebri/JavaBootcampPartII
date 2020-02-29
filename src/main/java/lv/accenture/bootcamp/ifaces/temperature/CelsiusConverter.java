package lv.accenture.bootcamp.ifaces.temperature;

public class CelsiusConverter implements TemperatureConverter {
    @Override
    public double convert(double cDegrees) {
        return cDegrees;
    }
}
