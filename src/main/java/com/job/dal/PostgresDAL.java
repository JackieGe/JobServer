package com.job.dal;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostgresDAL {

    public static void main(String[] args) {
        String connectionUri = "jdbc:postgresql://localhost:5433/test";
        String userName = "postgres";
        String password = "jackie";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        DataSource dataSource = setupDataSource(connectionUri, userName, password);

        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT \"Id\", \"Name\", \"Description\", \"Status\" FROM public.job";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String line = String.format("%d\t%s\t%s\t%s", resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
                System.out.println(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static DataSource setupDataSource(String connectionUri, String userName, String password) {

        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(connectionUri, userName, password);
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);

        ObjectPool<PoolableConnection> poolableConnectionObjectPool = new GenericObjectPool<>(poolableConnectionFactory);
        poolableConnectionFactory.setPool(poolableConnectionObjectPool);

        PoolingDataSource<PoolableConnection> poolingDataSource = new PoolingDataSource<>(poolableConnectionObjectPool);
        return poolingDataSource;
    }
}
