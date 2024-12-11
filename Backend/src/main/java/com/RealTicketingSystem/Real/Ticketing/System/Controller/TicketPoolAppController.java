package com.RealTicketingSystem.Real.Ticketing.System.Controller;

import com.RealTicketingSystem.Real.Ticketing.System.Model.VendorCustomerRequest;
import com.RealTicketingSystem.Real.Ticketing.System.Service.TicketPoolAppService;
import com.RealTicketingSystem.Real.Ticketing.System.Model.TicketPool;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/API_EndPoints")
public class TicketPoolAppController
{
    @PostMapping("/Initialize_TicketPool")
    public static String Initialize_TicketPool_APIEndpoint(@RequestBody TicketPool configuration_parameters_request) {
//        Calls the service to create a ticket pool and returns the created object
        TicketPoolAppService.Initialize_TicketPool(configuration_parameters_request);
        return "Ticket Pool Successfully Initialized.";
    }
    @PostMapping("/Initialize_VendorAndCustomer")
    public static String Initialize_VendorsAndCustomers_APIEndpoint(@RequestBody VendorCustomerRequest total_vendors_and_customers_request)
    {
        int num_of_vendors = total_vendors_and_customers_request.getTotalVendors();
        int num_of_customers = total_vendors_and_customers_request.getTotalCustomers();
        TicketPoolAppService.Initialize_Total_CustomersAndVendors(num_of_vendors, num_of_customers);
        return "Total Vendors & Customers Successfully Initialized.";
    }

    @PostMapping("Display_AvailableTickets")
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
