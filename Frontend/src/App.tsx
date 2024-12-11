import './App.css';
import ConfigForm from './ConfigFormComponent/ConfigForm'; // Ensure the path is correct
import VendorCustomerForm from './VendorCustomerComponent/VendorCustomerForm';
import TicketDisplayComponent from './TicketDisplayComponent/TicketDisplay'; // Import the TicketDisplayComponent
import StartStopButtons from './StartStopBtnComponent/StartStopBtn'; // Import the StartStopButtons component
import LogDisplay from './LogDisplayComponent/LogDisplay';


function App() {

  const totalTickets = 100;

  return (
    <div className="container">

      <h1>Real Ticketing System</h1>

      <div className="forms-container">
        {/* Configuration Form and Vendor/Customer Form */}
        <div className="form-section">
          <ConfigForm />
        </div>
        <div className="form-section">
          <VendorCustomerForm />
        </div>
      </div>

      <div className="ticket-display-section">
        {/* Render the TicketDisplayComponent */}
        <TicketDisplayComponent totalTickets={totalTickets} />
      </div>
    
      <div className="start-stop-buttons-section">
        {/* Render the StartStopButtons */}
        <StartStopButtons />
      </div>

      <div className="log-display-section">
        <LogDisplay /> {/* Add LogDisplay below TicketDisplay */}
      </div>

    </div>
  );
}

export default App;
