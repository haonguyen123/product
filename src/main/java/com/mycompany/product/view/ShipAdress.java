/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.view;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@XmlRootElement
public class ShipAdress {
   @XmlElement
   int id;
   @XmlElement
   String name;
   @XmlElement
   String name_distric;
   @XmlElement
   String name_village;

    public String getName_distric() {
        return name_distric;
    }

    public void setName_distric(String name_distric) {
        this.name_distric = name_distric;
    }

    public String getName_village() {
        return name_village;
    }

    public void setName_village(String name_village) {
        this.name_village = name_village;
    }

    public ShipAdress() {
    }

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
}
