# quotes

- Use the file recentquotes.json to show random popular book quotes. Your program should use GSON to parse the .json file. The app needs no functionality other than showing the quote and the author when it is run. The app should choose one quote each time it is run.

## Dependencies
Add Gson to build.gradle file:

dependencies {
  implementation 'com.google.code.gson:gson:2.8.5'
}

## content:
- it has 2 main classes:
- - Quotes class contains constructor,toString method , seeters and getters.
- - QuotesReader: it has readQuotes method to read json file and  getRandomQuote to pick a random quote.
