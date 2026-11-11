package fr.qadow.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TurnstileResponse {

    private boolean success;

    @JsonProperty("error-codes")
    private List<String> errorCodes;

    private String hostname;

    @JsonProperty("challenge_ts")
    private String challengeTs;

    private String action;

    private String cdata;
}