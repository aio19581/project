const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
    app.use(
        '/socket',
        createProxyMiddleware({
            target: "http://localhost:80", // 백엔드 서버 주소
            changeOrigin: true,             // CORS 문제 해결
            secure: false,
        })
    );
};