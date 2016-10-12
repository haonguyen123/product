/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.view;

import java.sql.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@XmlRootElement
public class Comment {
    @XmlElement
    int id;
    @XmlElement
    String comment;
    @XmlElement
    String created;
    @XmlElement
    Seller poster;
    

   

    public Comment() {
    }

    
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Seller getPoster() {
        return poster;
    }

    public void setPoster(Seller poster) {
        this.poster = poster;
    }
    
}
