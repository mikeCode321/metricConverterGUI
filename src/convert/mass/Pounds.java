package convert.mass;

import convert.BaseUnits;

public class Pounds extends BaseUnits{

    public Pounds(){
        this.MULTIPLIER = 0.453592;
    }

    @Override
    public String getName() {
        return "Pounds";
    }
    
}
