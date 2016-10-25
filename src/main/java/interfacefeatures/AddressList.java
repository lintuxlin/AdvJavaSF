package interfacefeatures;

class Person implements Addressable, Strange  {
	private String name;
	private String street;

	public Person(String name, String street) {
		super();
		this.name = name;
		this.street = street;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", street=" + street + "]";
	}
	
	@Override
	public String getAddressLabel() {
		return "specific label:\n" + Strange.super.getAddressLabel() + "\n" 
				+ Addressable.super.getAddressLabel();
	}
}

public class AddressList {

	public static void main(String[] args) {
		Addressable a = new Person("Fred", "123 Acacia Gardens");
		System.out.println("address of a is " + a.getAddressLabel());
	}

}
