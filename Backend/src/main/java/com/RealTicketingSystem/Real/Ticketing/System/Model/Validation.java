package com.RealTicketingSystem.Real.Ticketing.System.Model;

import com.RealTicketingSystem.Real.Ticketing.System.Service.TicketPoolAppService;

import java.util.InputMismatchException;

public class Validation
{

    /**
     * This method contains the Validations required for the initialization of configuration settings for the Configuration class.
     * @param configuration_statement passed in the prompt statement for the related configuration setting for the user to enter.
     * @return config_values.
     */
    public int Validate_Configuration_Settings(String configuration_statement)
    {
        while (true)
        {
            System.out.print(configuration_statement);

            if (TicketPoolAppService.input.hasNextInt())
            {
                int config_value = TicketPoolAppService.input.nextInt();

                if (config_value > 0)
                {
                    if (configuration_statement.equalsIgnoreCase("\t ■ Enter total number of tickets : ") && config_value == 1)
                    {
                        System.out.println(ColorsUtil.YELLOW + "\t\t ○ GUIDELINE : Total tickets should be larger than 1." + ColorsUtil.RESET);
                        TicketPoolAppService.input.nextLine();
                        continue;
                    }
                    if (configuration_statement.equalsIgnoreCase("\t ■ Enter maximum ticket capacity : ") && config_value < TicketPoolAppService.configuration.getTotal_tickets() )
                    {
                        System.out.println(ColorsUtil.YELLOW + "\t\t ○ GUIDELINE : Total tickets should not exceed maximum ticket capacity." + ColorsUtil.RESET);
                        TicketPoolAppService.input.nextLine();
                        continue;
                    }
                    if ( configuration_statement.equalsIgnoreCase("\t ■ Enter ticket release rate     : ") && config_value > TicketPoolAppService.configuration.getTotal_tickets()/2 )
                    {
                        System.out.println(ColorsUtil.YELLOW + "\t\t ○ GUIDELINE : Vendor release rate must be at least 50% less than total tickets." + ColorsUtil.RESET);
                        TicketPoolAppService.input.nextLine();
                        continue;
                    }
                    if ( configuration_statement.equalsIgnoreCase("\t ■ Enter customer retrieval rate : ") && config_value > TicketPoolAppService.configuration.getTotal_tickets()/2 )
                    {
                        System.out.println(ColorsUtil.YELLOW + "\t\t ○ GUIDELINE : Customer retrieval rate must be at least 50% less than total tickets." + ColorsUtil.RESET);
                        TicketPoolAppService.input.nextLine();
                        continue;
                    }
                    return config_value;
                }
                else
                {
                    System.out.println(ColorsUtil.RED + "\t\t ○ INVALID INPUT : Please enter a positive value." + ColorsUtil.RESET);
                }
            }
            else if (TicketPoolAppService.input.hasNextDouble())
            {
                System.out.println(ColorsUtil.RED + "\t\t ○ INVALID INPUT : Integer numerics are required." + ColorsUtil.RESET);
                TicketPoolAppService.input.next();
            }
            else
            {
                System.out.println(ColorsUtil.RED + "\t\t ○ INVALID INPUT : Please enter a numerical value." + ColorsUtil.RESET);
                TicketPoolAppService.input.next();
            }
        }
    }



    public int Validate_TotalNumOf_CustomersAndVendors(String prompt_statement, String user_type)
    {
        while(true)
        {
            try
            {
                System.out.print(prompt_statement);
                int total_num_of_usertype = TicketPoolAppService.input.nextInt();

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
                TicketPoolAppService.input.nextLine();
            }
        }
    }

}
