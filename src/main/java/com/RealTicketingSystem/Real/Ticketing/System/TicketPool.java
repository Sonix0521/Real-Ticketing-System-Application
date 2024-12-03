package com.RealTicketingSystem.Real.Ticketing.System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool
{
    private final int total_tickets;
    private final int ticket_release_rate;
    private final int customer_retrieval_rate;
    private final int max_ticket_capacity;
    private int total_num_of_released_tickets;
    private String ticket_ID;

    static List<Ticket> ticket_pool_array = Collections.synchronizedList(new ArrayList<Ticket>());


    public TicketPool(int total_tickets, int ticket_release_rate, int customer_retrieval_rate, int max_ticket_capacity)
    {
        this.total_tickets = total_tickets;
        this.ticket_release_rate = ticket_release_rate;
        this.customer_retrieval_rate = customer_retrieval_rate;
        this.max_ticket_capacity = max_ticket_capacity;
    }


    public synchronized void Add_Ticket(Vendor vendor) throws InterruptedException
    {
        if ( total_num_of_released_tickets < total_tickets )
        {
            for ( int i = 1 ; i <= ticket_release_rate ; i++ )
            {
                if ( total_num_of_released_tickets < total_tickets )
                {
                    vendor.setTotal_num_of_released_tickets(total_num_of_released_tickets);

                    ticket_ID = vendor.getVendor_ID() + "-" + vendor.getVendor_name() + "-" + i;
                    Ticket ticket = new Ticket(ticket_ID, vendor.getVendor_ID(), vendor.getVendor_name());
                    ticket_pool_array.add(ticket);
                    total_num_of_released_tickets++;
                    ThreadSleep();
                }
            }
            System.out.println("Vendor : " + vendor.getVendor_name() + vendor.getVendor_ID() + " released " + ticket_release_rate + " tickets. Tickets : " + ticket_ID);
            System.out.println("Total released tickets : " + total_num_of_released_tickets);
        }
    }


    public synchronized void Remove_Ticket()
    {
        for ( int i = 1 ; i <= total_tickets ; i++ )
        {
            if(!ticket_pool_array.isEmpty())
            {
                ticket_pool_array.removeFirst();
                System.out.println("");
            }
        }
    }


    public synchronized void ThreadSleep() throws InterruptedException
    {
        Thread.sleep(10);
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

    public synchronized int getTotal_tickets()
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
    public synchronized int getTotal_num_of_released_tickets()
    {
        return total_num_of_released_tickets;
    }
}
