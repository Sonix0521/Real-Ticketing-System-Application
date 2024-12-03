package com.RealTicketingSystem.Real.Ticketing.System;

import com.google.gson.Gson;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    static Gson gson = new Gson();
    static Vendor vendor = new Vendor();
    static Customer customer = new Customer();
    static TicketPool ticket_pool;
    static Thread vendor_thread;
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

        vendors_array.add(new Vendor("James" , "01"));
        vendors_array.add(new Vendor("Luke" , "02"));
        vendors_array.add(new Vendor("Dan" , "04"));
        vendors_array.add(new Vendor("Sam" , "03"));
        vendors_array.add(new Vendor("Kim" , "05"));


        while (ticket_pool.getTotal_num_of_released_tickets() < ticket_pool.getTotal_tickets())
        {
            for (Vendor v : vendors_array)
            {
                if (ticket_pool.getTotal_num_of_released_tickets() == ticket_pool.getTotal_tickets())
                {
                    System.out.println("ALL AVAILABLE TICKETS ARE RELEASED.");
                    break;
                }
                vendor_thread = new Thread(v);
                vendor_thread.start();
            }
        }
    }

}