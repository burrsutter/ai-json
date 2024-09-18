package com.burrsutter;

import com.fasterxml.jackson.annotation.JsonCreator;

public record JSONResponse(String input, String output, int score) {
    @JsonCreator
    public JSONResponse {

    }
}
