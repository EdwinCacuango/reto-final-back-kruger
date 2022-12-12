import "./App.css";
import Home from "./pages/Home";
import { Routes, Route } from "react-router-dom";
import Patient from "./pages/Patient";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/patient/:id" element={<Patient />} />
      </Routes>
    </div>
  );
}

export default App;
