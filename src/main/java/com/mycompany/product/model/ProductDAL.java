/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.model;


import com.mycompany.product.view.Comment;
import com.mycompany.product.view.Condition;
import com.mycompany.product.view.Product;
import com.mycompany.product.view.ReportProduct;
import com.mycompany.product.view.Seller;
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
    private final String GET_ID = "SELECT * FROM product WHERE id = ?";
    private final String GET_ALL = "SELECT * FROM product";
    private final String GET_CONDITION_ID = "SELECT * FROM mydb.product, mydb.condition WHERE product.condition = condition.id AND product.id = ?";
    private final String ADD_ID = "INSERT INTO product (name,described ,price ,price_new , price_percent) VALUES (?,?,?,?,?)";
    private final String EDIT_ID = "UPDATE product SET name= ?,described =?,price =? ,price_new =? , price_percent =? WHERE id = ? ";
    private final String DEL_ID = "DELETE FROM  product  WHERE id = ? ";
    private final String REPORT_PRODUCT = "INSERT INTO report_product (product_id,subject,details ) VALUES (?,?,?)";
    private final String GET_REPOST = "SELECT * FROM report_product";
    private final String COMMENT = "INSERT INTO comment (id_product ,comment ,poster_id , created ) VALUES (?,?,?,now()";
    private final String LIST_COMMENT = "SELECT cm.*, pr.name,pr.described,sl.name_seller,sl.avatar FROM  mydb.comment cm JOIN mydb.product pr on pr.id = cm.id_product JOIN mydb.seller sl on sl.id=cm.poster_id WHERE cm.id_product = ? ";
    public ProductDAL() {
    }
    public List<Product> get_all() {
        List<Product> all = new ArrayList<Product>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null ){
                while( rs.next()){
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescribed(rs.getString("described"));
                product.setPrice(rs.getDouble("price"));
                product.setPrice_new(rs.getDouble("price_new"));
                product.setPrice_percent(rs.getDouble("price_percent"));
                Condition condition = new Condition();
                PreparedStatement ps1 = con.prepareStatement(GET_CONDITION_ID);
                ps1.setInt(1, rs.getInt("condition"));
                ResultSet rs1 = ps1.executeQuery();
                if(rs1!=null && rs1.next()){
                condition.setName(rs1.getString("name_condition"));
                condition.setDescribed(rs1.getString("described_condition"));
                
                        }
                product.setDimention(rs.getString("dimention"));
                product.setWeight(rs.getDouble("weight"));
                product.setCondition(condition);
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
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescribed(rs.getString("described"));
                product.setPrice(rs.getDouble("price"));
                product.setPrice_new(rs.getDouble("price_new"));
                product.setPrice_percent(rs.getDouble("price_percent"));
                Condition condition = new Condition();
                PreparedStatement ps1 = con.prepareStatement(GET_CONDITION_ID);
                ps1.setInt(1, id);
                ResultSet rs1 = ps1.executeQuery();
                if(rs1!=null && rs1.next()){
                condition.setName(rs1.getString("name_condition"));
                condition.setDescribed(rs1.getString("described_condition"));
                
                        }
                product.setDimention(rs.getString("dimention"));
                product.setWeight(rs.getDouble("weight"));
                product.setCondition(condition);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return product;
    }
    public Product add_products(Product product) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_ID);
            ps.setNString(1,product.getName() );
            ps.setNString(2,product.getDescribed());
            ps.setDouble(3, product.getPrice());
            ps.setDouble(4, product.getPrice_new());
            ps.setDouble(5, product.getPrice_percent());
            int rs = ps.executeUpdate();
            if(rs > 0){
                System.out.println("thanh conf");
            }
            else {
                System.out.println("LOI");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return product;
    }
    public String edit_products(Product product,int id) {
        String message = "Chưa thao tac";
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(EDIT_ID);
            ps.setNString(1,product.getName() );
            ps.setNString(2,product.getDescribed());
            ps.setDouble(3, product.getPrice());
            ps.setDouble(4, product.getPrice_new());
            ps.setDouble(5, product.getPrice_percent());
            ps.setInt(6, id);
            int rs = ps.executeUpdate();
            if(rs > 0){
               message = "update thành công!"; 
                
            }
            else {
                 message = "update lỗi!"; 
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return message;
    }
    public String del_products(int id) {
        String message = "Chưa xóa";
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(DEL_ID);
            ps.setInt(1,id);
            int rs = ps.executeUpdate();
            if(rs > 0){
                message = "Thanh cong";
            }
            else {
                 message ="LOI";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return message;
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
    public String report_products(ReportProduct report) {
        String message = "Chưa thêm";
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(REPORT_PRODUCT);
            ps.setInt(1,report.getProduct_id());
            ps.setNString(2, report.getSubject());
            ps.setNString(3, report.getDetails());
            int rs = ps.executeUpdate();
            if(rs > 0){
                message = "Thanh cong";
            }
            else {
                 message ="LOI";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return message;
    }
    public String add_comment(Comment comment) {
        String message = null;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_ID);
            ps.setInt(1,comment.getId_product());
            ps.setNString(2, comment.getComment());
            ps.setInt(3, comment.getPoster().getId());
            int rs = ps.executeUpdate();
            if(rs > 0){
                message = "Thành công";
            }
            else {
                message="Lỗi";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return message;
    }
    public List<Comment> get_all_comment(int id) {
        List<Comment> all = new ArrayList<Comment>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(LIST_COMMENT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!=null ){
                while( rs.next()){
                Comment comment = new Comment();
                comment.setId_comment(rs.getInt("id_comment"));
                comment.setId_product(rs.getInt("id_product"));
                comment.setComment(rs.getString("comment"));
                comment.setCreated(rs.getDate("created"));
                Seller seller = new Seller();
                seller.setId(rs.getInt("poster_id"));
                seller.setName(rs.getString("name_seller"));
                seller.setAvatar(rs.getString("avatar"));
                comment.setPoster(seller);
                all.add(comment);
                }
            }
            getClose();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return all;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       ProductDAL pro = new ProductDAL();
       //Product a = pro.get_products(3);
       Product a = new Product();
       a.setName("name");
       a.setDescribed("dsdfggvg");
       a.setPrice(0.0);
       a.setPrice_new(0.0);
       a.setPrice_percent(0.0);
        System.out.println(pro.edit_products(a, 10));
    }
}
