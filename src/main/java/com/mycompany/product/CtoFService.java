/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product;

import com.mycompany.product.view.Product;
import com.mycompany.product.controller.add_products;
import com.mycompany.product.view.Comment;
import com.mycompany.product.view.ReportProduct;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getall() {
            add_products a = new add_products();
            return a.getall();
        }
        @Path("/get_products")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Product getproduct(@QueryParam("id") int id ) {
            add_products a = new add_products();
            return a.getproducts(id);
        }
        @Path("/add_products")
        @POST
        @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Product addproduct(Product product) { 
            add_products a = new add_products();
            a.addproducts(product);
            return product;
        }
        @Path("/del_products")
        @DELETE
	@Produces(MediaType.APPLICATION_XML)
	public String delproduct(@QueryParam("id") int id) { 
            add_products a = new add_products();
            return a.delproducts(id);
        }
        @Path("/edit_products/{id}")
        @PUT
	@Produces(MediaType.APPLICATION_XML)
	public String editproduct(Product product ,@PathParam("id") int id) { 
            add_products a = new add_products();
            return a.editproducts(product, id);
        }
        @Path("/report_products")
        @POST
	@Produces(MediaType.APPLICATION_XML)
	public String reportproduct(ReportProduct report) { 
            add_products a = new add_products();
            return a.reportproducts(report);
        }
        @Path("/report_products")
        @GET
	@Produces(MediaType.APPLICATION_XML)
	public List<ReportProduct> getallreport() { 
            add_products a = new add_products();
            return a.getallreport();
        }
        @Path("/comment")
        @POST
	@Produces(MediaType.APPLICATION_XML)
	public String comment(Comment comment) { 
            add_products a = new add_products();
            return a.comment(comment);
        }
        @Path("/comment/{id}")
        @GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Comment> getallcomment(@PathParam("id") int id) { 
            add_products a = new add_products();
            return a.getallcomment(id);
        }
	
}
