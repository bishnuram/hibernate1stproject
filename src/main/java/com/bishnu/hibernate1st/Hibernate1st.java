/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.bishnu.hibernate1st;

import com.bishnu.User;
import com.config.hibernateutil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author user
 */
public class Hibernate1st {

    public static void main(String[] args) {
       SessionFactory factory= (SessionFactory) hibernateutil.getSessionFactory();
       Session session=factory.openSession();
       User user=session.get(User.class,"bishnu");
       System.out.println(user);
        
    }
}
