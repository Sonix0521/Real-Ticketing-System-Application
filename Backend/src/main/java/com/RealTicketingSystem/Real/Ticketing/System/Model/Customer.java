package com.RealTicketingSystem.Real.Ticketing.System.Model;

import com.RealTicketingSystem.Real.Ticketing.System.Service.TicketPoolAppService;

public class Customer implements Runnable
{

    private String customer_name;
    private String customer_ID;


    /**
     *
     * @param customer_name
     * @param customer_ID
     */
    public Customer(String customer_name, String customer_ID)
    {
        this.customer_name = customer_name;
        this.customer_ID = customer_ID;
    }



    @Override
    public void run()
    {
        while (!TicketPoolAppService.ticket_pool.Check_If_AllTicketsSoldOut())
        {
            try
            {
                TicketPoolAppService.ticket_pool.Purchase_Ticket(this);
                Thread.sleep(100);
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
        return  "\tCustomer {" +
                " customer_name : " + customer_name +
                " | customer_ID : " + customer_ID +
                " }";
    }



    public String getCustomer_name()
    {
        return customer_name;
    }
    public String getCustomer_ID()
    {
        return customer_ID;
    }

}
