import { useState } from 'react';
import './Form.css';

function Form() {
  const [errorMessages, setErrorMessages] = useState<{ [key: string]: string }>({});
  const [formValues, setFormValues] = useState({
    totalTickets: '',
    vendorRate: '',
    customerRate: '',
    maxCapacity: ''
  });

  const handleKeyPress = (e: React.KeyboardEvent<HTMLInputElement>, fieldName: string) => {
    const key = e.key;
    const regex = /^[0-9]$/; // Regex for numeric characters only
    if (!regex.test(key)) {
      e.preventDefault(); // Block invalid input
      setErrorMessages((prev) => ({
        ...prev,
        [fieldName]: 'Only numerical values are allowed.',
      }));
    }
  };

  const handleFocus = (fieldName: string) => {
    // Clear error messages when focusing on any field
    setErrorMessages((prev) => ({
      ...prev,
      [fieldName]: '', // Clear error message for the focused field
    }));
  };

  const handleBlur = (fieldName: string) => {
    // Clear the error message when the user moves out of the current field
    setErrorMessages((prev) => ({
      ...prev,
      [fieldName]: '', // Clear error message when focus leaves
    }));
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>, fieldName: string) => {
    const value = e.target.value;
    setFormValues((prevValues) => ({
      ...prevValues,
      [fieldName]: value,
    }));

    // Clear error when user starts typing (if field is valid)
    if (value !== '') {
      setErrorMessages((prev) => ({
        ...prev,
        [fieldName]: '', // Clear the error when value changes
      }));
    }
  };

  return (
    <form className="form" onSubmit={(e) => e.preventDefault()}>
      <h2 className="form-title">Configuration</h2> {/* Title added here */}
      <div className="form-group">
        <label htmlFor="totalTickets">Total Tickets</label>
        <input
          type="number"
          id="totalTickets"
          placeholder="Enter total tickets"
          required
          value={formValues.totalTickets}
          onChange={(e) => handleChange(e, 'totalTickets')} // Update value on change
          onKeyPress={(e) => handleKeyPress(e, 'totalTickets')}
          onFocus={() => handleFocus('totalTickets')} // Clear error on focus
          onBlur={() => handleBlur('totalTickets')} // Clear error when focus leaves
        />
        {errorMessages['totalTickets'] && (
          <p className="error-message">{errorMessages['totalTickets']}</p>
        )}
      </div>
      <div className="form-group">
        <label htmlFor="vendorRate">Vendor Release Rate</label>
        <input
          type="number"
          id="vendorRate"
          placeholder="Enter vendor release rate"
          required
          value={formValues.vendorRate}
          onChange={(e) => handleChange(e, 'vendorRate')} // Update value on change
          onKeyPress={(e) => handleKeyPress(e, 'vendorRate')}
          onFocus={() => handleFocus('vendorRate')} // Clear error on focus
          onBlur={() => handleBlur('vendorRate')} // Clear error when focus leaves
        />
        {errorMessages['vendorRate'] && (
          <p className="error-message">{errorMessages['vendorRate']}</p>
        )}
      </div>
      <div className="form-group">
        <label htmlFor="customerRate">Customer Retrieval Rate</label>
        <input
          type="number"
          id="customerRate"
          placeholder="Enter customer retrieval rate"
          required
          value={formValues.customerRate}
          onChange={(e) => handleChange(e, 'customerRate')} // Update value on change
          onKeyPress={(e) => handleKeyPress(e, 'customerRate')}
          onFocus={() => handleFocus('customerRate')} // Clear error on focus
          onBlur={() => handleBlur('customerRate')} // Clear error when focus leaves
        />
        {errorMessages['customerRate'] && (
          <p className="error-message">{errorMessages['customerRate']}</p>
        )}
      </div>
      <div className="form-group">
        <label htmlFor="maxCapacity">Max Ticket Capacity</label>
        <input
          type="number"
          id="maxCapacity"
          placeholder="Enter max ticket capacity"
          required
          value={formValues.maxCapacity}
          onChange={(e) => handleChange(e, 'maxCapacity')} // Update value on change
          onKeyPress={(e) => handleKeyPress(e, 'maxCapacity')}
          onFocus={() => handleFocus('maxCapacity')} // Clear error on focus
          onBlur={() => handleBlur('maxCapacity')} // Clear error when focus leaves
        />
        {errorMessages['maxCapacity'] && (
          <p className="error-message">{errorMessages['maxCapacity']}</p>
        )}
      </div>
      <button type="submit" className="form-button">Submit</button>
    </form>
  );
}

export default Form;
