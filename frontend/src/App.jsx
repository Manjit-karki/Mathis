import { Route, Routes } from "react-router";
import HomePage from "./pages/HomePage";
import Dashboard from "./pages/Dashboard";
import Quiz from "./pages/Quiz";

const App = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<HomePage />} /> 
        <Route path="/dashboard" element={<Dashboard />} /> 
        <Route path="/quiz" element={<Quiz />} /> 
      </Routes>
  
    </div>
  ); 
}

export default App
