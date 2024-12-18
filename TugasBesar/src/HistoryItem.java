public class HistoryItem {
    private int id;
    private double inputValue;
    private String fromUnit;
    private double resultValue;
    private String toUnit;
    
    public HistoryItem(int id, double inputValue, String fromUnit, double resultValue, String toUnit) {
        this.id = id;
        this.inputValue = inputValue;
        this.fromUnit = fromUnit;
        this.resultValue = resultValue;
        this.toUnit = toUnit;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getInputValue() {
        return inputValue;
    }
    public void setInputValue(double inputValue) {
        this.inputValue = inputValue;
    }
    public String getFromUnit() {
        return fromUnit;
    }
    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }
    public double getResultValue() {
        return resultValue;
    }
    public void setResultValue(double resultValue) {
        this.resultValue = resultValue;
    }
    public String getToUnit() {
        return toUnit;
    }
    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }

}