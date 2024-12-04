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
                    if (configuration_statement.equalsIgnoreCase("\t ■ Enter maximum ticket capacity : ") && config_value < Main.configuration.getTotal_tickets() )
                    {
                        System.out.println("\t\t ○ GUIDELINE : Total tickets should not exceed maximum ticket capacity.");
                        Main.input.nextLine();
                        continue;
                    }
                    if ( configuration_statement.equalsIgnoreCase("\t ■ Enter ticket release rate     : ") && config_value > Main.configuration.getTotal_tickets()/2 )
                    {
                        System.out.println("\t\t ○ GUIDELINE : Vendor release rate must be at least 50% less than total tickets.");
                        Main.input.nextLine();
                        continue;
                    }
                    if ( configuration_statement.equalsIgnoreCase("\t ■ Enter customer retrieval rate : ") && config_value > Main.configuration.getTotal_tickets()/2 )
                    {
                        System.out.println("\t\t ○ GUIDELINE : Customer retrieval rate must be at least 50% less than total tickets.");
                        Main.input.nextLine();
                        continue;
                    }
                    return config_value;
                }
                else
                {
                    System.out.println("\t\t ○ INVALID INPUT : Please enter a positive value.");
                }
            }
            else if (Main.input.hasNextDouble())
            {
                System.out.println("\t\t ○ INVALID INPUT : Integer numerics are required.");
                Main.input.next();
            }
            else
            {
                System.out.println("\t\t ○ INVALID INPUT : Please enter a numerical value.");
                Main.input.next();
            }
        }
    }



    protected String Validate_name(String prompt_enter_name_statement)
    {
        while (true)
        {
            System.out.print(prompt_enter_name_statement);

            String name = Main.input.nextLine();

            if(name.matches("^[a-zA-Z ]+$"))
            {
                return name;
            }
            else
            {
                System.out.println("\t\t ○ INVALID INPUT : Non-alphabetical characters aren't allowed for name.");
            }
        }
    }



    protected String Validate_AddUser_Iteration(String prompt_iteration_statement)
    {
        System.out.print(prompt_iteration_statement);

        while(true)
        {
            System.out.print("\t   Enter here : ");

            String continue_adding_vendor = Main.input.nextLine().toUpperCase();

            switch (continue_adding_vendor)
            {
                case "N", "NO", "Y", "YES":
                    return continue_adding_vendor;

                default:
                    System.out.println("\t\t ○ INVALID INPUT : Enter Y or N.");
                    break;
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
                    System.out.println("\t\t ○ GUIDELINE : Number of " + user_type + " should at least be 01.");
                }
            }
            catch (InputMismatchException InvalidInputError)
            {
                System.out.println("\t\t ○ ERROR : Please enter a numerical value.");
                Main.input.nextLine();
            }
        }
    }



    protected int Validate_OptionForInitializing_CustomersAndVendorDetails()
    {
        while(true)
        {
            System.out.print("""
                  Select option to initialize customer and vendor details
                       PRESS 01 = SETUP MANUALLY
                       PRESS 02 = SETUP NUM OF CUSTOMERS AND VENDORS
                       PRESS 00 = EXIT SYSTEM.
                """);
            System.out.print("  Select Option : ");

            try
            {
                int option = Main.input.nextInt();

                if ( option == 0 || option == 1 || option == 2 )
                {
                    System.out.println();
                    return option;
                }
                else
                {
                    System.out.println("\n\t\t ○ INVALID OPTION : Please select one out of the given.\n");
                    Main.input.nextLine();
                }
            }
            catch (InputMismatchException InvalidInputError)
            {
                System.out.println("\n\t\t ○ INVALID INPUT : Please enter a numerical value.\n");
                Main.input.nextLine();
            }

        }

    }



    protected String Validate_SystemInitiationMenu()
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
                System.out.println("\n\t\t ○ INVALID OPTION : Enter 'START' or 'EXIT'\n");
            }
        }
    }


}