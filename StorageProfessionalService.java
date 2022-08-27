package ProffesionalService;

public class StorageProfessionalService {
	String name;
	String username;
	String service;
	String description;
	String town;
	Float prize;
	String building;
	String buildingNo;
	int Number_Of_Orders;
	int ItemNumber;
	
	public int getItemNumber() {
		return ItemNumber;
	}

	public void setItemNumber(int itemNumber) {
		ItemNumber = itemNumber;
	}

	public int getNumber_Of_Orders() {
		return Number_Of_Orders;
	}

	public void setNumber_Of_Orders(int number_Of_Orders) {
		Number_Of_Orders = number_Of_Orders;
	}

	public StorageProfessionalService() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public Float getPrize() {
		return prize;
	}

	public void setPrize(Float prize) {
		this.prize = prize;
	}

}
