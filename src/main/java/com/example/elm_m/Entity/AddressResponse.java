package com.example.elm_m.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressResponse {

    private String status;
    private String info;
    private Regeocode regeocode;

    @Data
    public static class Regeocode {
        private String formatted_address;
    }
}
