package event;

import model.Production;
import model.ProductionData;
import utils.JsonReaderUtils;

import java.io.IOException;
import java.util.Comparator;

public class GetMostFrequentProductionEvent implements Runnable{
    @Override
    public void run() {
        try {
            ProductionData productionData = JsonReaderUtils.getData();
            productionData.getProductionList().sort(new Comparator<Production>() {
                @Override
                public int compare(Production a, Production b) {
                    return (b.getCounter() - a.getCounter());
                }
            });
            Production mostFreqProduction = productionData.getProductionList().get(0);
            System.out.println(mostFreqProduction.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
