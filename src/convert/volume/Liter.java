package convert.volume;

import convert.BaseUnits;

public class Liter extends BaseUnits{

    public Liter(){
        this.MULTIPLIER = 1.0;
    }

    @Override
    public String getName() {
        return "Liter";
    }
    
}
