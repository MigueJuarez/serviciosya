package com.capgemini.serviciosya.beans.domain;

/**
 *
 *  <p>The class <code>com.cagmeini.serviciosya.beans.domain.OccupationEntity<code/>
 *  is a domain object for management the occupations information.
 *
 *  @author Raul Pena (raul.pena@gmail.com)
 *  @version 1.0.0
 *  @since 1.8
 * */

public class OccupationEntity {
    // Private instances fields.

    // OccupationEntity id.
    private String id;

    // OccupationEntity name.
    private String name;

    // OccupationEntity description.
    private String description;


    // Constructor declarations.

    /**
     *
     *  <p>Constructor with arguments.
     *
     *  @param id Id occupation.
     *  @param name Name occupation.
     *  @param description Description occupation.
     * */
    public OccupationEntity(String id, String name, String description) {

        // Call to super class.
        super ();
        // Set internal values.
        this.id   = id;
        this.name = name;
        this.description = description;
    }

    public OccupationEntity() {
        id = "";
        name = "";
        description = "";
    }

    // Getters and Setters declarations.
    /**
     *
     *  <p>Return the occupation id.
     *
     *  @return Return the occupation id.
     * */
    public String getId () {
        return id;
    }

    /**
     *
     *  <p>Set the occupation id.
     *
     *  @param id Set the occupation id.
     * */
    public void setId (String id) {
        this.id = id;
    }
    /**
     *
     *  <p>Return the occupation name.
     *
     *  @return Return the occupation name.
     * */
    public String getName () {

        return name;
    }

    /**
     *
     *  <p>Se the occupation name.
     *
     *  @param name Set the occupation name.
     * */
    public void setName (String name) {

        this.name = name;
    }

    /**
     *
     *  <p>Return the occupation description.
     *
     *  @return Return the occupation description.
     * */
    public String getDescription () {

        return description;
    }

    /**
     *
     *  <p>Se the occupation description.
     *
     *  @param description Set the occupation description.
     * */
    public void setDescription (String description) {

        this.description = description;
    }

    public void setId(int id) {
        this.id = Integer.toString(id);
    }
}
