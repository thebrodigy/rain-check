# Rain Check ☔

A Spring Boot application that predicts whether you’ll need an umbrella based on weather forecasts from [WeatherAPI.com](https://www.weatherapi.com/).  
Uses **Spring Cloud OpenFeign** to fetch data, caches predictions in-memory, and exposes a REST API.

## Features
- Fetch weather forecast for a given location & date
- Predicts rain using `daily_will_it_rain`
- Returns daily chance of rain `daily_chance_of_rain`
- Caches predictions in-memory
- Lightweight, no database required
- Simple REST API interface

## Technologies
- Java 17+
- Spring Boot
- Spring Cloud OpenFeign
- Spring Cache (in-memory)
- WeatherAPI.com
- Maven

## Getting Started

### Prerequisites
- Java 17+
- Maven
- WeatherAPI.com API key

### Setup
1. Clone the repo:
```bash
git clone https://github.com/thebrodigy/rain-check.git
cd rain-check
```
2. Add your API key in `src/main/resources/application.properties`:
```properties
weather.api.key=YOUR_API_KEY
weather.api.url=http://api.weatherapi.com/v1/forecast.json
```
3. Build and run:
```bash
mvn clean spring-boot:run
```
App runs at `http://localhost:8080`.

## API Usage
**Endpoint:** `GET /api/predictions`

**Query Parameters:**

location: String = City name (e.g., Manila, Laguna) 

**Example Request:**
```bash
curl "http://localhost:8080/api/predictions?location=Manila"
```

**Example Response:**
```json
{
  "location": "Manila",
  "willRain": true,
  "chanceOfRain": "60"
}
```

## Caching
- Cached by `location`
- Subsequent requests served from cache
- No database needed

## Project StrucKture
```
src/main/java/com/yourname/umbrellapredictor/
├── client/        # Feign client
├── config/        # Config classes
├── controller/    # REST API controllers
├── dto/           # API response POJOs
├── service/       # Business logic + caching
└── RainCheckApplication.java
```

## Notes
- Supports forecast for 1 day (free tier)
- Uses `daily_will_it_rain` prediction
- Fully decoupled from WeatherAPI

## Future Improvements
- Multi-day forecasts
- Morning vs evening rain prediction
- Include detailed weather info (temp, humidity, icon)
- Unit & integration tests