/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product;

import com.mycompany.product.view.Product;
import com.mycompany.product.controller.add_products;
import com.mycompany.product.view.AddProduct;
import com.mycompany.product.view.Comment;
import com.mycompany.product.view.Like;
import com.mycompany.product.view.ReportProduct;
import java.sql.Array;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nguye
 */
@Path("/api")
public class CtoFService {
        @Path("/get_all_products")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getall() {
            add_products a = new add_products();
            return a.getall();
        }
        @Path("/get_products")
	@POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Product getproduct(@FormParam("id") int id ) {
            add_products a = new add_products();
            return a.getproducts(id);
        }
        @Path("/add_products")
        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public AddProduct addproduct(@FormParam("name") String name, @FormParam("price") int price,@FormParam("product_size_id") int product_size_id,@FormParam("brand_id") int brand_id,@FormParam("seller_id") int seller_id,@FormParam("category_id") int category_id,@FormParam("image") String image,@FormParam("described") String described,@FormParam("ships_from") String ships_from,@FormParam("ships_from_id") String ships_from_id,@FormParam("condition") String condition,@FormParam("dimention") String dimention,@FormParam("weight") double weight) { 
           
            add_products a = new add_products();
             AddProduct addproduct = a.addproducts(name, price, product_size_id, brand_id, seller_id, category_id, image, described, ships_from, ships_from_id, condition, dimention, weight);
            return addproduct;
        }
        @Path("/del_products")
        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public AddProduct delproduct( @FormParam("id") int id) { 
            add_products a = new add_products();
            return a.delproducts(id);
        }
        @Path("/edit_products")
        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public AddProduct editproduct(@FormParam("id") int id,@FormParam("name") String name, @FormParam("price") int price,@FormParam("product_size_id") int product_size_id,@FormParam("brand_id") int brand_id,@FormParam("seller_id") int seller_id,@FormParam("category_id") int category_id,@FormParam("image") String image,@FormParam("described") String described,@FormParam("ships_from") String ships_from,@FormParam("ships_from_id") String ships_from_id,@FormParam("condition") String condition,@FormParam("dimention") String dimention,@FormParam("weight") double weight ) { 
            add_products a = new add_products();
            return a.editproducts(name, price, product_size_id, brand_id, seller_id, category_id, image, described, ships_from, ships_from_id, condition, dimention, weight, id);
        }
        @Path("/report_products")
        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String reportproduct(@FormParam("product_id") int id,@FormParam("subject") String subject,@FormParam("details") String details) { 
            add_products a = new add_products();
            return a.reportproducts(id, subject, details);
        }
        @Path("/get_report_products")
        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReportProduct> getallreport() { 
            add_products a = new add_products();
            return a.getallreport();
        }
        @Path("/set_comment_products")
        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> comment(@FormParam("product_id") int id,@FormParam("comment") String comment,@FormParam("poster_id")int poster ,@FormParam("index") int index,@FormParam("count") int count) { 
            add_products a = new add_products();
            return a.comment(id, comment, poster, index, count);
        }
        @Path("/get_comment_products")
        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getallcomment(@FormParam("product_id") int id,@FormParam("index") int index,@FormParam("count") int count) { 
            add_products a = new add_products();
            return a.getallcomment(id, index, count);
        }
        @Path("/like_products")
        @POST
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Like getallcomment(@FormParam("id") int id) { 
            add_products a = new add_products();
            return a.likeproducts(id);
        }
//	
}
