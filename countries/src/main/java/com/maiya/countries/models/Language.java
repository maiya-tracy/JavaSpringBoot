package com.maiya.countries.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Language {
	@Size(min=1)
    private String country_code;
    @Size(min=1)
    private String language;
    @Size(min=1)
    private String is_official;
    @NotNull
    private Float percentage;
}
