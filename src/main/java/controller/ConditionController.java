package controller;

import event.AddProductionEvent;
import event.GetAllProductionsEvent;
import event.GetMostFrequentProductionEvent;
import event.InputEventsEvent;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ConditionController implements Runnable {
    private final static Map<Integer, Runnable> eventMap = Map.of(
            0, new Runnable() {
                @Override
                public void run() {
                    System.out.println("Конец работы программы!");
                    System.exit(1);
                }
            },
            1, new InputEventsEvent(),
            2, new AddProductionEvent(),
            3, new GetAllProductionsEvent(),
            4, new GetMostFrequentProductionEvent()
    );

    public static String getOptions(){
        return """
                ------------------------------------------------------------
                0. Завершить работу
                1. Ввести события
                2. Добавить продукцию
                3. Получить список всех продукций
                4. Получить продукцию с самым частым количеством исполнений
                ------------------------------------------------------------
                """;
    }
    private static void evaluateEvent(Integer eventNumber){
        Optional.ofNullable(eventMap.get(eventNumber)).orElse(eventMap.get(0)).run();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.print(getOptions());
        try{
            num = scanner.nextInt();
        } catch (Exception e){
            num = 0;
        }
        while (true){
            evaluateEvent(num);
            System.out.print(getOptions());
            try{
                num = scanner.nextInt();
            } catch (Exception e){
                num = 0;
            }
        }
    }
}
