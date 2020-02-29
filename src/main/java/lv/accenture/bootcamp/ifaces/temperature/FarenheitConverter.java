package lv.accenture.bootcamp.ifaces.temperature;

public class FarenheitConverter implements TemperatureConverter {
    @Override
    public double convert(double cDegrees) {
        return cDegrees * 1.8 + 32;
    }
}
