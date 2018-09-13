package com.capgemini.serviciosya.beans.domain.entity;


import javax.persistence.*;

@Entity(name = "Province")
@Table(name = "province")

public class ProvinceEntity {

        // Map the fields (Database tables ) and properties (Java classes)
        @Id
        @GeneratedValue (strategy=GenerationType.IDENTITY)
        @Column (name = "id", nullable = false, insertable = false, updatable = false)
        private int id;

        @Column (name = "name", length = 48, nullable = false)
        private String name;

        @ManyToOne
        @Column (length = 48, nullable = false)
        private CountryEntity country;

        public ProvinceEntity () {

            super ();
        }

        public int getId () {

            return id;
        }

        public void setId (int id) {

            this.id = id;
        }

        public String getName () {

            return name;
        }

        public void setName (String name) {

            this.name = name;
        }


        @Override
        public String toString () {

            return this.name;
       }



}
