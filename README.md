# quotes

## Lab 08:

- Use the file recentquotes.json to show random popular book quotes. Your program should use GSON to parse the .json file. The app needs no functionality other than showing the quote and the author when it is run. The app should choose one quote each time it is run.

### Dependencies
Add Gson to build.gradle file:

dependencies {
  implementation 'com.google.code.gson:gson:2.8.5'
}

### content:
- it has 2 main classes:
- - Quotes class contains constructor,toString method , seeters and getters.
- - QuotesReader: it has readQuotes method to read json file and  getRandomQuote to pick a random quote.

## Lab09: (Web request)

![scanner](https://github.com/AyaaBe95/quotes/blob/main/Capture.PNG)

- Return data from the api and display it after the connection with internet and send a request to the api.
- Return a random quote from API: http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en

### content:
- getUrlQuote Method :create a connection between the user and server
- getBufferedReader Method :create input stream.
- write Method: write quotes that come from API inside local JSON file.
- getFileQuote Method: to read thq quotes.

