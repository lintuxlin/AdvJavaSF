package interfacefeatures;

public interface Addressable {
	String getName();
	String getStreet();
	
	default String getAddressLabel() {
		return getName() + "\n" + getStreet();
	}
}
