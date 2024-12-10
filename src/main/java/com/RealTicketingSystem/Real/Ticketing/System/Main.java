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
    static TicketPool ticket_pool;
    static Validation validation = new Validation();
    static ArrayList<Vendor> vendors_array = new ArrayList<>();
    static ArrayList<Customer> customers_array = new ArrayList<>();
    static List<Ticket> ticket_pool_array = Collections.synchronizedList(new ArrayList<Ticket>());

    public static void main(String[] args)
    {

        System.out.println(ColorsUtil.CYAN + """
        --------------------------------------------------------
        | ********** | REAL-TIME TICKETING SYSTEM | ********** |
        --------------------------------------------------------
        """ + ColorsUtil.RESET);

        System.out.println(ColorsUtil.BLUE + "\n\t   INITIATING SYSTEM...\n" + ColorsUtil.RESET);

        configuration.Initialize_Configuration_Parameters();
        configuration.Save_Configuration_Parameters();

        Configuration fetched_config_info = configuration.Read_Configuration_Parameters();

        configuration.Display_Loaded_Configuration();

        ticket_pool = new TicketPool(fetched_config_info.getTotal_tickets(), fetched_config_info.getTicket_release_rate(), fetched_config_info.getCustomer_retrieval_rate(), fetched_config_info.getMax_ticket_capacity());

        System.out.println(ColorsUtil.GREEN + "\t   ● System Successfully Initialized\n" + ColorsUtil.RESET);

        System.out.println("  Initialize total vendors and customer.\n");

        int num_of_vendors = validation.Validate_TotalNumOf_CustomersAndVendors("\t ■ Total number of vendors   : ","vendors");
        int num_of_customers = validation.Validate_TotalNumOf_CustomersAndVendors("\t ■ Total number of customers : ","customers");

        Initialize_Total_CustomersAndVendors(num_of_vendors, num_of_customers);
        StartThreads();;

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

}