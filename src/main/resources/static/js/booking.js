document.getElementById("bookingForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const token = localStorage.getItem("token");

    if (!token) {
        alert("Please login first!");
        window.location.href = "login.html";
        return;
    }

    const formData = new FormData(e.target);
    const body = {
        roomType: formData.get("roomType"),
        checkIn: formData.get("checkIn"),
        checkOut: formData.get("checkOut")
    };

    let res = await fetch("http://localhost:8080/api/bookings", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token
        },
        body: JSON.stringify(body)
    });

    if (res.ok) {
        alert("Room booked successfully!");
    } else {
        alert("Booking failed!");
    }
});
