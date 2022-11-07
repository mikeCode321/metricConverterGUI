package convert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BaseUnits {
    public Double MULTIPLIER;

    public abstract String getName();

    public Double convertToStandardUnit(Double valueFromTextField){
        Double value = valueFromTextField * MULTIPLIER;
        BigDecimal bd = new BigDecimal(value).setScale(4, RoundingMode.HALF_UP);
        Double newValue = bd.doubleValue();
        return newValue;
        
    }

    public Double convertFromStandardUnit(Double value){
        
        Double computedValue = value / MULTIPLIER;
        BigDecimal bd = new BigDecimal(computedValue).setScale(4, RoundingMode.HALF_UP);
        Double newValue = bd.doubleValue();
        return newValue;
    }
}
