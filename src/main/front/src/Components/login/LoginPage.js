import {Alert, Button, Card, Col, FloatingLabel, Form, Row} from "react-bootstrap";
import style from "../../css/login.module.css";
import {Link} from "react-router-dom";
import {useState} from "react";
import axios from "axios";

const LoginPage = () => {
    const [userData, setUserData] = useState({});
    const [alertShow, setAlertShow] = useState(false);
    const [alertText, setAlertText] = useState('');

    const checkId = (e) => {
        if(e.target.value === '') {
            setAlertText('※ 아이디를 입력하세요.');
            setAlertShow(true);
        } else {{
            setUserData({[e.target.id]:e.target.value});
            setAlertShow(false);
        }}
    }

    const checkPw = (e) => {
        if(e.target.value === '') {
            setAlertText('※ 비밀번호를 입력하세요.');
            setAlertShow(true);
        } else {{
            setUserData({[e.target.id]:e.target.value});
            setAlertShow(false);
        }}
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('/loginProcess', userData)
            .then(res => {

            })
            .catch();

    }

    return(
        <>
        <Card className={style.body}>
            <Card.Title className={style.cardTitle}>
                <h3>LOGIN</h3>
            </Card.Title>
            <Card.Body>
                <Form onSubmit={handleSubmit}>
                    <FloatingLabel label="ID" className="mb-3">
                        <Form.Control type="text" name="userid" id="userid" onBlur={checkId}/>
                    </FloatingLabel>

                    <FloatingLabel label="Password" className="mb-3">
                        <Form.Control type="text" name="userpw" id="userpw" onBlur={checkPw}/>
                    </FloatingLabel>

                    <Alert variant="light" show={alertShow} transition={false}
                        className={style.alert}>{alertText}</Alert>

                    <div className="d-grid gap-2">
                        <Button type="submit" variant="outline-primary">로그인</Button>
                    </div>
                </Form>
            </Card.Body>
        </Card>
        <Row className={style.row}>
            <Col className={style.col1}>
                <Link to="/" >아이디/비밀번호 찾기</Link>
            </Col>
            <Col className={style.col2}>
                <Link to="/">회원가입</Link>
            </Col>
        </Row>
        </>
    );
}
export default LoginPage;