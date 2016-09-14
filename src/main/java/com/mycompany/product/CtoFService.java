/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product;

import com.mycompany.product.api.product;
import com.mycompany.product.controller.add_products;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nguye
 */
@Path("/api")
public class CtoFService {
    @Path("/get_products")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<product> convertCtoF() {
            add_products a = new add_products();
            
            return a.getAllproduct();
        }
 
	
}
