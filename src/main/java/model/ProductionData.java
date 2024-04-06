package model;

import lombok.Data;

import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Data
public class ProductionData {
    private ArrayList<Production> productionList;

    public void addProduction(Production production){
        try{
            production.setCounter(0);
            production.setConjunctionConditionList(
                    production.getConjunctionConditionList().stream()
                            .filter( s -> !s.isEmpty())
                            .map(this::prepareString)
                            .collect(Collectors.toList())
            );
            production.setDisjunctionConditionList(
                    production.getDisjunctionConditionList().stream()
                            .filter( s -> !s.isEmpty())
                            .map(this::prepareString)
                            .collect(Collectors.toList())
            );
            production.setConsequence(prepareString(production.getConsequence()));
            productionList.add(production);
        } catch (Exception e){
            e.printStackTrace();
            throw new WrongMethodTypeException(e.getMessage());
        }

    }
    private String prepareString(String value){
        return  value.toLowerCase().trim();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ProductionData{\n");
        for (Production prod :
                productionList) {
            result.append(prod.toString()).append("\n");
        }
        return result.append("}").toString();
    }
}
