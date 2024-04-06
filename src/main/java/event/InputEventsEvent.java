package event;

import model.ProductionData;
import utils.JsonReaderUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class InputEventsEvent implements Runnable {
    @Override
    public void run() {
        ProductionData productionData;
        try {
            productionData = JsonReaderUtils.getData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Введите условия построчно, для окончания ввода введите 'конец;': ");
        Scanner scanner = new Scanner(System.in);
        String condition = "";
        ArrayList<String> conditionList = new ArrayList<>();
        while (!Objects.equals(condition, "конец;")){
            conditionList.add(condition);
            condition = scanner.nextLine().trim().toLowerCase();
        }
        conditionList.remove("");

        productionData.getProductionList().forEach(
                production -> {
                    if(conditionList.containsAll(production.getConjunctionConditionList())
                    || conditionList.stream().anyMatch( c -> production.getDisjunctionConditionList().contains(c)))
                        production.setCounter(production.getCounter() + 1);
                }
        );

        try {
             JsonReaderUtils.saveData(productionData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
