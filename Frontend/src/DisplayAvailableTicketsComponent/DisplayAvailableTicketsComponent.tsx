import React from 'react';
import './DisplayAvailableTicketsComponent.css';
import axios from 'axios';

interface TicketDisplayProps {
  totalTickets: number;
}

const DisplayAvailableTicketsComponent: React.FC<TicketDisplayProps> = ({ totalTickets }) => {
  return (
    <div className="ticket-display">
      <h2 className="ticket-title">Available Tickets</h2>
      <p className="ticket-count">{totalTickets}</p>
    </div>
  );
};

const FetchDisplayAvailableTickets = async () => {
  try {
    const response = await axios.post(
      "http://localhost:8080/API_EndPoints/Display_AvailableTickets"
    );
    console.log(response.data);
  } catch (error) {
    console.error("Error occurred while posting form:", error);
  }
};

export default DisplayAvailableTicketsComponent;
