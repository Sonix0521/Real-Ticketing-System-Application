import './Form.css';

function Form() {
  return (
    <form className="form" onSubmit={(e) => e.preventDefault()}>
      <div className="form-group">
        <label htmlFor="totalTickets">Total Tickets</label>
        <input
          type="number"
          id="totalTickets"
          placeholder="Enter total tickets"
          required
          // Set custom message when the field is invalid
          onInvalid={(e) => {
            const target = e.target as HTMLInputElement;
            if (!target.value) {
              target.setCustomValidity('This field cannot be empty. Please enter a number.');
            } else {
              target.setCustomValidity('Please enter a valid number.');
            }
          }}
          // Clear the message when the user starts typing
          onInput={(e) => (e.target as HTMLInputElement).setCustomValidity('')}
        />
      </div>
      <div className="form-group">
        <label htmlFor="vendorRate">Vendor Release Rate</label>
        <input
          type="number"
          id="vendorRate"
          placeholder="Enter vendor release rate"
          required
          onInvalid={(e) => {
            const target = e.target as HTMLInputElement;
            if (!target.value) {
              target.setCustomValidity('This field cannot be empty. Please enter a number.');
            } else {
              target.setCustomValidity('Please enter a valid number.');
            }
          }}
          onInput={(e) => (e.target as HTMLInputElement).setCustomValidity('')}
        />
      </div>
      <div className="form-group">
        <label htmlFor="customerRate">Customer Retrieval Rate</label>
        <input
          type="number"
          id="customerRate"
          placeholder="Enter customer retrieval rate"
          required
          onInvalid={(e) => {
            const target = e.target as HTMLInputElement;
            if (!target.value) {
              target.setCustomValidity('This field cannot be empty. Please enter a number.');
            } else {
              target.setCustomValidity('Please enter a valid number.');
            }
          }}
          onInput={(e) => (e.target as HTMLInputElement).setCustomValidity('')}
        />
      </div>
      <div className="form-group">
        <label htmlFor="maxCapacity">Max Ticket Capacity</label>
        <input
          type="number"
          id="maxCapacity"
          placeholder="Enter max ticket capacity"
          required
          onInvalid={(e) => {
            const target = e.target as HTMLInputElement;
            if (!target.value) {
              target.setCustomValidity('This field cannot be empty. Please enter a number.');
            } else {
              target.setCustomValidity('Please enter a valid number.');
            }
          }}
          onInput={(e) => (e.target as HTMLInputElement).setCustomValidity('')}
        />
      </div>
      <button type="submit" className="form-button">Submit</button>
    </form>
  );
}

export default Form;
