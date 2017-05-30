package codechallenge;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdvancedAddressReaderTest {

	@Mock
	private Source source;
	
	private AdvancedAddressReader addressReader;
	
	private RegexParsingStrategy parsingStrategy;
	
	private Parser parser;
	
	private List<String[]> addressStore = new ArrayList<String[]>();
	
	@Before
	public void setUp(){
		List<String> addresses = new ArrayList<>();
		addresses.add("Auf der Vogelwiese 23 b");
	
		addresses.add("fakefakefake");
		
		when(source.stream()).thenReturn(addresses.stream());
		
//		addressReader = new AdvancedAddressReader("(\\d+)(\\s*)([A-Za-z]*)$", "");		
		
		parsingStrategy = new RegexParsingStrategy("(\\d+)(\\s*)([A-Za-z]*)$");
		
		parser = new RegexParser(addressStore, parsingStrategy);
		
		addressReader = new AdvancedAddressReader();
		addressReader.registerParser(parser);
		
	}
	
	@Test
	public void testAdvancedAdressReader(){
		addressReader.read(source);
		assertEquals("Auf der Vogelwiese", addressStore.get(0)[0]);
		assertEquals("23 b", addressStore.get(0)[1]);
		assertEquals(1, addressStore.size());
		
	}
	
}
