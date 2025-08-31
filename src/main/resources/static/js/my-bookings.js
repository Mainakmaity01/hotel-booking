window.onload = async () => {
    const token = localStorage.getItem("token");

    if (!token) {
        alert("Please login first!");
        window.location.href = "login.html";
        return;
    }

    let res = await fetch("http://localhost:8080/api/bookings/my", {
        headers: {
            "Authorization": "Bearer " + token
        }
    });

    if (res.ok) {
        const bookings = await res.json();
        const list = document.getElementById("bookingsList");
        bookings.forEach(b => {
            const li = document.createElement("li");
            li.textContent = `${b.roomType} | ${b.checkIn} → ${b.checkOut}`;
            list.appendChild(li);
        });
    } else {
        alert("Could not load bookings!");
    }
};
