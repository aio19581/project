import {createBrowserRouter} from "react-router-dom";
import Layout from "../layout/Layout";
import MapPage from "../Components/map/MapPage";
import MainPage from "../Components/main/MainPage";
import InfoPage from "../Components/info/InfoPage";
import CommunityPage from "../Components/community/CommunityPage";
import LoginPage from "../Components/login/LoginPage";

const router = createBrowserRouter([
    {
        path:"",
        element:<Layout />,
        children:[
            {
                path:"",
                element:<MainPage />
            },
            {
                path:"map",
                element:<MapPage />
            },
            {
                path:"info",
                element:<InfoPage />
            },
            {
                path:"community",
                element:<CommunityPage />
            },
            {
                path:"login",
                element:<LoginPage />
            }
        ]
    }
])
export default router;