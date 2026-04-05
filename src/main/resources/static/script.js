async function createUser() {
    await fetch('/users', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            name: document.getElementById('name').value,
            email: document.getElementById('email').value
        })
    });
    alert("User Created");
}

async function createPlan() {
    await fetch('/plans', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            name: document.getElementById('planName').value,
            price: document.getElementById('price').value,
            duration: document.getElementById('duration').value
        })
    });
    alert("Plan Created");
}

async function subscribe() {
    const userId = document.getElementById('userId').value;
    const planId = document.getElementById('planId').value;

    await fetch(`/subscriptions/subscribe?userId=${userId}&planId=${planId}`, {
        method: 'POST'
    });

    alert("Subscribed!");
}

async function getUsers() {
    const res = await fetch('/users');
    const data = await res.json();
    document.getElementById('output').innerText =
        JSON.stringify(data, null, 2);
}