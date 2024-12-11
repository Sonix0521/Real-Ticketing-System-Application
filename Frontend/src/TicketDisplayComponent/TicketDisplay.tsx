import React from 'react';
import './TicketDisplay.css';

interface TicketDisplayProps {
  totalTickets: number;
}

const TicketDisplayComponent: React.FC<TicketDisplayProps> = ({ totalTickets }) => {
  return (
    <div className="ticket-display">
      <h2 className="ticket-title">Available Tickets</h2>
      <p className="ticket-count">{totalTickets}</p>
    </div>
  );
};

export default TicketDisplayComponent;
