/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.controller;

import com.mycompany.product.api.product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class add_products {
    public List<product> getAllproduct() {
		product m1 = new product(1, "Ao ", "Ao so mi hoa", 123.5);
		product m2 = new product(2, "Quan bo", "Quan den",123.5);
                product m3 = new product(3, "Quan bo", "Quan den",123.5);
                product m4 = new product(4, "Quan bo", "Quan den",123.5);
                product m5 = new product(5, "Quan bo", "Quan den",123.5);
                
		List<product> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
                list.add(m3);
                list.add(m4);
                list.add(m5);
		return list;
	}

}
