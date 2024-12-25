module.exports = (io) => {
    io.on("connection", (socket) => {
        console.log("client is connected", socket.id);

        // 클라이언트와의 메시지 이벤트 처리
        socket.on("message", (data) => {
            console.log("received message:", data);
            // 클라이언트에게 응답 메시지 전송
            socket.emit("message", { message: "Hello from server!" });
        });

        // 연결 종료 처리
        socket.on("disconnect", () => {
            console.log("client disconnected", socket.id);
        });
    });
};
