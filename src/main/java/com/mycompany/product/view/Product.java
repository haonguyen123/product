/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.view;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@XmlRootElement(name = "product")
public class Product {
//    @XmlElement
//    String token;
    @XmlElement(name="id" )
    int id;
    @XmlElement(name="name")
    String name;
    @XmlElement(name="price")
    Double price;
    @XmlElement
    Double price_new;
    @XmlElement
    Size size;
    @XmlElement
    Brand brand;
    @XmlElement
    Category category;
    @XmlElement
    List<Image> image;
    @XmlElement
    Video video;
    @XmlElement
    String thumb;
    @XmlElement(name="described")
    String described;
    @XmlElement
    ShipAdress ships_from;
    @XmlElement
    List<ShipAdress> ships_from_id;
    @XmlElement
    Condition condition;
    @XmlElement
    String dimention;
    @XmlElement
    Double weight;
    @XmlElement
    Double price_percent;

    public Product() {
    }
    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getPrice_percent() {
        return price_percent;
    }

    public void setPrice_percent(Double price_percent) {
        this.price_percent = price_percent;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice_new() {
        return price_new;
    }

    public void setPrice_new(Double price_new) {
        this.price_new = price_new;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
    }

    public ShipAdress getShips_from() {
        return ships_from;
    }

    public void setShips_from(ShipAdress ships_from) {
        this.ships_from = ships_from;
    }

    public List<ShipAdress> getShips_from_id() {
        return ships_from_id;
    }

    public void setShips_from_id(List<ShipAdress> ships_from_id) {
        this.ships_from_id = ships_from_id;
    }

    public String getDimention() {
        return dimention;
    }

    public void setDimention(String dimention) {
        this.dimention = dimention;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }



}
