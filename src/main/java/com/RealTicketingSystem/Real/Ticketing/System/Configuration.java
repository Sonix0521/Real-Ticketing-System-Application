package com.RealTicketingSystem.Real.Ticketing.System;

import java.io.*;


public class Configuration
{
    private int total_tickets;
    private int ticket_release_rate;
    private int customer_retrieval_rate;
    private int max_ticket_capacity;



    public void Initialize_Configuration_Settings()
    {
        total_tickets = Main.validation.Validate_Configuration_Settings("\t ■ Enter total number of tickets : ");

        ticket_release_rate = Main.validation.Validate_Configuration_Settings("\t ■ Enter ticket release rate     : ");

        customer_retrieval_rate = Main.validation.Validate_Configuration_Settings("\t ■ Enter customer retrieval rate : ");

        max_ticket_capacity = Main.validation.Validate_Configuration_Settings("\t ■ Enter maximum ticket capacity : ");
    }



    public void Save_Configuration()
    {
        String json = Main.gson.toJson(this);

        try
        {
            FileWriter writer = new FileWriter("Configuration.json");
            writer.write(json);
            writer.close();

            System.out.println("\n\t   ● Configuration Successfully Saved.\n");
        }
        catch (IOException e)
        {
            System.out.println("\t ○ ERROR : Unable to save configuration.");
            throw new RuntimeException(e);
        }
    }



    public Configuration Read_Configuration()
    {
        try
        {
            FileReader reader = new FileReader("Configuration.json");

            System.out.println("\t   ● Configuration Successfully Loaded.\n");

            Configuration loaded_configuration = Main.gson.fromJson(reader, Configuration.class);

            this.total_tickets = loaded_configuration.getTotal_tickets();
            this.ticket_release_rate = loaded_configuration.getTicket_release_rate();
            this.customer_retrieval_rate = loaded_configuration.getCustomer_retrieval_rate();
            this.max_ticket_capacity = loaded_configuration.getMax_ticket_capacity();

            return loaded_configuration;
        }
        catch (IOException e)
        {
            System.out.println("\t\t ○ ERROR : Unable to load configuration.\n");
            throw new RuntimeException(e);
        }
    }



    public void Display_Loaded_Configuration()
    {
        System.out.printf("""
                \t %2s-----------------------------------
                \t %2s|     CONFIGURATION SETTINGS      |
                \t %2s-----------------------------------
                \t""","","","");

        System.out.printf(
                "   | Total number of tickets  = %-4d |%n\t   | Ticket release rate      = %-4d |%n\t   | Ticket retrieval rate    = %-4d |%n\t   | Maximum ticket capacity  = %-4d |%n",
                getTotal_tickets() ,
                getTicket_release_rate() ,
                getCustomer_retrieval_rate() ,
                getMax_ticket_capacity());
        System.out.println("\t   -----------------------------------\n");
    }



    @Override
    public String toString()
    {
        return "\tConfiguration {" +
                " total_tickets : " + total_tickets +
                " | ticket_release_rate : " + ticket_release_rate +
                " | customer_retrieval_rate : " + customer_retrieval_rate +
                " | max_ticket_capacity : " + max_ticket_capacity +
                " }";
    }

    public int getTotal_tickets()
    {
        return total_tickets;
    }
    public int getTicket_release_rate()
    {
        return ticket_release_rate;
    }
    public int getCustomer_retrieval_rate()
    {
        return customer_retrieval_rate;
    }
    public int getMax_ticket_capacity()
    {
        return max_ticket_capacity;
    }
}