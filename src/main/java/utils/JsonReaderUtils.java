package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.ProductionData;

import java.io.File;
import java.io.IOException;

public class JsonReaderUtils {
    public static final File dataFile = new File("productionData.json");
    private static final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static ProductionData getData() throws IOException {
        return objectMapper.readValue(dataFile, ProductionData.class);
    }

    public static void saveData(ProductionData productionData) throws IOException {
        objectMapper.writeValue(dataFile, productionData);
    }

}
