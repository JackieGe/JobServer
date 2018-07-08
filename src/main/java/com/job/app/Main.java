package com.job.app;

import java.util.EnumSet;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.job.HelloServlet;
import com.job.filter.CORSFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.DispatcherType;


public class Main {
    public static void main(String[] args) {
        Server server = new Server(8082);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        contextHandler.setContextPath("/");
        server.setHandler(contextHandler);


        ServletHolder holder = contextHandler.addServlet(ServletContainer.class, "/api/*");
        holder.setInitOrder(1);
        holder.setInitParameter("jersey.config.server.provider.packages", "com.job.res");
        contextHandler.addServlet(HelloServlet.class, "/api2");

//        holder = contextHandler.addServlet(HelloServlet.class, "");


        FilterHolder filterHolder = new FilterHolder(CORSFilter.class);
        contextHandler.addFilter(filterHolder, "/api/*", EnumSet.allOf(DispatcherType.class));

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            server.destroy();
        }
    }
}
