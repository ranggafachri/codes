public class Converter extends AbstractConverter {
    @Override
    protected double convertValue(double value, String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "Meter":
                if (toUnit.equals("Kilometer")) return value / 1000;
                if (toUnit.equals("Centimeter")) return value * 100;
                break;
            case "Kilometer":
                if (toUnit.equals("Meter")) return value * 1000;
                if (toUnit.equals("Centimeter")) return value * 100000;
                break;
            case "Centimeter":
                if (toUnit.equals("Meter")) return value / 100;
                if (toUnit.equals("Kilometer")) return value / 100000;
                break;
            case "Gram":
                if (toUnit.equals("Miligram")) return value * 1000;
                if (toUnit.equals("Kilogram")) return value / 1000;
                break;
            case "Kilogram":
                if (toUnit.equals("Miligram")) return value * 1000000;
                if (toUnit.equals("Gram")) return value * 1000;
                break;
            case "Miligram":
                if (toUnit.equals("Gram")) return value / 1000;
                if (toUnit.equals("Kilogram")) return value / 1000000;
                break;
                case "Celcius":
                if (toUnit.equals("Reamur")) return value * 0.8;
                if (toUnit.equals("Fahrenheit")) return (value * 9/5) + 32;
                if (toUnit.equals("Kelvin")) return value + 273.15;
                break;
            case "Reamur":
                if (toUnit.equals("Celcius")) return value / 0.8;
                if (toUnit.equals("Fahrenheit")) return (value * 9/4) + 32;
                if (toUnit.equals("Kelvin")) return (value / 0.8) + 273.15;
                break;
            case "Fahrenheit":
                if (toUnit.equals("Celcius")) return (value - 32) * 5/9;
                if (toUnit.equals("Reamur")) return (value - 32) * 4/9;
                if (toUnit.equals("Kelvin")) return ((value - 32) * 5/9) + 273.15;
                break;
            case "Kelvin":
                if (toUnit.equals("Celcius")) return value - 273.15;
                if (toUnit.equals("Reamur")) return (value - 273.15) * 0.8;
                if (toUnit.equals("Fahrenheit")) return ((value - 273.15) * 9/5) + 32;
                break;
            case "Detik":
                if (toUnit.equals("Menit")) return value / 60;
                if (toUnit.equals("Jam")) return value / 3600;
                if (toUnit.equals("Hari")) return value / 86400;
                break;
            case "Menit":
                if (toUnit.equals("Detik")) return value * 60;
                if (toUnit.equals("Jam")) return value / 60;
                if (toUnit.equals("Hari")) return value / 1440;
                break;
            case "Jam":
                if (toUnit.equals("Detik")) return value * 3600;
                if (toUnit.equals("Menit")) return value * 60;
                if (toUnit.equals("Hari")) return value / 24;
                break;
            case "Hari":
                if (toUnit.equals("Detik")) return value * 86400;
                if (toUnit.equals("Menit")) return value * 1440;
                if (toUnit.equals("Jam")) return value * 24;
                break;
        }
        return value;
    }
}