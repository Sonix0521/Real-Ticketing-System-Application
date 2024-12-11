package com.RealTicketingSystem.Real.Ticketing.System.Controller;

import com.RealTicketingSystem.Real.Ticketing.System.Service.TicketPoolAppService;
import com.RealTicketingSystem.Real.Ticketing.System.Model.TicketPool;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/API_EndPoints")
public class TicketPoolAppController
{
    @PostMapping("/Initialize_TicketPool")
    public static String Initialize_TicketPool_APIEndpoint(@RequestBody TicketPool configuration_parameters) {
//        Calls the service to create a ticket pool and returns the created object
        TicketPoolAppService.Initialize_TicketPool(configuration_parameters);
        return "Ticket Pool Successfully Initialized.";
    }
    @PostMapping("/Initialize_VendorAndCustomer")
    public static String Initialize_VendorsAndCustomers_APIEndpoint(@RequestBody int total_vendors , @RequestBody int total_customers)
    {
        TicketPoolAppService.Initialize_Total_CustomersAndVendors(total_vendors, total_customers);
        return "Total Vendors & Customers Successfully Initialized.";
    }

    @PostMapping("/Display_AvailableTickets")
    public static int DisplayAvailableTickets_APIEndpoint()
    {
        return TicketPoolAppService.AvailableTickets();
    }

    @PostMapping("StartSimulation")
    public static String StartSimulation_APIEndpoint()
    {
        TicketPoolAppService.RunSimulation();
        return "Simulation Executing.";
    }

    @PostMapping("StopSimulation")
    public static String StopSimulation_APIEndpoint()
    {
        TicketPoolAppService.StopSimulation();
        return "Simulation Terminated.";
    }
}
