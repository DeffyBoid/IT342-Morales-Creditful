import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
//import { getUserLoans } from "../services/api";
import Navbar from "./Navbar";
import "../styles/Dashboard.css";

function Dashboard() {
  const navigate = useNavigate();
  const [loans, setLoans] = useState([]);
  
  useEffect(() => {
    const dummyLoans = [
      { id: 1, principal: 5000, status: "ACTIVE" },
      { id: 2, principal: 12000, status: "COMPLETED" },
    ];

    setLoans(dummyLoans);
  }, []);
  /*
  useEffect(() => {
  async function fetchLoans() {
    try {
      const userId = 1; // temporary for now
      const data = await getUserLoans(userId);
      setLoans(data);
    } catch (error) {
      console.error("Error fetching loans:", error);
    }
  }
 
  fetchLoans();
  }, []);
  */
  const handleLogout = () => {
    navigate("/login");
  };

  return (
    <div>
      <Navbar />
    
    <div className="dashboard-container">
      {/* Header */}
      <div className="dashboard-header">
        <h1>Welcome John Doe!</h1>
      </div>

      {/* Summary Cards */}
      <div className="summary-container">
        <div className="card">
          <h3>Total Loans</h3>
          <p>{loans.length}</p>
        </div>

        <div className="card">
          <h3>Active Loans</h3>
          <p>{loans.filter(l => l.status === "ACTIVE").length}</p>
        </div>

        <div className="card">
          <h3>Completed Loans</h3>
          <p>{loans.filter(l => l.status === "COMPLETED").length}</p>
        </div>
      </div>

      {/* Loan List */}
      <div className="loan-section">
        <h2>Your Loans</h2>

        {loans.map((loan) => (
          <div key={loan.id} className="loan-card">
            <div>
              <h3>Loan #{loan.id}</h3>
              <p>Principal: ₱{loan.principal}</p>
            </div>

            <span className={`status ${loan.status.toLowerCase()}`}>
              {loan.status}
            </span>
          </div>
        ))}
      </div>
    </div>

    </div>
  );
}

export default Dashboard;