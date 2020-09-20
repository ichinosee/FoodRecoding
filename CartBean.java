package la.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CartBean {
	private Map<Integer, FoodBean> foods = new HashMap<Integer, FoodBean>();
	private int total;

	public CartBean() {

	}

	public Map<Integer, FoodBean> getItems(){
		return foods;
	}

	public void addCart(FoodBean bean, int nums) {
		FoodBean food = (FoodBean) foods.get(Integer.valueOf(bean.getCode()));
		if(food == null) {
			bean.setQuantity(nums);
			foods.put(Integer.valueOf(bean.getCode()), bean);
		}else {
			food.setQuantity(nums + food.getQuantity());
		}
		recalcTotal();
	}
	public void deleteCart(int foodCode) {
		foods.remove(Integer.valueOf(foodCode));
		recalcTotal();
	}

	public int getTotal() {
		return total;
	}

	private void recalcTotal() {
		total = 0;
		Collection<FoodBean> list = foods.values();
		for(FoodBean food : list) {
			total += food.getCalorie() * food.getQuantity();
		}
	}
}
