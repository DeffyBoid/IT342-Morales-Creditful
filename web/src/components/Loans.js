import React, { useEffect, useState } from "react";
//import { getMyLoans } from "../services/api";

function Loans() {
  const [loans, setLoans] = useState([]);
/*
  useEffect(() => {
    const token = localStorage.getItem("token");

    getMyLoans(token).then((data) => {
      setLoans(data);
    });
  }, []);
*/
  return (
    <div style={{ padding: "20px" }}>
      <h2>My Loans</h2>

      {loans.length === 0 ? (
        <p>No loans found.</p>
      ) : (
        loans.map((loan) => (
          <div
            key={loan.id}
            style={{
              border: "1px solid #ccc",
              padding: "10px",
              marginBottom: "10px",
              borderRadius: "6px",
            }}
          >
            <p><b>Amount:</b> {loan.principal}</p>
            <p><b>Remaining:</b> {loan.remainingBalance}</p>
            <p><b>Status:</b> {loan.status}</p>
            <p><b>Due Date:</b> {loan.dueDate}</p>
          </div>
        ))
      )}
    </div>
  );
}

export default Loans;