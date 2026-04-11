import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../styles/Navbar.css";

function Navbar() {
  const navigate = useNavigate();
  const [open, setOpen] = useState(false);

  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  };

  return (
    <div className="navbar">
      {/* LEFT: Brand */}
      <div className="navbar-brand" onClick={() => navigate("/dashboard")}>
        Creditful
      </div>

      {/* RIGHT: Links + Menu */}
      <div className="navbar-right">
        <button className="nav-link" onClick={() => navigate("/dashboard")}>
          Home
        </button>

        <button className="nav-link" onClick={() => navigate("/loans")}>
          Loans
        </button>

        <div className="menu-wrapper">
          <button className="menu-button" onClick={() => setOpen(!open)}>
            Menu
          </button>

          {open && (
            <div className="dropdown">
              <button
                className="dropdown-item"
                onClick={() => navigate("/profile")}
              >
                Profile
              </button>

              <button className="dropdown-item" onClick={handleLogout}>
                Logout
              </button>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default Navbar;