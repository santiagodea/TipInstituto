import Home from "views/Home.jsx";
import UserProfile from "views/UserProfile.jsx";
import TableList from "views/TableList.jsx";
import Typography from "views/Typography.jsx";
import Icons from "views/Icons.jsx";
import Maps from "views/Maps.jsx";
import Notifications from "views/Notifications.jsx";
import Upgrade from "views/Upgrade.jsx";

const dashboardRoutes = [
  {
    path: "/home",
    name: "Home",
    icon: "pe-7s-graph",
    component: Home,
    layout: "/admin"
  },
  {
    path: "/user",
    name: "Courses",
    icon: "pe-7s-notebook",
    component: UserProfile,
    layout: "/admin"
  },
  {
    path: "/table",
    name: "Students",
    icon: "pe-7s-users",
    component: TableList,
    layout: "/admin"
  },
  {
    path: "/typography",
    name: "Abouts us",
    icon: "pe-7s-info",
    component: Typography,
    layout: "/admin"
  },
  // {
  //   path: "/icons",
  //   name: "Icons",
  //   icon: "pe-7s-science",
  //   component: Icons,
  //   layout: "/admin"
  // },
  // {
  //   path: "/maps",
  //   name: "Maps",
  //   icon: "pe-7s-map-marker",
  //   component: Maps,
  //   layout: "/admin"
  // },
  // {
  //   path: "/notifications",
  //   name: "Notifications",
  //   icon: "pe-7s-bell",
  //   component: Notifications,
  //   layout: "/admin"
  // },
  {
    upgrade: true,
    path: "/upgrade",
    name: "Upgrade to PRO",
    icon: "pe-7s-rocket",
    component: Upgrade,
    layout: "/admin"
  }
];

export default dashboardRoutes;
