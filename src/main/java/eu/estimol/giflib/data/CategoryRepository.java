package eu.estimol.giflib.data;

import eu.estimol.giflib.model.Category;

import java.util.ArrayList;

public class CategoryRepository {
    private ArrayList<Category> allCategories = new ArrayList<>();

    public CategoryRepository(){
        allCategories.add(new Category(1, "Technology"));
        allCategories.add(new Category(2, "People"));
        allCategories.add(new Category(3, "Destruction"));
    }

    public ArrayList<Category> getAllCategories() {
        return allCategories;
    }

    public void setAllCategories(ArrayList<Category> allCategories) {
        this.allCategories = allCategories;
    }

    public Category findById(int id){
        for(Category category: allCategories){
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }
}
