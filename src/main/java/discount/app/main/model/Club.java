package discount.app.main.model;

public class Club {

	private String name;
	private String owner;
	private int itemsCount;

	public Club(String name, String owner, int itemsCount) {
		this.name = name;
		this.owner = owner;
		this.itemsCount = itemsCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String phone) {
		this.owner = phone;
	}

	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}
}