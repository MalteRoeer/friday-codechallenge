package codechallenge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleAddressReader implements AddressReader {

//	Simple program: No Exception handling, no validation
	
	
	private List<String[]> addressStore;
	
	public SimpleAddressReader(List<String[]> addressStore) {
		this.addressStore = addressStore;
	}
	
	
	@Override
	public void read(Source source) {		
		addressStore.addAll( source.stream().map(s -> s.split(" ")).collect(Collectors.toList()));		
	}


}
