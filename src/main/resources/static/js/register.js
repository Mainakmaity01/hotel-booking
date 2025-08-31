document.getElementById("registerForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const response = await fetch("http://localhost:8080/api/auth/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name,
                email: email,
                password: password
            })
        });

        if (response.ok) {
            alert("✅ User registered successfully!");
            window.location.href = "login.html";
        } else {
            const errorText = await response.text();
            alert("❌ Error registering user: " + errorText);
        }
    } catch (err) {
        alert("❌ Server not reachable: " + err);
    }
});
