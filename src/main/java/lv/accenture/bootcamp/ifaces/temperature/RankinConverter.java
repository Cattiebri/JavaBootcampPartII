package lv.accenture.bootcamp.ifaces.temperature;

public class RankinConverter extends FarenheitConverter {

    @Override
    public double convert(double cDegrees) {
        double farenheitDegrees = super.convert(cDegrees);
        return farenheitDegrees + 459.67;
    }
}
