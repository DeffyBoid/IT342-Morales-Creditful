import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "../styles/Auth.css";

function LoginForm() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(""); // Reset error

    try {
      const response = await fetch("http://localhost:8080/api/v1/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });

      const data = await response.json();

      if (response.ok && data.success) {
        console.log("Login success:", data);
        navigate("/dashboard"); // Redirect to dashboard
      } else {
        setError(data.message || "Invalid email or password");
      }
    } catch (err) {
      console.error(err);
      setError("Server unreachable or network error");
    }
  };

  return (
  <div className="auth-container">
    <div className="auth-header">Creditful</div>
    
    <div className="auth-card">
      <h1 className="auth-title">Login</h1>

      <form onSubmit={handleSubmit}>
        <input
          className="auth-input"
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />

        <input
          className="auth-input"
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />

        <button className="auth-button" type="submit">
          Login
        </button>
      </form>

      {error && <p className="error-text">{error}</p>}

      <p className="auth-link">
        Don't have an account? <Link to="/register">Sign up</Link>
      </p>
    </div>
  </div>
  );
}

export default LoginForm;