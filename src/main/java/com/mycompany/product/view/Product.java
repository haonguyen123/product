/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.view;

import java.sql.Date;
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

    @XmlElement(name = "id")
    int id;
    @XmlElement(name = "name")
    String name;
    @XmlElement(name = "price")
    Double price;
    @XmlElement
    Size size;
    @XmlElement
    Brand brand;
    @XmlElement
    Category category;
    @XmlElement
    String image;
    @XmlElement(name = "described")
    String described;
    @XmlElement
    String ships_from;
    @XmlElement
    String ships_from_id;
    @XmlElement
    String condition;
    @XmlElement
    String dimention;
    @XmlElement
    Double weight;
    @XmlElement
    Double price_percent;
    @XmlElement
    Date created;
    @XmlElement
    Date modified;
    @XmlElement
    Integer like;
    @XmlElement
    Integer comment;
    @XmlElement
    Integer is_liked;
    @XmlElement
    Double best_offers;
    @XmlElement
    Integer state;
    @XmlElement
    Integer is_blocked;
    @XmlElement
    Integer can_edit;
    @XmlElement
    String banned;
    @XmlElement
    Integer can_buy;
    @XmlElement
    Integer product_waiting_rate;
    @XmlElement
    Integer seller_vacation_mode;
    @XmlElement
    Double offers;
    @XmlElement
    String url;
    @XmlElement
    Seller seller;

    public Product() {
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
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

    public String getShips_from() {
        return ships_from;
    }

    public void setShips_from(String ships_from) {
        this.ships_from = ships_from;
    }

    public String getShips_from_id() {
        return ships_from_id;
    }

    public void setShips_from_id(String ships_from_id) {
        this.ships_from_id = ships_from_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getIs_liked() {
        return is_liked;
    }

    public void setIs_liked(Integer is_liked) {
        this.is_liked = is_liked;
    }

    public Double getBest_offers() {
        return best_offers;
    }

    public void setBest_offers(Double best_offers) {
        this.best_offers = best_offers;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(Integer is_blocked) {
        this.is_blocked = is_blocked;
    }

    public Integer getCan_edit() {
        return can_edit;
    }

    public void setCan_edit(Integer can_edit) {
        this.can_edit = can_edit;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public Integer getCan_buy() {
        return can_buy;
    }

    public void setCan_buy(Integer can_buy) {
        this.can_buy = can_buy;
    }

    public Integer getProduct_waiting_rate() {
        return product_waiting_rate;
    }

    public void setProduct_waiting_rate(Integer product_waiting_rate) {
        this.product_waiting_rate = product_waiting_rate;
    }

    public Integer getSeller_vacation_mode() {
        return seller_vacation_mode;
    }

    public void setSeller_vacation_mode(Integer seller_vacation_mode) {
        this.seller_vacation_mode = seller_vacation_mode;
    }

    public Double getOffers() {
        return offers;
    }

    public void setOffers(Double offers) {
        this.offers = offers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
