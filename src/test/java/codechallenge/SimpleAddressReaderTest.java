package codechallenge;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SimpleAddressReaderTest {

	@Mock
	private Source source;

	private List<String[]> addressStore = new ArrayList<String[]>();

	private SimpleAddressReader simpleAddressReader;

	@Before
	public void setUp() {

		simpleAddressReader = new SimpleAddressReader(addressStore);

		List<String> addresses = new ArrayList<>();
		addresses.add("Winterallee 3");

		when(source.stream()).thenReturn(addresses.stream());
	}

	@Test
	public void testReader() {

		simpleAddressReader.read(source);

		assertEquals("Winterallee", addressStore.get(0)[0]);
		assertEquals("3", addressStore.get(0)[1]);
	}

}
