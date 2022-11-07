package convert.volume;

import convert.BaseUnits;

public class Ounces extends BaseUnits{

    public Ounces(){
        this.MULTIPLIER = 0.0295735;
    }

    @Override
    public String getName() {
        return "Ounces";
    }
    
}
