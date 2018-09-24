package com.capgemini.serviciosya.beans.entity;

import javax.persistence.*;

@Entity (name = "Country") //COMUNICACION CON HIBERNATE PARA DECIRLE QUE ES UNA ENTIDAD DE UNA TABLA.
@Table (name = "country") //TOMAMOS LA CLASE CountryEntity COMO country.
public class CountryEntity { //CLASE DE DOMINIO PARA LA TABLA EN BASE DE DATOS

    //PROCESO DE MAPEO

    @Id //MAPEA EL CAMPO QUE SE IDENTIFICA COMO PRIMARYKEY

    //COMO DECIRLE A HIBERNATE QUIEN GENERA LA SECUENCIA DE ID
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "country_seq") //LE DIGO QUIEN GENERA LA SECUENCIA
    @SequenceGenerator(name = "country_seq",sequenceName = "country_seq") //GENERADOR DE LA SECUENCIA
    @Basic(optional = false)
    //IDENTIFICA LA COLUMNA ID EN LA TABLA, SI SE LLAMAN IGUAL NO HACE FALTA.
    @Column (name = "id",nullable = false,insertable = false,updatable = false)
    private Integer id;

    @Column (name = "name",length = 48,nullable = false) //CONFIGURACION DEL TAMAÑO Y SI ADMITE NULOS.
    private String name;

    //CONSTRUCTORES

    public CountryEntity() {
        super();
    }

    public CountryEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //GETS AND SETS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode () {

        int hash = 0;
        hash += ((this.id != null)? (this.id.hashCode ()) : 0);

        return hash;
    }

    @Override
    public boolean equals (Object object) {

        if (this == object)  {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (getClass () != object.getClass ()) {
            return false;
        }

        CountryEntity other = (CountryEntity) object;
        if (!this.id.equals (other.getId ())) {
            return false;
        }

        return true;
    }
}
