package convert.time;

import convert.BaseUnits;

public class Seconds extends BaseUnits {

    public Seconds(){
        this.MULTIPLIER = 1.0;
    }

    @Override
    public String getName() {
        return "Seconds";
    }
    
}