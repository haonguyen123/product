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
public class AddProductResponse {
    @XmlElement
   int code;
   @XmlElement
   String message;
   @XmlElement
   AddProduct data;

    public AddProductResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AddProduct getData() {
        return data;
    }

    public void setData(AddProduct data) {
        this.data = data;
    }
   
}
