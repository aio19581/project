import {Link} from "react-router-dom";

const Header = () => {

    return(
        <header>
            로고
            <Link to="/login">로그인</Link>
        </header>
    );
}
export default Header;