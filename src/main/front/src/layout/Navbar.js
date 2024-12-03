import {Navbar} from "reactstrap";
import {NavLink} from "react-router-dom";

const Navbar = () => {
    return(
        <Navbar>
            <div>
                <NavLink to="/info/*">
                    축제정보
                </NavLink>
            </div>
            <div>
                <NavLink to="/map/*">
                    지도
                </NavLink>
            </div>
            <div>
                <NavLink to="/community/*">
                    커뮤니티
                </NavLink>
            </div>
        </Navbar>
    );
}
export default Navbar;