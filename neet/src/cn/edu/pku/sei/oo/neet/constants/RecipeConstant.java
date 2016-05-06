package cn.edu.pku.sei.oo.neet.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.edu.pku.sei.oo.neet.model.Material;

public class RecipeConstant {
	
	public static int layerNum = 6;
	public static ArrayList<String> layerName = new ArrayList<String>(
			Arrays.asList("面包", "肉饼", "蔬菜", "芝士", "酱料", "其他"));
	public static ArrayList<ArrayList<Material>> recipeList = new ArrayList<ArrayList<Material>>() {{
		add(new ArrayList<Material>() {{
			add(new Material("松软面包", 1));
			add(new Material("白面包", 1));
			add(new Material("巨菜叶", 1));
		}});
		add(new ArrayList<Material>() {{
			add(new Material("牛肉", 1));
			add(new Material("鸡腿肉", 1));
			add(new Material("鳕鱼肉", 1));
			add(new Material("虾肉", 1));
		}});
		add(new ArrayList<Material>() {{
			add(new Material("生菜", 1));
			add(new Material("番茄", 1));
			add(new Material("辣椒圈", 1));
			add(new Material("洋葱", 1));
		}});
		add(new ArrayList<Material>() {{
			add(new Material("黄芝士", 1));
			add(new Material("白芝士", 1));
			add(new Material("芝士条", 1));
		}});
		add(new ArrayList<Material>() {{
			add(new Material("芥末酱", 1));
			add(new Material("蛋黄酱", 1));
			add(new Material("烧烤酱", 1));
			add(new Material("辣椒酱", 1));
			add(new Material("千岛酱", 1));
			add(new Material("番茄酱", 1));
		}});
		add(new ArrayList<Material>() {{
			add(new Material("培根", 1));
			add(new Material("牛油果泥", 1));
			add(new Material("玉米脆片", 1));
			add(new Material("香煎蘑菇", 1));
			add(new Material("煎蛋", 1));
		}});
	}};
	
	public static ArrayList<List<Integer>> recommendation = new ArrayList<List<Integer>>() {{
		add(Arrays.asList(0, 0, 0, 0, 0, 0));
		add(Arrays.asList(0, 1, 2, 1, 0, 1));
		add(Arrays.asList(2, 3, 3, 2, 5, 4));
		
	}};
}
