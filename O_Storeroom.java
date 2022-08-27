package orderStoreroom;

public class O_Storeroom {
int item_No;
String Product_Name;
String Status;
String Notification;
String Client;
String intructions;
String contactNo;

public int getItem_No() {
	return item_No;
}
public void setItem_No(int item_No) {
	this.item_No = item_No;
}
public String getProduct_Name() {
	return Product_Name;
}
public void setProduct_Name(String product_Name) {
	Product_Name = product_Name;
}
public String getClient() {
	return Client;
}
public void setClient(String client) {
	Client = client;
}
public String getIntructions() {
	return intructions;
}
public void setIntructions(String intructions) {
	this.intructions = intructions;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getContact_Option() {
	return contact_Option;
}
public void setContact_Option(String contact_Option) {
	this.contact_Option = contact_Option;
}
String contact_Option;

	public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public String getNotification() {
	return Notification;
}
public void setNotification(String notification) {
	Notification = notification;
}
public O_Storeroom()
{}

}
