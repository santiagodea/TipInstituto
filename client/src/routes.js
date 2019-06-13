import Home from "views/Home.jsx";
import Courses from "views/Courses.jsx";
import NewCourse from "views/NewCourse";
import Students from "views/Students.jsx";
import Abouts from "views/Abouts.jsx";
import Icons from "views/Icons.jsx";
import Maps from "views/Maps.jsx";
import Notifications from "views/Notifications.jsx";
import Upgrade from "views/Upgrade.jsx";
import { Route, Switch, Redirect } from "react-router-dom";


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
  {
    redirect: "/newCourse",
    name: "NewCourse",
    //icon: "pe-7s-science",
    component: NewCourse,
    layout: "/admin"
  }
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
];

export default dashboardRoutes;
