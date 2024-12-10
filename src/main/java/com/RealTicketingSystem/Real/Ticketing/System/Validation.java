package com.RealTicketingSystem.Real.Ticketing.System;

import java.util.InputMismatchException;

public class Validation
{

    /**
     * This method contains the Validations required for the initialization of configuration settings for the Configuration class.
     * @param configuration_statement passed in the prompt statement for the related configuration setting for the user to enter.
     * @return config_values.
     */
    protected int Validate_Configuration_Settings(String configuration_statement)
    {
        while (true)
        {
            System.out.print(configuration_statement);

            if (Main.input.hasNextInt())
            {
                int config_value = Main.input.nextInt();

                if (config_value > 0)
                {
                    return config_value;
                }
                else
                {
                    System.out.println("\n\t ○ Invalid Input. Please enter a positive value.\n");
                }
            }
            else if (Main.input.hasNextDouble())
            {
                System.out.println("\n\t ○ Invalid Input. Integer numerics are required.\n");
                Main.input.next();
            }
            else
            {
                System.out.println("\n\t ○ Invalid Input. Please enter a numerical value.\n");
                Main.input.next();
            }
        }
    }



    protected int Validate_TotalNumOf_CustomersAndVendors(String prompt_statement, String user_type)
    {
        while(true)
        {
            try
            {
                System.out.print(prompt_statement);
                int total_num_of_usertype = Main.input.nextInt();

                if(total_num_of_usertype > 0)
                {
                    return total_num_of_usertype;
                }
                else
                {
                    System.out.println(ColorsUtil.YELLOW + "\t\t ○ GUIDELINE : Number of " + user_type + " should at least be 01." + ColorsUtil.RESET);
                }
            }
            catch (InputMismatchException InvalidInputError)
            {
                System.out.println(ColorsUtil.RED + "\t\t ○ ERROR : Please enter a numerical value." + ColorsUtil.RESET);
                Main.input.nextLine();
            }
        }
    }



    protected String Validate_SystemInitiationMenuInputs()
    {
        while (true)
        {
            System.out.println("""
                  Welcome. Please Select an option to launch CLI
                \t   ---------------------------
                \t   | INITIATE SYSTEM = START |
                \t   | EXIT SYSTEM     = EXIT  |
                \t   ---------------------------""");

            System.out.print("  Enter selected option : ");
            String system_initiation_option = Main.input.nextLine();
            system_initiation_option = system_initiation_option.toUpperCase();

            if (system_initiation_option.equalsIgnoreCase("START") || system_initiation_option.equalsIgnoreCase("EXIT"))
            {
                return system_initiation_option;
            }
            else
            {
                System.out.println(ColorsUtil.RED + "\n\t\t ○ INVALID OPTION : Enter 'START' or 'EXIT'\n" + ColorsUtil.RESET);
            }
        }
    }


}
