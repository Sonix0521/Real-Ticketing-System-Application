package com.RealTicketingSystem.Real.Ticketing.System;

import java.util.Objects;

public class Vendor implements Runnable
{
    private String vendor_name;
    private String vendor_ID;
    private int ticket_release_rate;



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
        Main.ticket_pool.Add_Ticket();
    }



    public void Vendor_Details()
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

            String continue_adding_vendor = Main.validation.Validate_Iterative_Condition("""
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
                " | ticket_release_rate : " + ticket_release_rate +
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
    public int getTicket_release_rate()
    {
        return ticket_release_rate;
    }

}
