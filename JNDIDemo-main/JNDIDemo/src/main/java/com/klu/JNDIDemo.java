package com.klu;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class JNDIDemo {
    public static void main(String[] args) {
        try {
            // Set up the JNDI properties
            Properties env = new Properties();
            
            // Specify the initial context factory based on your server
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  // Adjust port and URL accordingly
           

            // Create the InitialContext with the environment properties
            Context ctx = new InitialContext(env);

            // Perform the lookup (adjust the resource name to match your setup)
            String dbName = "myDatabase";
            Context dbCtx = (Context) ctx.lookup(dbName);

            // Print the database context
            System.out.println("Database Context: " + dbCtx);

        } catch (NamingException e) {
            System.out.println("JNDI Error: " + e.getMessage());
        }
    }
}
