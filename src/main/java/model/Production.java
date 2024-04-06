package model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Production {
    private List<String> conjunctionConditionList = new ArrayList<>();
    private List<String> disjunctionConditionList = new ArrayList<>();
    private String consequence;
    private int counter;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\t Конъюнктивные условия: ");
        for (String conjunctionCondition:
                conjunctionConditionList) {
            stringBuilder.append(conjunctionCondition).append("; ");
        }
        stringBuilder.append("\n\t Дизюнктивные условия: ");
        for (String disjunctionCondition:
                disjunctionConditionList) {
            stringBuilder.append(disjunctionCondition).append("; ");
        }
        stringBuilder.append("\n\t Следствие: ").append(consequence);
        stringBuilder.append("\n\t Количество исполнений: ").append(counter);

        return "Продукция{ \n" + stringBuilder.toString() + " \n\t}";
    }
}
