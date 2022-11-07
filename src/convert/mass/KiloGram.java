package convert.mass;

import convert.BaseUnits;

public class KiloGram extends BaseUnits {

    public KiloGram(){
        this.MULTIPLIER = 1.0;
    }

    @Override
    public String getName() {
        return "Kilogram";
    }
    
}