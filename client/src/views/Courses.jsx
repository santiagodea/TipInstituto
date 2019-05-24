import React, { Component } from "react";
import ChartistGraph from "react-chartist";
import { Grid, Row, Col } from "react-bootstrap";

import { Card } from "components/Card/Card.jsx";
import { StatsCard } from "components/StatsCard/StatsCard.jsx";
import { Tasks } from "components/Tasks/Tasks.jsx";
import {
  dataPie,
  legendPie,
  dataSales,
  optionsSales,
  responsiveSales,
  legendSales,
  dataBar,
  optionsBar,
  responsiveBar,
  legendBar
} from "variables/Variables.jsx";
import { createTypeQueryNode } from "typescript";

class Courses extends Component {
  createLegend(json) {
    var legend = [];
    for (var i = 0; i < json["names"].length; i++) {
      var type = "fa fa-circle text-" + json["types"][i];
      legend.push(<i className={type} key={i} />);
      legend.push(" ");
      legend.push(json["names"][i]);
    }
    return legend;
  }

  tarjetaCursos(nombre, nivel, turno){
    return(
      <div>
        <Col lg={3} sm={6}>
              <StatsCard
                //bigIcon={<i className="pe-7s-cash text-danger" />}
                statsText={nombre}
                statsValue={nivel}
                //statsIcon={<i className="fa fa-refresh" />}
                statsIconText={turno}
              />
            </Col>
      </div>
    )
  }

  render() {
    return (
      <div className="content">
        <Grid fluid>
          <Row>

            {this.tarjetaCursos("Pre Kinder", 0, "Late Shift")}
            {this.tarjetaCursos("Kinder", 1, "Shift Tomorrow")}

          </Row>
          <Row>
            <Col md={8}>
            </Col>
            <Col md={4}>
            </Col>
          </Row>

          <Row>
            <Col md={6}>
            </Col>

            <Col md={6}>
            </Col>
          </Row>
        </Grid>
      </div>
    );
  }
}

export default Courses;
