const mariadb = require('mariadb');

const pool = mariadb.createPool({
    host: 'localhost',
    port: 3306,
    user: 'root',
    password: '1111',
    database: 'pjtest',
    connectionLimit: 100,
});

module.exports = {
    async run(query){
        return new Promise((resolve)=>{
            pool.getConnection()
                .then(conn => {
                    conn.query(query)
                    .then((rows) => {
                        resolve(rows);
                        conn.end();
                    })
                    .catch(err => {
                        console.log(err);
                        conn.end();
                    })
                }).catch(err => {
            });
        });
    }
}