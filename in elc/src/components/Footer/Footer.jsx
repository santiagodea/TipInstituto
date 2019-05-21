import React, { Component } from "react";
import { Grid } from "react-bootstrap";

class Footer extends Component {
  render() {
    return (
      <footer className="footer">
        <Grid fluid>
          <nav className="pull-left">
            <ul>
              <li>
                <a href="#pablo">Home</a>
              </li>
              <li>
                <a href="#pablo">Students</a>
              </li>
              <li>
                <a href="#pablo">Courses</a>
              </li>
              <li>
                <a href="#pablo">about us</a>
              </li>
            </ul>
          </nav>
          <p className="copyright pull-right">
            Made by Santiago to CIU
          </p>
        </Grid>
      </footer>
    );
  }
}

export default Footer;
