function sendMessage() {
  const input = document.getElementById("messageInput");
  const message = input.value.trim();

  if (!message) return;

  addMessage("Bạn", message, "user");
  input.value = "";

  fetch("http://localhost:8080/api/chat", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ message })
  })
    .then(res => res.json())
    .then(data => {
      addMessage("Bot", data.reply, "bot");
    })
    .catch(() => {
      addMessage("Bot", "Lỗi kết nối server", "bot");
    });
}
function addMessage(sender, text, type) {
  const chatBox = document.getElementById("chatBox");

  const messageDiv = document.createElement("div");

  if (type === "user") {
    messageDiv.className =
      "text-right bg-blue-100 text-blue-800 p-2 rounded-lg self-end";
  } else {
    messageDiv.className =
      "text-left bg-green-100 text-green-800 p-2 rounded-lg self-start";
  }

  messageDiv.innerText = `${sender}: ${text}`;
  chatBox.appendChild(messageDiv);

  chatBox.scrollTop = chatBox.scrollHeight;
}
