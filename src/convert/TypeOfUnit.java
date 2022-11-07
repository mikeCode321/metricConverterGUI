package convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TypeOfUnit {
    private String standardUnit;
    private Map<String, BaseUnits> mapOfBaseUnits = new HashMap<>();
    
    public Map<String, BaseUnits> getMapOfBaseUnits() {
        return mapOfBaseUnits;
    }
    
    public TypeOfUnit(String standardUnit, Map<String, BaseUnits> mapOfBaseUnits ){
        this.standardUnit = standardUnit;
        this.mapOfBaseUnits = mapOfBaseUnits;
    }

    public List<BaseUnits> getListOfBaseUnit(){
        List<BaseUnits> listOfBaseUnits = new ArrayList<>();
        listOfBaseUnits.addAll(mapOfBaseUnits.values());
        return listOfBaseUnits;
    }

    public abstract String getTypeOfUnit();


    public Double convert(Double value, BaseUnits from, BaseUnits to){
        if(from.getName().equals(to.getName())){
            return value;
        }else{
            Double numConvertedToStandardUnit = mapOfBaseUnits.get(from.getName()).convertToStandardUnit(value); 
            if(to.getName().equals(standardUnit)){
                return numConvertedToStandardUnit;
            }else{
                Double numConvertedFromStandardUnit = mapOfBaseUnits
                .get(to.getName()).convertFromStandardUnit(numConvertedToStandardUnit);
                return numConvertedFromStandardUnit;
            }   
        }
    }
}
