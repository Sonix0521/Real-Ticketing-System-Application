package com.RealTicketingSystem.Real.Ticketing.System.Service;

import com.RealTicketingSystem.Real.Ticketing.System.Config.Configuration;
import com.RealTicketingSystem.Real.Ticketing.System.Model.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Service
public class TicketPoolAppService
{
    public static Scanner input = new Scanner(System.in);
    public static Gson gson = new Gson();
    public static Configuration configuration = new Configuration();
    public static TicketPool ticket_pool;
    public static VendorCustomerRequest vendor_Customer_request;
    public static Validation validation = new Validation();
    static ArrayList<Vendor> vendors_array = new ArrayList<>();
    static ArrayList<Customer> customers_array = new ArrayList<>();
    public static List<Ticket> ticket_pool_array = Collections.synchronizedList(new ArrayList<Ticket>());

    public static void RunSimulation()
    {
        System.out.println("HEllO");
//        StartThreads();
    }



    public static void Initialize_Total_CustomersAndVendors(int num_of_vendors, int num_of_customers)
    {
        for ( int i = 1 ; i <= num_of_vendors ; i++ )
        {
            String vendor_name = "Vendor " + i;
            String vendor_id = " #V-" + i + ".";
            vendors_array.add(new Vendor(vendor_name,vendor_id));
        }

        for ( int i = 1 ; i <= num_of_customers ; i++ )
        {
            String customer_name = "Customer " + i;
            String customer_id = " #C-" + i + ".";
            customers_array.add(new Customer(customer_name,customer_id));
        }
        System.out.println(ColorsUtil.GREEN + "\n\t   ● Vendors : " + num_of_vendors + " & Customers : " + num_of_customers + " | Successfully added.\n" + ColorsUtil.RESET);

    }



    public static void StartThreads()
    {
        Thread vendor_thread;
        Thread customer_thread;

        for (Vendor vendor : vendors_array)
        {
            vendor_thread = new Thread(vendor);
            vendor_thread.start();
        }

        for (Customer customer : customers_array)
        {
            customer_thread = new Thread(customer);
            customer_thread.start();
        }
    }

    public static void Initialize_TicketPool(TicketPool configuration_parameters) {
        // Create a new TicketPool using the values from the input object
        System.out.println(configuration_parameters.toString());
        ticket_pool = configuration_parameters;
        configuration.Save_Configuration_Parameters();
        System.out.println(ticket_pool);
    }

    public static void Initialize_CustomersAndVendors(VendorCustomerRequest num_of_vendors_and_customers)
    {
        vendor_Customer_request = num_of_vendors_and_customers;
        System.out.println(vendor_Customer_request);
    }


    public static int AvailableTickets()
    {
        return ticket_pool_array.size();
    }

    public static void StopSimulation()
    {
        System.out.println("Ticket sales stopped.");
    }


}
