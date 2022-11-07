package convert.length;

import convert.BaseUnits;

public class Inch extends BaseUnits{

    public Inch(){
        this.MULTIPLIER = 0.0254;
    }
    
    @Override
    public String getName() {
        return "Inch";
    }
    
}
