package com.RealTicketingSystem.Real.Ticketing.System;

import java.util.Objects;

public class Customer implements Runnable
{
    private String customer_name;
    private String customer_ID;
    private int customer_retrieval_rate;

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
        Main.ticket_pool.Remove_Ticket();
    }



    public void Customer_Details()
    {
        boolean iterative_condition = true;
        int total_customers = 1;

        while(iterative_condition)
        {
            String customer_name = Main.validation.Validate_name("  ■ Enter customer name : ");

            System.out.print("  ■ Enter customer ID   : ");
            String customer_ID = Main.input.nextLine();

            Customer customer = new Customer(customer_name, customer_ID);
            Main.customers_array.add(customer);

            System.out.println("""
                    \n  ------------------------------
                      | Customer Successfully Added. |
                      ------------------------------""");

            String continue_adding_customer = Main.validation.Validate_Iterative_Condition("""
                \n    Add another customer
                      - Yes (y)
                      - No  (n)
                """);

            if (Objects.equals(continue_adding_customer, "NO") || Objects.equals(continue_adding_customer, "N"))
            {
                System.out.println("""
                        \n  -------------------------------------
                          | All Customers Successfully Saved. |""");
                System.out.printf("  | Total Customers : %-16d|%n" , total_customers);
                System.out.println("  -------------------------------------\n");

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
                " | customer_retrieval_rate : " + customer_retrieval_rate +
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
    public int getCustomer_retrieval_rate()
    {
        return customer_retrieval_rate;
    }
}
