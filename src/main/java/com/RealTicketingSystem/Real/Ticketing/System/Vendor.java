package com.RealTicketingSystem.Real.Ticketing.System;

import java.util.Objects;

public class Vendor implements Runnable
{
    private String vendor_name;
    private String vendor_ID;
    private int total_num_of_released_tickets;

    public Vendor(String vendor_name, String vendor_ID)
    {
        this.vendor_name = vendor_name;
        this.vendor_ID = vendor_ID;
    }
    public Vendor()
    {

    }



    @Override
    public void run()
    {
        while (!Main.ticket_pool.Check_If_AllTicketsSoldOut())
        {
            try
            {
                Main.ticket_pool.Add_Ticket(this);
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



    public void Enter_Vendor_Details()
    {
        boolean iterative_condition = true;
        int total_vendors = 1;

        while(iterative_condition)
        {
            String vendor_name = Main.validation.Validate_name("  ■ Enter vendor name : ");

            System.out.print("  ■ Enter vendor ID   : ");
            String vendor_ID = Main.input.nextLine();

            Vendor vendor = new Vendor(vendor_name, vendor_ID);
            Main.vendors_array.add(vendor);

            System.out.println("""
                    \n  ------------------------------
                      | Vendor Successfully Added. |
                      ------------------------------""");

            String continue_adding_vendor = Main.validation.Validate_AddUser_Iteration("""
                \n    Add another vendor
                      - Yes (y)
                      - No  (n)
                """);

            if (Objects.equals(continue_adding_vendor, "NO") || Objects.equals(continue_adding_vendor, "N"))
            {
                System.out.println("""
                        \n  -----------------------------------
                          | All Vendors Successfully Saved. |""");
                System.out.printf("  | Total Vendors : %-16d|%n" , total_vendors);
                System.out.println("  -----------------------------------\n");

                iterative_condition = false;
            }
            else
            {
                total_vendors++;
                System.out.println();
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

    public void setTotal_num_of_released_tickets(int total_num_of_released_tickets) {
        this.total_num_of_released_tickets = total_num_of_released_tickets;
    }
    public int getTotal_num_of_released_tickets() {
        return total_num_of_released_tickets;
    }

    public int getTotal_tickets()
    {
        return Main.ticket_pool.getTotal_tickets();
    }
}
