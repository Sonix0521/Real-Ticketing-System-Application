import './Form.css';

function Form() {
  return (
    <form className="form">
      <div className="form-group">
        <label htmlFor="totalTickets">Total Tickets</label>
        <input type="number" id="totalTickets" placeholder="Enter total tickets" />
      </div>
      <div className="form-group">
        <label htmlFor="vendorRate">Vendor Release Rate</label>
        <input type="number" id="vendorRate" placeholder="Enter vendor release rate" />
      </div>
      <div className="form-group">
        <label htmlFor="customerRate">Customer Retrieval Rate</label>
        <input type="number" id="customerRate" placeholder="Enter customer retrieval rate" />
      </div>
      <div className="form-group">
        <label htmlFor="maxCapacity">Max Ticket Capacity</label>
        <input type="number" id="maxCapacity" placeholder="Enter max ticket capacity" />
      </div>
      <button type="submit" className="form-button">Submit</button>
    </form>
  );
}

export default Form;
