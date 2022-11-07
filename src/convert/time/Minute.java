package convert.time;

import convert.BaseUnits;

public class Minute extends BaseUnits {

    public Minute(){
        this.MULTIPLIER = 60.0;
    }

    @Override
    public String getName() {
        return "Minute";
    }
    
}