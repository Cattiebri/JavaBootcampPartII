package lv.accenture.bootcamp.ifaces.temperature;

public class TemperatureLauncher {

    public static void main(String[] args) {
        TemperatureConverter celsiusConverter = new CelsiusConverter();
        TemperatureConverter farenheitConverter = new FarenheitConverter();
        TemperatureConverter kelvinConverter = new KelvinConverter();
        TemperatureConverter rankinConverter = new RankinConverter();
        System.out.println("Celsius degrees : " + celsiusConverter.convert(15));
        System.out.println("Farenheit degrees : " + farenheitConverter.convert(15));
        System.out.println("Kelvin degrees : " + kelvinConverter.convert(15));
        System.out.println("Rankin degrees : " + rankinConverter.convert(15));
    }

}
