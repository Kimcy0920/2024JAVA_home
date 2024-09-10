package sec05.exam06;

public class ShopService {
	private static ShopService sp = new ShopService();
	
	private ShopService() {}
	
	static ShopService getInstance() {
		return sp;
	}
}
