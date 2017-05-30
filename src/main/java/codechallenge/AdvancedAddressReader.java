package codechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AdvancedAddressReader implements AddressReader {

	private List<Parser> registeredParsers = new ArrayList<Parser>();

	@Override
	public void read(Source source) {

		source.stream().forEach(s -> applyParsers(s));
	}

	private void applyParsers(String line) {
		for (Parser parser : registeredParsers) {
			parser.doParsing(line);
		}
	}

	public void registerParser(Parser parser) {
		registeredParsers.add(parser);
	}

	public void unregisterParser(Parser parser) {
		registeredParsers.remove(parser);
	}

}
