package com.example.nasa.dtos.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class InSightResponseDto {

    @JsonProperty("sol_keys")
    private List<String> sol_keys;

    @JsonProperty("validity_checks")
    private ValidityChecks validity_checks;

    private Map<String, SolData> sols = new HashMap<>();

    @JsonAnySetter
    public void addSol(String key, Object value) {
        if (key.equals("sol_keys") || key.equals("validity_checks")) return;
        SolData sol = new ObjectMapper().convertValue(value, SolData.class);
        sols.put(key, sol);
    }

    @Getter
    @Setter
    @ToString
    public static class ValidityChecks {

        @JsonProperty("sol_hours_required")
        private Integer sol_hours_required;

        @JsonProperty("sols_checked")
        private List<String> sols_checked;

        private Map<String, SolChecks> sols = new HashMap<>();

        @JsonAnySetter
        public void addCheck(String key, Object value) {
            if (key.equals("sol_hours_required") || key.equals("sols_checked")) return;
            SolChecks checks = new ObjectMapper().convertValue(value, SolChecks.class);
            sols.put(key, checks);
        }
    }

    @Getter
    @Setter
    @ToString
    public static class SolChecks {

        @JsonProperty("AT")
        private CheckDetails AT;

        @JsonProperty("HWS")
        private CheckDetails HWS;

        @JsonProperty("PRE")
        private CheckDetails PRE;

        @JsonProperty("WD")
        private CheckDetails WD;
    }

    @Getter
    @Setter
    @ToString
    public static class SolData {

        @JsonProperty("AT")
        private WeatherData AT;

        @JsonProperty("HWS")
        private WeatherData HWS;

        @JsonProperty("PRE")
        private WeatherData PRE;

        @JsonProperty("WD")
        private Map<String, WindData> WD;

        @JsonProperty("First_UTC")
        private String First_UTC;

        @JsonProperty("Last_UTC")
        private String Last_UTC;

        @JsonProperty("Season")
        private String Season;

        @JsonProperty("Northern_season")
        private String Northern_season;

        @JsonProperty("Southern_season")
        private String Southern_season;

        @JsonProperty("Month_ordinal")
        private int Month_ordinal;
    }

    @Getter
    @Setter
    @ToString
    public static class WeatherData {
        private double av;
        private double mn;
        private double mx;
        private int ct;
    }

    @Getter
    @Setter
    @ToString
    public static class WindData {
        private double compass_degrees;
        private String compass_point;
        private double compass_right;
        private double compass_up;
        private int ct;
        private MostCommonWind most_common;
    }

    @Getter
    @Setter
    @ToString
    public static class MostCommonWind {
        private double compass_degrees;
        private String compass_point;
        private double compass_right;
        private double compass_up;
        private int ct;
    }

    @Getter
    @Setter
    @ToString
    public static class CheckDetails {
        private List<Integer> sol_hours_with_data;
        private boolean valid;
    }
}
