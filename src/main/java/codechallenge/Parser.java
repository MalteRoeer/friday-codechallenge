package codechallenge;

import java.util.List;

public abstract class Parser {

	private List<String[]> parsedLinesStore;

	public Parser(List<String[]> parsedLinesStore) {
		this.parsedLinesStore = parsedLinesStore;
	}

	public void doParsing(String line) {
		String[] parsedLine;
		try {
			parsedLine = parse(line);
		} catch (RegexParsingException e) {
			// do nothing
			return;
		}

		synchronized (this) {
			parsedLinesStore.add(parsedLine);
		}
	}

	public abstract String[] parse(String line) throws RegexParsingException;

}
