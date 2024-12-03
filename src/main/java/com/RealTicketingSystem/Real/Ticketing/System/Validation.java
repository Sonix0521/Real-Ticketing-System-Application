package com.RealTicketingSystem.Real.Ticketing.System;

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

    public String Validate_name(String prompt_enter_name_statement)
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
                System.out.println("\n\t ○ Invalid Input. Non-alphabetical characters aren't allowed for name.\n");
            }
        }
    }

    public String Validate_AddUser_Iteration(String prompt_iteration_statement)
    {
        System.out.print(prompt_iteration_statement);

        while(true)
        {
            System.out.print("\tEnter here : ");

            String continue_adding_vendor = Main.input.nextLine().toUpperCase();

            switch (continue_adding_vendor)
            {
                case "N", "NO", "Y", "YES":
                    return continue_adding_vendor;

                default:
                    System.out.println("\n\t ○ Invalid Input. Enter Y or N.\n");
                    break;
            }

        }

    }


}
