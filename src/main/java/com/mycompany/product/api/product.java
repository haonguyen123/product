/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@XmlRootElement(name = "product")
public class product {
//    @XmlElement
//    String token;
    @XmlElement(name="id" )
    int id;
    @XmlElement(name="name")
    String name;
    @XmlElement(name="price")
    Double price;
//    @XmlElement
//    Double price_new;
//    @XmlElement
//    Integer product_size_id;
//    @XmlElement
//    Integer brand_id;
//    @XmlElement
//    Integer category_id;
//    @XmlElement
//    List<String> image;
//    @XmlElement
//    String video;
//    @XmlElement
//    String thumb;
    @XmlElement(name="described")
    String described;
//    @XmlElement
//    String ships_from;
//    @XmlElement
//    List<String> ships_from_id;
//    @XmlElement
//    String condition;
//    @XmlElement
//    List<String> dimention;
//    @XmlElement
//    String weight;

    public product() {
    }

    public product(int id, String name, String described, Double price) {
        this.id = id;
        this.name = name;
        this.described = described;
        this.price= price;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    

//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public Double getPrice_new() {
//        return price_new;
//    }
//
//    public void setPrice_new(Double price_new) {
//        this.price_new = price_new;
//    }
//
//    public Integer getProduct_size_id() {
//        return product_size_id;
//    }
//
//    public void setProduct_size_id(Integer product_size_id) {
//        this.product_size_id = product_size_id;
//    }
//
//    public Integer getBrand_id() {
//        return brand_id;
//    }
//
//    public void setBrand_id(Integer brand_id) {
//        this.brand_id = brand_id;
//    }
//
//    public Integer getCategory_id() {
//        return category_id;
//    }
//
//    public void setCategory_id(Integer category_id) {
//        this.category_id = category_id;
//    }
//
//    public List<String> getImage() {
//        return image;
//    }
//
//    public void setImage(List<String> image) {
//        this.image = image;
//    }
//
//    public String getVideo() {
//        return video;
//    }
//
//    public void setVideo(String video) {
//        this.video = video;
//    }
//
//    public String getThumb() {
//        return thumb;
//    }
//
//    public void setThumb(String thumb) {
//        this.thumb = thumb;
//    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
    }

//    public String getShips_from() {
//        return ships_from;
//    }
//
//    public void setShips_from(String ships_from) {
//        this.ships_from = ships_from;
//    }
//
//    public List<String> getShips_from_id() {
//        return ships_from_id;
//    }
//
//    public void setShips_from_id(List<String> ships_from_id) {
//        this.ships_from_id = ships_from_id;
//    }
//
//    public String getCondition() {
//        return condition;
//    }
//
//    public void setCondition(String condition) {
//        this.condition = condition;
//    }
//
//    public List<String> getDimention() {
//        return dimention;
//    }
//
//    public void setDimention(List<String> dimention) {
//        this.dimention = dimention;
//    }
//
//    public String getWeight() {
//        return weight;
//    }
//
//    public void setWeight(String weight) {
//        this.weight = weight;
//    }
    
    
}
