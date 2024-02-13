package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList> typeToDishes = new HashMap<>();
    Random random = new Random();

    public void addDish(String dishType, String dishName){
        System.out.println("Добавляем блюдо '" + dishName + "' в категорию '" + dishType + "'");
        dishType = dishType.toUpperCase();

        if (typeToDishes.containsKey(dishType)){
            ArrayList<String> dishes = typeToDishes.get(dishType);
            dishes.add(dishName);
            typeToDishes.put(dishType, dishes);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            typeToDishes.put(dishType, dishes);
        }
    }

    public ArrayList<ArrayList<String>> generateCombos(int count, List<String> comboStructure){
        ArrayList<ArrayList<String>> combos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ArrayList<String> currentCombo = new ArrayList<>();
            for (String dishType : comboStructure) {
                ArrayList<String> availableDishes = typeToDishes.get(dishType);
                int size = availableDishes.size();
                int position = random.nextInt(size);
                String randomDish = availableDishes.get(position);
                currentCombo.add(randomDish);
            }
            combos.add(currentCombo);
        }
        return combos;
    }
}
