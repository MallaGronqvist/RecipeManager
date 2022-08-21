package recipe;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class RandomCollection<Recipe> {
    private final NavigableMap<Integer, Recipe> map = new TreeMap<Integer, Recipe>();
    private final Random random;
    private int total = 0;

    public RandomCollection() {
        this(new Random());
    }

    public RandomCollection(Random random) {
        this.random = random;
    }

    public RandomCollection<Recipe> add(int weight, Recipe recipe) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, recipe);
        return this;
    }

    public Recipe next() {
        Integer value = random.nextInt() * total;
        return map.lowerEntry(value).getValue();
    }
}