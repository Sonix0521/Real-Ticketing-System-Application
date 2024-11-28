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
    static Validation validation = new Validation();
    static ArrayList<Vendor> vendors_array = new ArrayList<>();
    static ArrayList<Customer> customers_array = new ArrayList<>();

    public static void main(String[] args)
    {
        System.out.print("  | ********** | REAL-TIME TICKETING SYSTEM | ********** |\n\n");


        Configuration configuration = new Configuration();

        configuration.Initialize_Configuration_Settings();
        configuration.Save_Configuration();

        Configuration fetched_config_info = configuration.Read_Configuration();

        configuration.Display_Loaded_Configuration();

        ticket_pool = new TicketPool(fetched_config_info.getTotal_tickets(), fetched_config_info.getTicket_release_rate(), fetched_config_info.getCustomer_retrieval_rate(), fetched_config_info.getMax_ticket_capacity());

        Main.input.nextLine();

        vendor.Vendor_Details();

        customer.Customer_Details();


        for (Vendor v : vendors_array)
        {
            Thread vendor_thread = new Thread(v);
            vendor_thread.start();
        }

        for (Customer c : customers_array)
        {
            Thread vendor_thread = new Thread(c);
            vendor_thread.start();
        }

    }

}