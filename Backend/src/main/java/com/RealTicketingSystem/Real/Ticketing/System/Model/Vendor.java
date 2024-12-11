package com.RealTicketingSystem.Real.Ticketing.System.Model;

import com.RealTicketingSystem.Real.Ticketing.System.Service.TicketPoolAppService;

public class Vendor implements Runnable
{

    private String vendor_name;
    private String vendor_ID;



    public Vendor(String vendor_name, String vendor_ID)
    {
        this.vendor_name = vendor_name;
        this.vendor_ID = vendor_ID;
    }



    @Override
    public void run()
    {
        while (!TicketPoolAppService.ticket_pool.Check_If_AllTicketsSoldOut())
        {
            try
            {
                TicketPoolAppService.ticket_pool.Add_Ticket(this);
                Thread.sleep(2000);
            }
            catch (NullPointerException e)
            {
                System.out.println("Error : " + e);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }



    @Override
    public String toString()
    {
        return  "\tVendor {" +
                " vendor_name : " + vendor_name +
                " | vendor_ID : " + vendor_ID +
                " }";
    }



    public String getVendor_name()
    {
        return vendor_name;
    }
    public String getVendor_ID()
    {
        return vendor_ID;
    }

}
