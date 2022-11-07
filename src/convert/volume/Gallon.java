package convert.volume;

import convert.BaseUnits;

public class Gallon extends BaseUnits{

    public Gallon(){
        this.MULTIPLIER = 3.78541;
    }

    @Override
    public String getName() {
        return "Gallon";
    }
    
}
