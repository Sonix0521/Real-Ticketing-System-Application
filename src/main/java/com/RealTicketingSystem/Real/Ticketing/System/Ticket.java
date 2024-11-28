package com.RealTicketingSystem.Real.Ticketing.System;

public class Ticket
{
    private String ticket_ID;
    private Vendor vendor_ID;
    private Vendor vendor_name;

    public Ticket(String ticket_ID, Vendor vendor_ID, Vendor vendor_name)
    {
        this.ticket_ID = ticket_ID;
        this.vendor_ID = vendor_ID;
        this.vendor_name = vendor_name;
    }

    public String getTicket_ID()
    {
        return ticket_ID;
    }
    public Vendor getVendor_ID()
    {
        return vendor_ID;
    }
    public Vendor getVendor_name()
    {
        return vendor_name;
    }
}
