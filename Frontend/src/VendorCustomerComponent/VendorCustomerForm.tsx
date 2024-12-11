import { useState } from 'react';
import './VendorCustomerForm.css';

function VendorCustomerForm() {
  // State to hold form field values
  const [formValues, setFormValues] = useState({
    vendors: '',
    customers: '',
  });

  // State to hold error messages for form validation
  const [errorMessages, setErrorMessages] = useState<{ [key: string]: string }>({});

  /**
   * Handles key press to block invalid input (non-numeric)
   */
  const handleKeyPress = (e: React.KeyboardEvent<HTMLInputElement>, fieldName: string) => {
    const key = e.key;
    const regex = /^[0-9]$/; // Allow only numeric characters
    if (!regex.test(key)) {
      e.preventDefault();
      setErrorMessages((prev) => ({
        ...prev,
        [fieldName]: 'Only numerical values are allowed.',
      }));
    }
  };

  /**
   * Handles focus to clear error message
   */
  const handleFocus = (fieldName: string) => {
    setErrorMessages((prev) => ({
      ...prev,
      [fieldName]: '',
    }));
  };

  /**
   * Handles changes to input fields
   */
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>, fieldName: string) => {
    const value = e.target.value;
    setFormValues((prevValues) => ({
      ...prevValues,
      [fieldName]: value,
    }));

    // Clear error message when user starts typing
    if (value !== '') {
      setErrorMessages((prev) => ({
        ...prev,
        [fieldName]: '',
      }));
    }
  };

  /**
   * Handles form submission
   */
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault(); // Prevent default form submission

    let isValid = true;

    // Validate Vendors
    if (formValues.vendors === '' || parseInt(formValues.vendors) <= 0) {
      setErrorMessages((prev) => ({
        ...prev,
        vendors: 'Vendors must be a positive number.',
      }));
      isValid = false;
    }

    // Validate Customers
    if (formValues.customers === '' || parseInt(formValues.customers) <= 0) {
      setErrorMessages((prev) => ({
        ...prev,
        customers: 'Customers must be a positive number.',
      }));
      isValid = false;
    }

    if (isValid) {
      alert('Vendor and Customer Information is valid and ready for submission!');
    }
  };

  return (
    <form className="vendor-customer-form" onSubmit={handleSubmit}>
      <div className="form-title">Vendor and Customer Information</div>

      {/* Vendors Input Field */}
      <div className="form-group">
        <label htmlFor="vendors">Number of Vendors</label>
        <input
          type="number"
          id="vendors"
          placeholder="Enter number of vendors"
          required
          value={formValues.vendors}
          onChange={(e) => handleChange(e, 'vendors')}
          onKeyPress={(e) => handleKeyPress(e, 'vendors')}
          onFocus={() => handleFocus('vendors')}
        />
        {errorMessages['vendors'] && (
          <p className="error-message">{errorMessages['vendors']}</p>
        )}
      </div>

      {/* Customers Input Field */}
      <div className="form-group">
        <label htmlFor="customers">Number of Customers</label>
        <input
          type="number"
          id="customers"
          placeholder="Enter number of customers"
          required
          value={formValues.customers}
          onChange={(e) => handleChange(e, 'customers')}
          onKeyPress={(e) => handleKeyPress(e, 'customers')}
          onFocus={() => handleFocus('customers')}
        />
        {errorMessages['customers'] && (
          <p className="error-message">{errorMessages['customers']}</p>
        )}
      </div>

      {/* Submit Button */}
      <button type="submit" className="form-button">Submit</button>
    </form>
  );
}

export default VendorCustomerForm;
