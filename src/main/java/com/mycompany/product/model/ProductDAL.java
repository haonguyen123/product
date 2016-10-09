/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.model;


import com.mycompany.product.view.AddProduct;
import com.mycompany.product.view.Brand;
import com.mycompany.product.view.Category;
import com.mycompany.product.view.Comment;
import com.mycompany.product.view.Condition;
import com.mycompany.product.view.Like;
import com.mycompany.product.view.Product;
import com.mycompany.product.view.ReportProduct;
import com.mycompany.product.view.Seller;
import com.mycompany.product.view.Size;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class ProductDAL extends connect {
    private final String MAX_ID="SELECT MAX(id) AS id FROM mydb.product";
    private final String GET_ID = "SELECT * FROM mydb.product pr JOIN mydb.size si on pr.size = si.id JOIN mydb.seller sl on sl.id=pr.seller JOIN mydb.brand br on br.id=pr.brand JOIN mydb.category ca on ca.id =pr.category WHERE pr.id = ?";
    private final String GET_ALL = "SELECT * FROM  mydb.product pr JOIN mydb.size si on pr.size = si.id JOIN mydb.seller sl on sl.id=pr.seller JOIN mydb.brand br on br.id=pr.brand JOIN mydb.category ca on ca.id =pr.category";
    private final String ADD_ID = "INSERT INTO product (name,price, described, ships_from, ships_from_id, product.condition, image, brand, seller, category, weight, dimention, size) VALUES (?, ?,?, ?,?,?,?,?,?,?,?,?,?)";
    private final String EDIT_ID = "UPDATE product SET name =?,price  =?, described  =?, ships_from  =?, ships_from_id  =?, product.condition  =?, image  =?, brand  =?, seller  =?, category =?, weight =?, dimention =?, size=? WHERE id = ? ";
    private final String DEL_ID = "DELETE FROM  product  WHERE id = ? ";
    private final String REPORT_PRODUCT = "INSERT INTO report_product (product_id,subject,details ) VALUES (?,?,?)";
    private final String GET_REPOST = "SELECT * FROM report_product";
    private final String COMMENT = "INSERT INTO comment (id_product ,comment ,poster_id , created ) VALUES (?,?,?,now())";
    private final String LIST_COMMENT = "SELECT cm.*, pr.name,pr.described,sl.seller_name,sl.avatar FROM  mydb.comment cm JOIN mydb.product pr on pr.id = cm.id_product JOIN mydb.seller sl on sl.id=cm.poster_id WHERE cm.id_product = ? LIMIT ? ,?  ";
    public ProductDAL() {
    }
    public List<Product> get_all() {
        List<Product> all = new ArrayList<Product>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM mydb.product");
            ResultSet rs = ps.executeQuery();
            if(rs!=null ){
                while( rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setPrice_percent(rs.getDouble("price_percent"));
                product.setDescribed(rs.getNString("described"));
                product.setShips_from(rs.getNString("ships_from"));
                product.setShips_from_id(rs.getNString("ships_from_id"));
                product.setCondition(rs.getNString("condition"));
                product.setCreated(rs.getDate("created"));
                product.setModified(rs.getDate("modified"));
                product.setLike(rs.getInt("like"));
                product.setComment(rs.getInt("comment"));
                product.setIs_liked(rs.getInt("is_liked"));
                product.setBest_offers(rs.getDouble("best_offers"));
                product.setImage(rs.getNString("image"));
                product.setState(rs.getInt("state"));
                product.setIs_blocked(rs.getInt("is_blocked"));
                product.setCan_edit(rs.getInt("can_edit"));
                product.setCan_buy(rs.getInt("can_buy"));
                product.setProduct_waiting_rate(rs.getInt("product_waiting_rate"));
                product.setSeller_vacation_mode(rs.getInt("seller_vacation_mode"));
                product.setOffers(rs.getDouble("offers"));
                product.setUrl(rs.getNString("url"));
                product.setWeight(rs.getDouble("weight"));
                product.setDimention("dimention");
                all.add(product);
                }
                
            }
            getClose();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return all;
    }
    public Product get_products(int id) {
        Product product = new Product();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!=null && rs.next()){
                Size size = new Size();
                Seller seller = new Seller();
                Brand brand = new Brand();
                Category category = new Category();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setPrice_percent(rs.getDouble("price_percent"));
                product.setDescribed(rs.getNString("described"));
                product.setShips_from(rs.getNString("ships_from"));
                product.setShips_from_id(rs.getNString("ships_from_id"));
                product.setCondition(rs.getNString("condition"));
                product.setCreated(rs.getDate("created"));
                product.setModified(rs.getDate("modified"));
                product.setLike(rs.getInt("like"));
                product.setComment(rs.getInt("comment"));
                product.setIs_liked(rs.getInt("is_liked"));
                product.setBest_offers(rs.getDouble("best_offers"));
                product.setImage(rs.getNString("image"));
                size.setId(rs.getInt("size"));
                size.setSize_name(rs.getNString("size_name"));
                product.setSize(size);
                brand.setId(rs.getInt("brand"));
                brand.setBrand_name(rs.getNString("brand_name"));
                product.setBrand(brand);
                seller.setId(rs.getInt("seller"));
                seller.setAvatar(rs.getNString("avatar"));
                seller.setListing(rs.getNString("listing"));
                seller.setName(rs.getNString("seller_name"));
                seller.setScore(rs.getInt("score"));
                product.setSeller(seller);
                category.setId(rs.getInt("category"));
                category.setHas_brand(rs.getNString("has_brand"));
                category.setHas_name(rs.getNString("has_name"));
                category.setName(rs.getNString("category_name"));
                product.setCategory(category);
                product.setState(rs.getInt("state"));
                product.setIs_blocked(rs.getInt("is_blocked"));
                product.setCan_edit(rs.getInt("can_edit"));
                product.setCan_buy(rs.getInt("can_buy"));
                product.setProduct_waiting_rate(rs.getInt("product_waiting_rate"));
                product.setSeller_vacation_mode(rs.getInt("seller_vacation_mode"));
                product.setOffers(rs.getDouble("offers"));
                product.setUrl(rs.getNString("url"));
                product.setWeight(rs.getDouble("weight"));
                product.setDimention("dimention");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return product;
    }
    public AddProduct  add_products(String name, int price, int product_size_id, int brand_id,int seller_id, int category_id, String image, String described, String ships_from, String ships_from_id, String condition, String dimention, double weight) {
        AddProduct addproduct = new AddProduct();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_ID);
            ps.setNString(1,name);
            ps.setInt(2,price);
            ps.setNString(3, described);
            ps.setNString(4, ships_from);
            ps.setNString(5,ships_from_id);
            ps.setNString(6,  condition);
            ps.setNString(7, image);
            ps.setInt(8, brand_id);
            ps.setInt(9, seller_id);
            ps.setInt(10, category_id);
            ps.setDouble(11, weight);
            ps.setNString(12, dimention);
            ps.setInt(13, product_size_id);
            int rs = ps.executeUpdate();
            if(rs > 0){
                PreparedStatement ps1 = con.prepareStatement(MAX_ID);
                ResultSet rs1 = ps1.executeQuery();
                if(rs1!=null && rs1.next()){
                addproduct.setId(rs1.getInt("id"));
                addproduct.setMessage("Add product sucessfull");
                addproduct.setUrl("http://localhost:8084/product/product/api/get_products/"+(rs1.getInt("id")));
            }
               
            }
            else {
                addproduct.setMessage("Add false");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return addproduct;
    }
    public AddProduct edit_products(String name, int price, int product_size_id, int brand_id,int seller_id, int category_id, String image, String described, String ships_from, String ships_from_id, String condition, String dimention, double weight,int id) {
        AddProduct addproduct = new AddProduct();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(EDIT_ID);
            ps.setNString(1,name);
            ps.setInt(2,price);
            ps.setNString(3, described);
            ps.setNString(4, ships_from);
            ps.setNString(5,ships_from_id);
            ps.setNString(6,  condition);
            ps.setNString(7, image);
            ps.setInt(8, brand_id);
            ps.setInt(9, seller_id);
            ps.setInt(10, category_id);
            ps.setDouble(11, weight);
            ps.setNString(12, dimention);
            ps.setInt(13, product_size_id);
            ps.setInt(14, id);
            int rs = ps.executeUpdate();
            if(rs > 0){
                addproduct.setId(id);
                addproduct.setMessage("Edit product sucessfull");
                addproduct.setUrl("http://localhost:8084/product/product/api/get_products/"+id); 
                
            }
            else {
                 addproduct.setMessage("Edit false");; 
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return addproduct;
    }
    public AddProduct del_products(int id) {
        AddProduct addproduct = new AddProduct();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(DEL_ID);
            ps.setInt(1,id);
            int rs = ps.executeUpdate();
            if(rs > 0){
                addproduct.setId(id);
                addproduct.setMessage("Delete product sucessfull");
            }
            else {
                 addproduct.setMessage("Delete product false");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return addproduct;
    }
    public List<ReportProduct> get_all_repost() {
        List<ReportProduct> all = new ArrayList<ReportProduct>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_REPOST);
            ResultSet rs = ps.executeQuery();
            if(rs!=null ){
                while( rs.next()){
                ReportProduct product = new ReportProduct();
                product.setProduct_id(rs.getInt("product_id"));
                product.setSubject(rs.getString("subject"));
                product.setDetails(rs.getString("details"));
                all.add(product);
                }
            }
            getClose();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return all;
    }
    public String report_products(int id, String subject, String details) {
        String message = "Repost product false";
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(REPORT_PRODUCT);
            ps.setInt(1,id);
            ps.setNString(2, subject);
            ps.setNString(3, details);
            int rs = ps.executeUpdate();
            if(rs > 0){
                message = "Repost product sucessfull";
            }
            else {
                 message ="Repost product false";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return message;
    }
    public List<Comment> set_comment_products(int id, String comment,int poster , int index, int count) {
        List<Comment> all = new ArrayList<Comment>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(COMMENT);
            ps.setInt(1, id);
            ps.setNString(2, comment);
            ps.setInt(3, poster);
            int rs = ps.executeUpdate();
            if(rs > 0){
            PreparedStatement ps1 = con.prepareStatement(LIST_COMMENT);
            ps1.setInt(1, id);
            ps1.setInt(2, index);
            ps1.setInt(3, count);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1!=null ){
                while( rs1.next()){
                Comment comment1 = new Comment();
                comment1.setId(rs1.getInt("id_comment"));
                comment1.setComment(rs1.getString("comment"));
                comment1.setCreated(rs1.getString("created"));
                comment1.setMessage("Set comment products sucessfull");
                Seller seller = new Seller();
                seller.setId(rs1.getInt("poster_id"));
                seller.setName(rs1.getString("seller_name"));
                seller.setAvatar(rs1.getString("avatar"));
                comment1.setPoster(seller);
                all.add(comment1);
                }
            }
            }
            else {
                Comment comment1 = new Comment();
                comment1.setMessage("Set comment products sucessfull");
                all.add(comment1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return all;
    }
    public List<Comment> get_comment_products(int id, int index,int count) {
        List<Comment> all = new ArrayList<Comment>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(LIST_COMMENT);
            ps.setInt(1, id);
            ps.setInt(2, index);
            ps.setInt(3, count);
            ResultSet rs = ps.executeQuery();
            if(rs!=null ){
                while( rs.next()){
                    
                Comment comment = new Comment();
                comment.setId(rs.getInt("id_comment"));
                comment.setComment(rs.getString("comment"));
                comment.setCreated(rs.getString("created"));
                comment.setMessage("Get comment product sucessfull");
                Seller seller = new Seller();
                seller.setId(rs.getInt("poster_id"));
                seller.setName(rs.getString("seller_name"));
                seller.setAvatar(rs.getString("avatar"));
                comment.setPoster(seller);
                all.add(comment);
                }
            }
            else{
                Comment comment = new Comment();
                comment.setMessage("Get comment product false");
                all.add(comment);
            }
            getClose();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return all;
    }
    public Like like_products(int id) {
        Like like = new Like();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!=null && rs.next()){
                like.setLike(rs.getInt("like"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return like;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       ProductDAL pro = new ProductDAL();
       //Product a = pro.get_products(3);
      List<Comment> comment = pro.get_comment_products(1, 0, 10);
        System.out.println(comment.get(1).getCreated() );
    }
}
