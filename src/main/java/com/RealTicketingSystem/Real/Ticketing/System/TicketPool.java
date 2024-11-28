package com.RealTicketingSystem.Real.Ticketing.System;

import java.util.ArrayList;

public class TicketPool
{
    private int total_tickets;
    private int ticket_release_rate;
    private int customer_retrieval_rate;
    private int max_ticket_capacity;


    static ArrayList<Integer> ticket_pool_array = new ArrayList<Integer>();



    public TicketPool(int total_tickets, int ticket_release_rate, int customer_retrieval_rate, int max_ticket_capacity)
    {
        this.total_tickets = total_tickets;
        this.ticket_release_rate = ticket_release_rate;
        this.customer_retrieval_rate = customer_retrieval_rate;
        this.max_ticket_capacity = max_ticket_capacity;
    }


    public void Add_Ticket()
    {
        for ( int i = 0 ; i < total_tickets ; i++ )
        {
            ticket_pool_array.add(i);
        }
    }


    public void Remove_Ticket()
    {
        for ( int i = 0 ; i < total_tickets ; i++ )
        {
            ticket_pool_array.removeFirst();
        }
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
