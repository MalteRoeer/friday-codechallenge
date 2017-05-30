package codechallenge;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SpanishAddressReaderTest {

	@Mock
	private Source source;
	
	private AdvancedAddressReader addressReader;
	
	
	private RegexParsingStrategy parsingStrategy;
	
	private Parser parser;
	
	private List<String[]> addressStore = new ArrayList<String[]>();
	
	@Before
	public void setUp(){
		List<String> addresses = new ArrayList<>();
		
		addresses.add("Calle 39 No 1594");
		
		when(source.stream()).thenReturn(addresses.stream());
		
		parsingStrategy = new RegexParsingStrategy("(No)\\s{1}(\\d)*$");
		
		parser = new RegexParser(addressStore, parsingStrategy);
		
		addressReader = new AdvancedAddressReader();
		addressReader.registerParser(parser);
		
	}
	
	@Test
	public void testSpanishAdressReader(){
		
		addressReader.read(source);
		assertEquals("Calle 39", addressStore.get(0)[0]);
		assertEquals("No 1594", addressStore.get(0)[1]);
		assertEquals(1, addressStore.size());
		
	}
	
}
