// StartStopButtons.tsx
import axios from 'axios';
import './StartStopBtn.css'; // Import the CSS for styling the buttons

const StartStopButtons = () => {
  return (
    <div className="start-stop-buttons">
      <button className="start-button" onClick={(e)=>{e.preventDefault();FetchStartSimulation()}}>Start</button>
      <button className="stop-button" onClick={(e)=>{e.preventDefault();FetchStopSimulation()}}>Stop</button>
    </div>
  );
};

const FetchStartSimulation = async () => {
  try {
    const response = await axios.post(
      "http://localhost:8080/API_EndPoints/StartSimulation"
    );
    console.log(response.data);
  } catch (error) {
    console.error("Error occurred while posting form:", error);
  }
};

const FetchStopSimulation = async () => {
  try {
    const response = await axios.post(
      "http://localhost:8080/API_EndPoints/StopSimulation"
    );
    console.log(response.data);
  } catch (error) {
    console.error("Error occurred while posting form:", error);
  }
};

export default StartStopButtons;
