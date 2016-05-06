package cn.edu.pku.sei.oo.neet.model;

import java.util.ArrayList;

import cn.edu.pku.sei.oo.neet.constants.RecipeConstant;

public class Recipe {
	public ArrayList<Material> layer;
	
	public Recipe() {
		layer = new ArrayList<Material>();
	}
	
	public boolean SetRecipe(int layer0, int layer1, int layer2, int layer3, int layer4, int layer5) {
		
		layer.add(RecipeConstant.recipeList.get(0).get(layer0));
		layer.add(RecipeConstant.recipeList.get(1).get(layer1));
		layer.add(RecipeConstant.recipeList.get(2).get(layer2));
		layer.add(RecipeConstant.recipeList.get(3).get(layer3));
		layer.add(RecipeConstant.recipeList.get(4).get(layer4));
		layer.add(RecipeConstant.recipeList.get(5).get(layer5));
		
		return true;
	}
}
