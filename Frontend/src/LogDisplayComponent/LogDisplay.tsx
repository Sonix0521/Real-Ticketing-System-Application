// LogDisplay.tsx
import { useState, useEffect } from 'react';
import './LogDisplay.css';

// Sample log data to simulate vendor releases and customer purchases
const sampleLogs = [
  'Vendor 1 released 10 tickets.',
  'Customer 1 purchased 3 tickets.',
  'Vendor 2 released 15 tickets.',
  'Customer 2 purchased 5 tickets.',
  'Vendor 1 released 10 tickets.',
  'Customer 3 purchased 2 tickets.',
];

const LogDisplay = () => {
  // Simulate logs being added dynamically (could be replaced with data fetched from backend)
  const [logs, setLogs] = useState<string[]>(sampleLogs);

  useEffect(() => {
    // Logic to add logs dynamically can be added here
    const logInterval = setInterval(() => {
      setLogs((prevLogs) => [...prevLogs, `Log entry at ${new Date().toLocaleTimeString()}`]);
    }, 5000); // Add a new log every 5 seconds

    return () => clearInterval(logInterval); // Clean up the interval on unmount
  }, []);

  return (
    <div className="log-display-container">
      <h2>Ticketing System Logs</h2>
      <div className="log-list">
        {logs.map((log, index) => (
          <div key={index} className="log-item">
            {log}
          </div>
        ))}
      </div>
    </div>
  );
};

export default LogDisplay;
