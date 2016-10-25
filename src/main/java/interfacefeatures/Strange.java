package interfacefeatures;

public interface Strange {
	default String getAddressLabel() {
		return "Hello Mr. Strange";
	}
}
