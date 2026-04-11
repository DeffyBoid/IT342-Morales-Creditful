export const API_BASE_URL = "http://localhost:8080/api/v1";

export async function registerUser(userData) {
  const response = await fetch(`${API_BASE_URL}/auth/register`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(userData),
  });
  return response.json();
}
/*
export async function getUserLoans(userId) {
  const response = await fetch(`${API_BASE_URL}/loans/user/${userId}`);

  if (!response.ok) {
    throw new Error("Failed to fetch loans");
  }

  return response.json();
}

export async function getMyProfile(token) {
  const res = await fetch(`${API_BASE_URL}/users/me`, {
    method: "GET",
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  return res.json();
}


export async function getMyLoans(token) {
  const res = await fetch(`${API_BASE_URL}/loans/my-loans`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  return res.json();
}
*/
/* Dashboard: close due loans */
/*
export async function getCloseDueLoans(token) {
  const res = await fetch(`${API_BASE_URL}/loans/close-due?limit=3`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  return res.json();
}
  */