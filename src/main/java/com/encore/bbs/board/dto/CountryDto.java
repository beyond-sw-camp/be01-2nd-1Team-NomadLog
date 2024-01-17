package com.encore.bbs.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CountryDto {
    private Long countryId;
    private String continentName;
    private String countryName;

    public CountryDto(String continentName, String countryName) {
        this.continentName = continentName;
        this.countryName = countryName;
    }
}