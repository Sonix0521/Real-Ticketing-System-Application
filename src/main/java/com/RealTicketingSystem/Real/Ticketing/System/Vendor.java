package com.RealTicketingSystem.Real.Ticketing.System;

import java.util.Objects;

public class Vendor implements Runnable
{

    private String vendor_name;
    private String vendor_ID;



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



    public void Initialize_Vendor_Details()
    {
        System.out.println("  Initialize vendor details.\n");

        boolean iterative_condition = true;
        int total_vendors = 1;

        Main.input.nextLine();

        while(iterative_condition)
        {
            String vendor_name = Main.validation.Validate_name("\t ■ Enter vendor name : ");

            System.out.print("\t ■ Enter vendor ID   : ");
            String vendor_ID = Main.input.nextLine();

            Vendor vendor = new Vendor(vendor_name, vendor_ID);
            Main.vendors_array.add(vendor);

            System.out.print(Main.GREEN + "\n\t\t ● Vendor : " + vendor_name + "-" + vendor_ID + " | Successfully Added.\n\n" + Main.RESET);

            String continue_adding_vendor = Main.validation.Validate_AddUser_Iteration("""
                \t   Add another vendor
                \t     - Yes (y)
                \t     - No  (n)
                """);

            if (Objects.equals(continue_adding_vendor, "NO") || Objects.equals(continue_adding_vendor, "N"))
            {
                System.out.println(Main.GREEN + "\n\t   ● Total vendors : " + total_vendors + " | All successfully added." + Main.RESET);
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

}
