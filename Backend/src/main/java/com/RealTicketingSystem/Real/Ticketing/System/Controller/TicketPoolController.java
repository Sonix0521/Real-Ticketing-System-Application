package com.RealTicketingSystem.Real.Ticketing.System.Controller;

import com.RealTicketingSystem.Real.Ticketing.System.Main;
import com.RealTicketingSystem.Real.Ticketing.System.Service.TicketPoolService;
import com.RealTicketingSystem.Real.Ticketing.System.TicketPool;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/ticketpool")
public class TicketPoolController
{
    @PostMapping
    public static String createTicketPool(@RequestBody TicketPool request) {
//        Calls the service to create a ticket pool and returns the created object
        TicketPoolService.InitializeTicketPool(request);
        return "ticketpool createdd ";
    }
    @PostMapping("/vc_count")
    public static String createVCCount(@RequestBody int Vcount , @RequestBody int CCount){
        return "CV ";
    }
}
