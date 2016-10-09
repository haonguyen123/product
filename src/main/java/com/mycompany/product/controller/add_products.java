/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.controller;

import com.mycompany.product.model.ProductDAL;
import com.mycompany.product.view.AddProduct;
import com.mycompany.product.view.Comment;
import com.mycompany.product.view.Like;
import com.mycompany.product.view.Product;
import com.mycompany.product.view.ReportProduct;
import java.sql.Array;
import java.util.List;

/**
 *
 * @author nguye
 */
public class add_products {
    ProductDAL product_id = new ProductDAL();
    public List<Product> getall() {
        List<Product> list = product_id.get_all();
		return list;
	}
    public Product getproducts(int id) {
		Product product = product_id.get_products(id);
		return product;
	}
    public Like likeproducts(int id) {
		Like like = product_id.like_products(id);
		return like;
	}
    public AddProduct addproducts(String name, int price, int product_size_id, int brand_id,int seller_id, int category_id, String image, String described, String ships_from, String ships_from_id, String condition, String dimention, double weight) {
        AddProduct addproduct = product_id.add_products(name, price, product_size_id, brand_id, seller_id, category_id, image, described, ships_from, ships_from_id, condition, dimention, weight);
		return addproduct ;
	}
    public AddProduct delproducts(int id) {
		
		return product_id.del_products(id);
	}
     public AddProduct editproducts(String name, int price, int product_size_id, int brand_id,int seller_id, int category_id, String image, String described, String ships_from, String ships_from_id, String condition, String dimention, double weight,int id) {
		
		return product_id.edit_products(name, price, product_size_id, brand_id, seller_id, category_id, image, described, ships_from, ships_from_id, condition, dimention, weight, id);
	}
     public String reportproducts(int id, String subject, String details) {
		
		return product_id.report_products(id, subject, details);
	}
     public List<ReportProduct> getallreport() {
		
		return product_id.get_all_repost();
	}
      public List<Comment> comment(int id, String comment,int poster , int index, int count) {
		
		return product_id.set_comment_products(id, comment, poster, index, count);
	}
      public List<Comment> getallcomment(int id,int index,int count) {
		
		return product_id.get_comment_products(id, index, count);
	}
    public static void main(String[] args) {
        add_products b = new add_products();
//        Product a = new Product();
//        a.setName("dsdssd");
//        a.setDescribed("snisands");
//        a.setPrice(0.0);
//        a.setPrice_new(0.0);
//        a.setPrice_percent(0.0);
//        ReportProduct report = new ReportProduct();
//        report.setProduct_id(11);
//        report.setSubject("sfsdf");
//        report.setDetails("dsfsd");
        System.out.println( b.addproducts("ao", 12323, 1, 1, 1, 1, "1,2,3", "jkbjb", "bnn", "1,2,3", "czc", "czzxc", 12.9));
    }
}
