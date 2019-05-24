import Home from "views/Home.jsx";
import Courses from "views/Courses.jsx";
import Students from "views/Students.jsx";
import Abouts from "views/Abouts.jsx";
import Icons from "views/Icons.jsx";
import Maps from "views/Maps.jsx";
import Notifications from "views/Notifications.jsx";
import Upgrade from "views/Upgrade.jsx";

const dashboardRoutes = [
  {
    path: "/home",
    name: "Index",
    icon: "pe-7s-note2",
    component: Home,
    layout: "/admin"
  },
  {
    path: "/courses",
    name: "Courses",
    icon: "pe-7s-notebook",
    component: Courses,
    layout: "/admin"
  },
  {
    path: "/students",
    name: "Students",
    icon: "pe-7s-users",
    component: Students,
    layout: "/admin"
  },
  {
    path: "/abouts",
    name: "Abouts Us",
    icon: "pe-7s-info",
    component: Abouts,
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
