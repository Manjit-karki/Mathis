import { useState } from "react";
import "../style/Login.css";

const Login = () => {
  // For Tracking Inputs
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  // Connection with back-end
  const handleLoginSubmit = async (e) => {
    e.preventDefault(); // To debug and avoid refreshing
    setErrorMessage(""); 

    try {
      // Sending request to controller
      const response = await fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ 
          username: email, 
          password: password 
        }), 
      });

      if (response.ok) {
        const data = await response.json();
        console.log("Success:", data.message);
        
        // Routing to dashboard/homepage upon success
        window.location.href = "/home"; 
      } else {
        const errorData = await response.json();
        setErrorMessage(errorData.error || "Invalid username or password.");
      }
    } catch (error) {
      console.error("Network error:", error);
      setErrorMessage("Could not connect to the server.");
    }
  };

  return (
    <div className="login-body">
      <div className="login-container">
        <h1>Welcome Back</h1>
        <p className="subtitle">Sign in to continue</p>

        {errorMessage && <p style={{ color: "red", textAlign: "center" }}>{errorMessage}</p>}

        <form className="login-form" onSubmit={handleLoginSubmit}>
          <input
            type="text" // Changed from "email" to "text" for username flexibility
            placeholder="Username"
            className="login-input"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <input
            type="password"
            placeholder="Password"
            className="login-input"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <button type="submit" className="login-btn">
            Login
          </button>
        </form>

        <p className="signup-text">
          Don't have an account? <a href="/register">Sign Up</a>
        </p>
      </div>
    </div>
  );
};

export default Login;