package com.wxy.ThreadLocal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by Cser_W on 2018/5/9.
 */
public class ProductServiceImpl implements ProductService {

    private static final String UPDATE_PRODUCT_SQL = "update product set price= ? where id = ?";
    private static final String INSERT_LOG_SQL = "insert into log(created, description) values (?,?)";

    public static void main(String[] args) {
       /* ProductServiceImpl productService = new ProductServiceImpl();
        productService.updateProductPrice(1,200);*/
        for (int i = 0; i < 10; i++) {
            ProductServiceImpl productService = new ProductServiceImpl();
            ClientThread thread = new ClientThread(productService);
            thread.start();
        }
    }

    @Override
    public void updateProductPrice(long productId, int price) {
        try {
            Connection connection = DBUtils.getConnection();
            connection.setAutoCommit(false);
            updateProduct(connection, UPDATE_PRODUCT_SQL, productId, price);
            insertLog(connection, INSERT_LOG_SQL, "create product");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection();
        }
    }

    private void insertLog(Connection connection, String insertLogSql, String s) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertLogSql);
            preparedStatement.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new java.util.Date()));
            preparedStatement.setString(2, s);
            int rows = preparedStatement.executeUpdate();
            if (rows != 0) {
                System.out.println("insert success!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void updateProduct(Connection connection, String updateProductSql, long productId, int price) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateProductSql);
            preparedStatement.setInt(1, price);
            preparedStatement.setLong(2, productId);
            int rows = preparedStatement.executeUpdate();
            if (rows != 0) {
                System.out.println("update success");
            } else {
                System.out.println("update failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
