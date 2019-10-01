import React from "react";
import ReactDOM from "react-dom";

import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";
import "./assets/css/animate.min.css";
import "./assets/sass/light-bootstrap-dashboard-react.scss?v=1.3.0";
import "./assets/css/demo.css";
import "./assets/css/pe-icon-7-stroke.css";
import axios from "axios";
//import proxyApi from "./forBuild/proxyApi.js";


import AdminLayout from "layouts/Admin.jsx";
axios.defaults.baseURL = 'http://localhost:8080'; //si esta en prod. va proxyApi;

ReactDOM.render(
  <BrowserRouter>
    <Switch>
      <Route path="/admin" render={props => <AdminLayout {...props} />} />
      <Redirect from="/" to="/admin/home" />
    </Switch>
  </BrowserRouter>,
  document.getElementById("root")
);
