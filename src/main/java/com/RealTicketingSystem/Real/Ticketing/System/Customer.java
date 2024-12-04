package com.RealTicketingSystem.Real.Ticketing.System;

import java.util.Objects;

public class Customer implements Runnable
{
    private String customer_name;
    private String customer_ID;


    public Customer(String customer_name, String customer_ID)
    {
        this.customer_name = customer_name;
        this.customer_ID = customer_ID;
    }
    public Customer()
    {

    }



    @Override
    public void run()
    {
        while (!Main.ticket_pool.Check_If_AllTicketsSoldOut())
        {
            try
            {
                Main.ticket_pool.Purchase_Ticket(this);
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



    public void Initialize_Customer_Details()
    {
        System.out.println("\n  Initialize customer details.\n");

        boolean iterative_condition = true;
        int total_customers = 1;

        while(iterative_condition)
        {
            String customer_name = Main.validation.Validate_name("\t ■ Enter customer name : ");

            System.out.print("\t ■ Enter customer ID   : ");
            String customer_ID = Main.input.nextLine();

            Customer customer = new Customer(customer_name, customer_ID);
            Main.customers_array.add(customer);

            System.out.println("\n\t\t ● Customer : " + customer_name + "-" + customer_ID + " | Successfully added.\n");

            String continue_adding_customer = Main.validation.Validate_AddUser_Iteration("""
                \t   Add another customer
                \t     - Yes (y)
                \t     - No  (n)
                """);

            if (Objects.equals(continue_adding_customer, "NO") || Objects.equals(continue_adding_customer, "N"))
            {
                System.out.println("\n\t   ● Total Customers : " + total_customers + " | All successfully added.\n");

                iterative_condition = false;
            }
            else
            {
                total_customers++;
                System.out.println();
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
