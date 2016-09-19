/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.controller;

import com.mycompany.product.model.ProductDAL;
import com.mycompany.product.view.Comment;
import com.mycompany.product.view.Product;
import com.mycompany.product.view.ReportProduct;
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
    public Product addproducts(Product product) {
		product_id.add_products(product);
		return product;
	}
    public String delproducts(int id) {
		
		return product_id.del_products(id);
	}
     public String editproducts(Product a,int id) {
		
		return product_id.edit_products(a, id);
	}
     public String reportproducts(ReportProduct report) {
		
		return product_id.report_products(report);
	}
     public List<ReportProduct> getallreport() {
		
		return product_id.get_all_repost();
	}
      public String comment(Comment comment) {
		
		return product_id.add_comment(comment);
	}
      public List<Comment> getallcomment() {
		
		return product_id.get_all_comment();
	}
//    public static void main(String[] args) {
//        add_products b = new add_products();
////        Product a = new Product();
////        a.setName("dsdssd");
////        a.setDescribed("snisands");
////        a.setPrice(0.0);
////        a.setPrice_new(0.0);
////        a.setPrice_percent(0.0);
//        ReportProduct report = new ReportProduct();
//        report.setProduct_id(3);
//        report.setSubject("sfsdf");
//        report.setDetails("dsfsd");
//        System.out.println(b.reportproducts(report));
//    }
}
