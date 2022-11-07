package convert.length;

import convert.BaseUnits;

public class Foot extends BaseUnits{

    public Foot(){
        this.MULTIPLIER = 0.3048;
    }
    
    @Override
    public String getName() {
        return "Foot";
    }
    
}
