document.getElementById("loginForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const response = await fetch("http://localhost:8080/api/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password })
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem("token", data.token); // save JWT
            alert("✅ Login successful!");
            window.location.href = "home.html";
        } else {
            alert("❌ Invalid credentials!");
        }
    } catch (err) {
        alert("❌ Server error: " + err);
    }
});
