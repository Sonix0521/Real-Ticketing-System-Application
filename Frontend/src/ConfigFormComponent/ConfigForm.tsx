import { useState } from 'react';
import './ConfigForm.css';
import axios from 'axios';

function Form() {
  // State to hold form field values
  const [formValues, setFormValues] = useState({
    total_tickets: '',
    ticket_release_rate: '',
    customer_retrieval_rate: '',
    max_ticket_capacity: ''
  });

  const FetchConfigForm = async () => {
    try {
      const response = await axios.post(
        "http://localhost:8080/API_EndPoints/Initialize_TicketPool",
        formValues
      );
      console.log(response.data);
    } catch (error) {
      console.error("Error occurred while posting form:", error);
    }
  };

  // State to hold error messages for form validation
  const [errorMessages, setErrorMessages] = useState<{ [key: string]: string }>({});

  /**
   * Validates the Total Tickets field (must be greater than 1)
   */
  const validateTotalTickets = (value: number) => {
    if (value <= 1) {
      return "Total tickets must be greater than 1."; // Return error message if invalid
    }
    return ""; // Return empty string if valid
  };

  /**
   * Validates the Vendor Release Rate (should be <= 50% of Total Tickets)
   */
  const validateVendorRate = (value: number, totalTickets: number) => {
    if (value > totalTickets / 2) {
      return "Vendor release rate must be at least 50% less than total tickets."; // Validation error
    }
    return ""; // Return empty string if valid
  };

  /**
   * Validates the Customer Retrieval Rate (should be <= 50% of Total Tickets)
   */
  const validateCustomerRate = (value: number, totalTickets: number) => {
    if (value > totalTickets / 2) {
      return "Customer retrieval rate must be at least 50% less than total tickets."; // Validation error
    }
    return ""; // Return empty string if valid
  };

  /**
   * Validates the Max Ticket Capacity (must be greater than Total Tickets)
   */
  const validateMaxCapacity = (value: number, totalTickets: number) => {
    if (value <= totalTickets) {
      return "Max capacity must be greater than total tickets."; // Validation error
    }
    return ""; // Return empty string if valid
  };

  /**
   * Handles changes to input fields and updates form values
   */
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>, fieldName: string) => {
    const value = e.target.value;
    setFormValues((prevValues) => ({
      ...prevValues,
      [fieldName]: value, // Update the form value for the changed field
    }));

    // Clear error when user starts typing and field is valid
    if (value !== '') {
      setErrorMessages((prev) => ({
        ...prev,
        [fieldName]: '', // Clear error when value changes
      }));
    }
  };

  /**
   * Handles form submission, validates fields, and displays error messages if necessary
   */
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault(); // Prevent default form submission

    const totalTickets = parseInt(formValues.total_tickets); // Convert input value to number
    const vendorRate = parseInt(formValues.ticket_release_rate);
    const customerRate = parseInt(formValues.customer_retrieval_rate);
    const maxCapacity = parseInt(formValues.max_ticket_capacity);

    let isValid = true; // Flag to track form validity

    // Validate each field and set error messages accordingly
    const totalTicketsError = validateTotalTickets(totalTickets);
    if (totalTicketsError) {
      setErrorMessages((prev) => ({ ...prev, totalTickets: totalTicketsError }));
      isValid = false; // Mark form as invalid if error is found
    }

    const vendorRateError = validateVendorRate(vendorRate, totalTickets);
    if (vendorRateError) {
      setErrorMessages((prev) => ({ ...prev, vendorRate: vendorRateError }));
      isValid = false;
    }

    const customerRateError = validateCustomerRate(customerRate, totalTickets);
    if (customerRateError) {
      setErrorMessages((prev) => ({ ...prev, customerRate: customerRateError }));
      isValid = false;
    }

    const maxCapacityError = validateMaxCapacity(maxCapacity, totalTickets);
    if (maxCapacityError) {
      setErrorMessages((prev) => ({ ...prev, maxCapacity: maxCapacityError }));
      isValid = false;
    }

    // If all fields are valid, proceed with form submission
    if (isValid) {
      alert("Form is valid and ready for submission!"); // Placeholder for form submission logic
      FetchConfigForm(); // Send data to backend if valid
    }
  };

  return (
    <form className="form" onSubmit={handleSubmit}>
      <div className="form-title">Configuration Settings</div>

      {/* Total Tickets Input Field */}
      <div className="form-group">
        <label htmlFor="totalTickets">Total Tickets</label>
        <input
          type="number"
          id="totalTickets"
          placeholder="Enter total tickets"
          required
          value={formValues.total_tickets}
          onChange={(e) => handleChange(e, 'total_tickets')} // Ensure the correct field name is used
        />
        {errorMessages['total_tickets'] && (
          <p className="error-message">{errorMessages['total_tickets']}</p>
        )}
      </div>

      {/* Vendor Release Rate Input Field */}
      <div className="form-group">
        <label htmlFor="vendorRate">Vendor Release Rate</label>
        <input
          type="number"
          id="vendorRate"
          placeholder="Enter vendor release rate"
          required
          value={formValues.ticket_release_rate}
          onChange={(e) => handleChange(e, 'ticket_release_rate')}
        />
        {errorMessages['ticket_release_rate'] && (
          <p className="error-message">{errorMessages['ticket_release_rate']}</p>
        )}
      </div>

      {/* Customer Retrieval Rate Input Field */}
      <div className="form-group">
        <label htmlFor="customerRate">Customer Retrieval Rate</label>
        <input
          type="number"
          id="customerRate"
          placeholder="Enter customer retrieval rate"
          required
          value={formValues.customer_retrieval_rate}
          onChange={(e) => handleChange(e, 'customer_retrieval_rate')}
        />
        {errorMessages['customer_retrieval_rate'] && (
          <p className="error-message">{errorMessages['customer_retrieval_rate']}</p>
        )}
      </div>

      {/* Max Ticket Capacity Input Field */}
      <div className="form-group">
        <label htmlFor="maxCapacity">Max Ticket Capacity</label>
        <input
          type="number"
          id="maxCapacity"
          placeholder="Enter max ticket capacity"
          required
          value={formValues.max_ticket_capacity}
          onChange={(e) => handleChange(e, 'max_ticket_capacity')}
        />
        {errorMessages['max_ticket_capacity'] && (
          <p className="error-message">{errorMessages['max_ticket_capacity']}</p>
        )}
      </div>

      {/* Submit Button */}
      <button type="submit" className="form-button">Submit</button>
    </form>
  );
}

export default Form;
