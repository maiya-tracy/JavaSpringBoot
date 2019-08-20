package com.maiya.countries.models;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {

	@Id
	private int id;
	@Size(min=1)
    private String code;
    @Size(min=1)
    private String name;
    @Size(min=1)
    private String continent;
    @Size(min=1)
    private String region;
    @Size(min=1)
    private Float surface_area;
    @Size(min=1)
    private Short indep_year;
    @NotNull
    private Integer population;
    @NotNull
    private Float life_expectancy;
    @NotNull
    private Float gnp;
    @NotNull
    private Float gnp_old;
    @Size(min=1)
    private String local_name;
    @Size(min=1)
    private String government_form;
    @Size(min=1)
    private String head_of_state;
    @NotNull
    private Integer captial;
    @Size(min=1)
    private String code2;
	

}
