package com.RealTicketingSystem.Real.Ticketing.System.Service;

import com.RealTicketingSystem.Real.Ticketing.System.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
@Service
public class TicketPoolService
{
    public static TicketPool ticket_pool;


    public void Start()
    {
        System.out.println("Ticket sales started");
    }

    public static void InitializeTicketPool(TicketPool obj )
    {
        ticket_pool = obj ;
        System.out.println(ticket_pool);
    }

    public int AvailableTickets()
    {
        return Main.ticket_pool_array.size();
    }

    public void Stop()
    {
        System.out.println("Ticket sales stopped.");
    }


}
