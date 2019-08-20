package com.maiya.countries.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class City {
	@Size(min=1)
    private String name;
    @Size(min=1)
    private String country_code;
    @Size(min=1)
    private String district;
    @NotNull
    private Integer population;
}
