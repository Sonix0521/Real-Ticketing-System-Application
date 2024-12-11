import './App.css';
import Form from './ConfigFormComponent/ConfigForm'; // Ensure the path is correct
import VendorCustomerForm from './VendorCustomerComponent/VendorCustomerForm';
import TicketDisplayComponent from './TicketDisplayComponent/TicketDisplay'; // Import the TicketDisplayComponent


function App() {

  const totalTickets = 100;

  return (
    <div className="container">
      <h1>Real Ticketing System</h1>

      <Form/>
      <VendorCustomerForm/>

      <TicketDisplayComponent totalTickets={totalTickets} />
    </div>
  );
}

export default App;
