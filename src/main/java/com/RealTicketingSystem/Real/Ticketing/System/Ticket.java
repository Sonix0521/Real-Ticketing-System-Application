package com.RealTicketingSystem.Real.Ticketing.System;

public class Ticket
{
    private String ticket_ID;
    private String vendor_ID;
    private String vendor_name;

    public Ticket(String ticket_ID, String vendor_ID, String vendor_name)
    {
        this.ticket_ID = ticket_ID;
        this.vendor_ID = vendor_ID;
        this.vendor_name = vendor_name;
    }

    public String getTicket_ID()
    {
        return ticket_ID;
    }
    public String getVendor_ID()
    {
        return vendor_ID;
    }
    public String getVendor_name()
    {
        return vendor_name;
    }
}
