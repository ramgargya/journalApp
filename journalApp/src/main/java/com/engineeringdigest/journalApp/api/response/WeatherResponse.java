package com.engineeringdigest.journalApp.api.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("location")
    private Location location;

    @JsonProperty("current")
    private Current current;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        @JsonProperty("name")
        private String name;

        @JsonProperty("region")
        private String region;

        @JsonProperty("country")
        private String country;

        @JsonProperty("lat")
        private double lat;

        @JsonProperty("lon")
        private double lon;

        @JsonProperty("tz_id")
        private String timezoneId;

        @JsonProperty("localtime_epoch")
        private int localtimeEpoch;

        @JsonProperty("localtime")
        private String localtime;

        @Override
        public String toString() {
            return "Location{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", country='" + country + '\'' +
                    ", timezoneId='" + timezoneId + '\'' +
                    '}';
        }
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {
        @JsonProperty("last_updated_epoch")
        private int lastUpdatedEpoch;

        @JsonProperty("last_updated")
        private String lastUpdated;

        @JsonProperty("temp_c")
        private double temperatureCelsius;

        @JsonProperty("temp_f")
        private double temperatureFahrenheit;

        @JsonProperty("is_day")
        private int isDay;

        @JsonProperty("condition")
        private Condition condition;

        @JsonProperty("wind_mph")
        private double windMph;

        @JsonProperty("wind_kph")
        private double windKph;

        @JsonProperty("wind_degree")
        private int windDegree;

        @JsonProperty("wind_dir")
        private String windDirection;

        @JsonProperty("pressure_mb")
        private int pressureMb;

        @JsonProperty("pressure_in")
        private double pressureIn;

        @JsonProperty("precip_mm")
        private int precipitationMm;

        @JsonProperty("precip_in")
        private int precipitationIn;

        @JsonProperty("humidity")
        private int humidity;

        @JsonProperty("cloud")
        private int cloud;

        @JsonProperty("feelslike_c")
        private double feelsLikeC;

        @JsonProperty("feelslike_f")
        private double feelsLikeF;

        @JsonProperty("windchill_c")
        private double windChillC;

        @JsonProperty("windchill_f")
        private double windChillF;

        @JsonProperty("heatindex_c")
        private double heatIndexC;

        @JsonProperty("heatindex_f")
        private double heatIndexF;

        @JsonProperty("dewpoint_c")
        private double dewPointC;

        @JsonProperty("dewpoint_f")
        private double dewPointF;

        @JsonProperty("vis_km")
        private int visibilityKm;

        @JsonProperty("vis_miles")
        private int visibilityMiles;

        @JsonProperty("uv")
        private int uv;

        @JsonProperty("gust_mph")
        private double gustMph;

        @JsonProperty("gust_kph")
        private double gustKph;

        @Override
        public String toString() {
            return "Current{" +
                    "temperatureCelsius=" + temperatureCelsius +
                    ", humidity=" + humidity +
                    ", windDirection='" + windDirection + '\'' +
                    ", condition=" + condition +
                    '}';
        }
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Condition {
        @JsonProperty("text")
        private String text;

        @JsonProperty("icon")
        private String icon;

        @JsonProperty("code")
        private int code;

        @Override
        public String toString() {
            return "Condition{" +
                    "text='" + text + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "location=" + location +
                ", current=" + current +
                '}';
    }
}

