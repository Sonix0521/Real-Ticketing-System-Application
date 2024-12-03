package com.RealTicketingSystem.Real.Ticketing.System;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    static Gson gson = new Gson();
    static Vendor vendor = new Vendor();
    static Customer customer = new Customer();
    static TicketPool ticket_pool;
    static Validation validation = new Validation();
    static ArrayList<Vendor> vendors_array = new ArrayList<>();
    static ArrayList<Customer> customers_array = new ArrayList<>();

    public static void main(String[] args)
    {
        System.out.print("  | ********** | REAL-TIME TICKETING SYSTEM | ********** |\n\n");


        Configuration configuration = new Configuration();

//        configuration.Initialize_Configuration_Settings();
//        configuration.Save_Configuration();

        Configuration fetched_config_info = configuration.Read_Configuration();

        configuration.Display_Loaded_Configuration();

        ticket_pool = new TicketPool(fetched_config_info.getTotal_tickets(), fetched_config_info.getTicket_release_rate(), fetched_config_info.getCustomer_retrieval_rate(), fetched_config_info.getMax_ticket_capacity());


//        vendor.Enter_Vendor_Details();
//        customer.Customer_Details();

        vendors_array.add(new Vendor("James" , "v01"));
        vendors_array.add(new Vendor("Luke" , "v02"));
        vendors_array.add(new Vendor("Dan" , "v04"));

        customers_array.add(new Customer("Ben" , "c01"));
        customers_array.add(new Customer("Olivia" , "c02"));
        customers_array.add(new Customer("Marcus" , "c03"));
        customers_array.add(new Customer("Liam" , "c04"));
        customers_array.add(new Customer("John" , "c05"));
        customers_array.add(new Customer("James" , "c06"));
        customers_array.add(new Customer("William" , "c07"));
        customers_array.add(new Customer("Jacob" , "c08"));
        customers_array.add(new Customer("Olivia" , "c09"));
        customers_array.add(new Customer("Harper" , "c10"));
        customers_array.add(new Customer("Ian" , "c11"));
        customers_array.add(new Customer("Kevin" , "c12"));
        customers_array.add(new Customer("Mark" , "c13"));
        customers_array.add(new Customer("Daniel" , "c14"));
        customers_array.add(new Customer("Jeo" , "c15"));


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