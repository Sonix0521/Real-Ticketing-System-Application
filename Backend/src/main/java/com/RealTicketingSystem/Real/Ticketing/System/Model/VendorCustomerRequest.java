package com.RealTicketingSystem.Real.Ticketing.System.Model;

public class VendorCustomerRequest {
    private int num_of_vendors;
    private int num_of_customers;

    // No-argument constructor (required for deserialization)
    public VendorCustomerRequest() {}

    // Getters and setters
    public int getNum_of_vendors() {
        return num_of_vendors;
    }

    public void setNum_of_vendors(int num_of_vendors) {
        this.num_of_vendors = num_of_vendors;
    }

    public int getNum_of_customers() {
        return num_of_customers;
    }

    public void setNum_of_customers(int num_of_customers) {
        this.num_of_customers = num_of_customers;
    }

    @Override
    public String toString() {
        return "VendorCustomerRequest{" +
                "num_of_vendors=" + num_of_vendors +
                ", num_of_customers=" + num_of_customers +
                '}';
    }
}
