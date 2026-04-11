import React, { useEffect, useState } from "react";
//import { getMyProfile } from "../services/api";

function Profile() {
  const [user, setUser] = useState(null);
/*
  useEffect(() => {
    const token = localStorage.getItem("token");

    getMyProfile(token).then((data) => {
      setUser(data);
    });
  }, []);

  if (!user) return <p>Loading profile...</p>;

  return (
    <div style={{ padding: "20px" }}>
      <h2>Profile</h2>

      <div>
        <p><b>First Name:</b> {user.firstname}</p>
        <p><b>Last Name:</b> {user.lastname}</p>
        <p><b>Email:</b> {user.email}</p>
        <p><b>Role:</b> {user.role}</p>
      </div>
    </div>
  );
}
*/

    return (
        <div>
            <h2>empty for now</h2>
        </div>
    );
}
export default Profile;