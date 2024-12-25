const express = require('express');
const cors = require('cors');
const http = require('http');
const socketIo = require('socket.io');
const app = express();
const server = http.createServer(app);
const io = socketIo(server, {
    cors: {
        origin: 'http://localhost:3000', // 리액트 앱의 주소
        methods: ['GET', 'POST'],
        allowedHeaders: ['Content-Type'],
    }
});

app.use(cors({
    origin: 'http://localhost:3000', // 리액트 앱의 주소
    methods: ['GET', 'POST'],
    allowedHeaders: ['Content-Type'],
}));

// WebSocket 연결 처리
io.on('connection', (socket) => {
    console.log('client connected:', socket.id);

    // 클라이언트로부터 'message' 이벤트를 받을 때
    socket.on('message', (data) => {
        console.log('Received message from client:', data);

        // 클라이언트에게 메시지 전송
        socket.emit('message', { message: 'Hello from server!' });
    });

    // 연결 종료 시
    socket.on('disconnect', () => {
        console.log('client disconnected:', socket.id);
    });
});

server.listen(80, () => {
    console.log('Server is running on port 80');
});
