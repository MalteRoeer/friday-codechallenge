package codechallenge;

import java.util.List;

public class RegexParser extends Parser {

	private RegexParsingStrategy parsingStrategy;

	public RegexParser(List<String[]> parsedLinesStore, RegexParsingStrategy parsingStrategy) {
		super(parsedLinesStore);
		this.parsingStrategy = parsingStrategy;
	}

	@Override
	public String[] parse(String line) throws RegexParsingException {
			return parsingStrategy.buildResultArray(line);
	}

}
