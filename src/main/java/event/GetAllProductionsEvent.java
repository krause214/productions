package event;

import model.ProductionData;
import utils.JsonReaderUtils;

import java.io.IOException;

public class GetAllProductionsEvent implements Runnable{
    @Override
    public void run() {
        try {
            ProductionData productionData = JsonReaderUtils.getData();
            System.out.println(productionData.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
