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
public class Category {
    @XmlElement
    int id;
    @XmlElement
    String name;
    @XmlElement
    String has_brand;
    @XmlElement
    String has_name;

    public Category() {
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

    public String getHas_brand() {
        return has_brand;
    }

    public void setHas_brand(String has_brand) {
        this.has_brand = has_brand;
    }

    public String getHas_name() {
        return has_name;
    }

    public void setHas_name(String has_name) {
        this.has_name = has_name;
    }
}
