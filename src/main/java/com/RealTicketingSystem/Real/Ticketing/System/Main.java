package com.RealTicketingSystem.Real.Ticketing.System;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    static Gson gson = new Gson();
    static Configuration configuration = new Configuration();
    static Vendor vendor = new Vendor();
    static Customer customer = new Customer();
    static TicketPool ticket_pool;
    static Validation validation = new Validation();
    static ArrayList<Vendor> vendors_array = new ArrayList<>();
    static ArrayList<Customer> customers_array = new ArrayList<>();
    static List<Ticket> ticket_pool_array = Collections.synchronizedList(new ArrayList<Ticket>());
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args)
    {

        System.out.println(CYAN + """
        --------------------------------------------------------
        | ********** | REAL-TIME TICKETING SYSTEM | ********** |
        --------------------------------------------------------
        """ + RESET);

//        configuration.Initialize_Configuration_Parameters();
//        configuration.Save_Configuration_Parameters();

        Configuration fetched_config_info = configuration.Read_Configuration_Parameters();

        configuration.Display_Loaded_Configuration();

        ticket_pool = new TicketPool(fetched_config_info.getTotal_tickets(), fetched_config_info.getTicket_release_rate(), fetched_config_info.getCustomer_retrieval_rate(), fetched_config_info.getMax_ticket_capacity());

        Initialize_Total_CustomersAndVendors(4, 10);
        StartThreads();
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
        System.out.println(GREEN + "\n\t   ● Vendors : " + num_of_vendors + " & Customers : " + num_of_customers + " | Successfully added.\n" + RESET);

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

}