package event;

import model.Production;
import model.ProductionData;
import utils.JsonReaderUtils;

import java.io.IOException;
import java.util.*;

public class AddProductionEvent implements Runnable{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        ProductionData productionData;
        try {
            productionData = JsonReaderUtils.getData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Production production = new Production();
        System.out.print("Введите коньюнктивные условия через точку: ");
        production.setConjunctionConditionList(Arrays.asList(scanner.nextLine().split("\\.")));
        System.out.print("Введите дизъюнктивные условия через точку: ");
        production.setDisjunctionConditionList(Arrays.asList(scanner.nextLine().split("\\.")));
        System.out.print("Введите следствие: ");
        production.setConsequence(scanner.nextLine());
        production.setCounter(0);
        productionData.addProduction(production);
        try {
            JsonReaderUtils.saveData(productionData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
