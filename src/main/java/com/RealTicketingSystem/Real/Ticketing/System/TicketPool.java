package com.RealTicketingSystem.Real.Ticketing.System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketPool
{
    private final int total_tickets;
    private final int ticket_release_rate;
    private final int customer_retrieval_rate;
    private final int max_ticket_capacity;
    private int total_num_of_released_tickets;
    private int total_num_of_purchased_tickets;
    private String ticket_ID;
    private boolean all_tickets_released = false;

    public TicketPool(int total_tickets, int ticket_release_rate, int customer_retrieval_rate, int max_ticket_capacity)
    {
        this.total_tickets = total_tickets;
        this.ticket_release_rate = ticket_release_rate;
        this.customer_retrieval_rate = customer_retrieval_rate;
        this.max_ticket_capacity = max_ticket_capacity;
    }


    public synchronized void Add_Ticket(Vendor vendor) throws InterruptedException
    {

        if ( total_num_of_released_tickets >= total_tickets && !all_tickets_released )
        {
            System.out.println("ALL TICKETS HAVE BEEN RELEASED BY VENDORS!!!");
            all_tickets_released = true;
            return;
        }

        if ( total_num_of_released_tickets >= total_tickets )
        {
            return;
        }

        int definite_num_of_tickets_to_be_release = Math.min(ticket_release_rate , total_tickets - total_num_of_released_tickets);

        for (int i = 1; i <= definite_num_of_tickets_to_be_release; i++ )
        {
            ticket_ID = vendor.getVendor_ID() + "-" + vendor.getVendor_name() + "-" + i;
            Ticket ticket = new Ticket(ticket_ID, vendor.getVendor_ID(), vendor.getVendor_name());
            Main.ticket_pool_array.add(ticket);
            total_num_of_released_tickets++;
        }
        System.out.println("\nVendor : " + vendor.getVendor_name() + vendor.getVendor_ID() + " released " + ticket_release_rate + " tickets. Tickets : " + ticket_ID);
        System.out.println("Total released tickets : " + total_num_of_released_tickets + " | Available tickets for purchase : " + Main.ticket_pool_array.size() + "\n");
        notifyAll();
        Thread.sleep(3000);
    }


    public synchronized void Purchase_Ticket(Customer customer) throws InterruptedException
    {
//        while (Main.ticket_pool_array.isEmpty())
//        {
//            System.out.println("No tickets available. Customer " + customer.getCustomer_name() + " is waiting......");
//            wait();
//            return;
//        }

        if(Main.ticket_pool_array.isEmpty()) return;

        int definite_num_of_tickets_to_be_purchased = (int) ( ( Math.random() * customer_retrieval_rate ) + 1);
        definite_num_of_tickets_to_be_purchased = Math.min(definite_num_of_tickets_to_be_purchased , Main.ticket_pool_array.size());

        for ( int i = 1 ; i <= definite_num_of_tickets_to_be_purchased ; i++ )
        {
            Main.ticket_pool_array.removeFirst();
            total_num_of_purchased_tickets++;
        }
        System.out.println("Customer : " + customer.getCustomer_name() + customer.getCustomer_ID() + " purchased " + definite_num_of_tickets_to_be_purchased + " tickets. | Available tickets for purchase : " + Main.ticket_pool_array.size() + " | Total purchased tickets : " + total_num_of_purchased_tickets);
        notifyAll();
        Thread.sleep(100);

        if (Check_If_AllTicketsSoldOut())
        {
            System.out.println("ALL AVAILABLE TICKETS ARE SOLD OUT!!!");
        }
    }

    public synchronized boolean Check_If_AllTicketsSoldOut()
    {
        return total_tickets == total_num_of_released_tickets && Main.ticket_pool_array.isEmpty();
    }


    @Override
    public String toString()
    {
        return " TicketPool {" +
                " total_tickets : " + total_tickets +
                " | ticket_release_rate : " + ticket_release_rate +
                " | customer_retrieval_rate : " + customer_retrieval_rate +
                " | max_ticket_capacity : " + max_ticket_capacity +
                " | total_num_of_released_tickets : " + total_num_of_released_tickets +
                " }";
    }
}