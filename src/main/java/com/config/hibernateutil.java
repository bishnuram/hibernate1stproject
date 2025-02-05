/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.config;


import com.bishnu.User;
import org.hibernate.cfg.Configuration;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author user
 */
public class hibernateutil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory==null)
        {
            Configuration configuration=new Configuration();
            Properties properties=new Properties();
            properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL,"jdbc:mysql://localhost:3306/superstore");
            properties.put(Environment.USER,"root");
            properties.put(Environment.PASS,"");
            properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
            properties.put(Environment.HBM2DDL_AUTO,"update");
            properties.put(Environment.SHOW_SQL,true);
            
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);
            
            ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
           sessionFactory=(SessionFactory) configuration.buildSessionFactory(serviceRegistry);
            
        }
        return sessionFactory;
    }
    
}
