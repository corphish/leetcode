import java.util.*;

// https://leetcode.com/problems/design-a-food-rating-system
class FoodRatings {
    
    Map<String, String> foodToCuisineMap = new HashMap<>();
    Map<String, TreeSet<Food>> cuisineToFoodSetMap = new HashMap<>();
    Map<String, Food> foodToModelMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], ratings[i]);
            foodToCuisineMap.put(foods[i], cuisines[i]);
            cuisineToFoodSetMap.computeIfAbsent(cuisines[i], x -> new TreeSet<>()).add(food);
            foodToModelMap.put(foods[i], food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisineMap.get(food);
        if (cuisine != null) {
            Food f = foodToModelMap.get(food);
            Food updated = new Food(food, newRating);
            Set<Food> set = cuisineToFoodSetMap.get(cuisine);
            set.remove(f);
            set.add(updated);
            foodToModelMap.put(food, updated);
        }
    }
    
    public String highestRated(String cuisine) {
        TreeSet<Food> set = cuisineToFoodSetMap.get(cuisine);
        Food food = set.first();
        return food.name;
    }
    
    class Food implements Comparable<Food> {
        String name;
        int rating;
        
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
        
        public int compareTo(Food other) {
            return this.rating == other.rating ? this.name.compareTo(other.name) : other.rating - this.rating;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */