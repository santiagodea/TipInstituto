import React, { Component } from "react";
import {
  Grid,
  Row,
  Col,
  FormGroup,
  ControlLabel,
  FormControl
} from "react-bootstrap";

import { Card } from "components/Card/Card.jsx";
import { FormInputs } from "components/FormInputs/FormInputs.jsx";
import Button from "components/CustomButton/CustomButton.jsx";

class NewCourse
 extends Component {

  constructor(props) {
    super(props);
    this._curso = this.props.curso;
    this.state = {
      nombre:  "",
      nivel:  "",
      turno:  "",
      profesor:  "",
      formErrors: {},
      niveles: [1,2,3,4,5],
      turnos:["maniana","tarde","noche"]
    };
  }

  llenarCurso(curso){
    this.setState({
      _curso: curso,
      id: curso._id,
      nombre: curso._nombre,
      nivel: curso._nivel,
      turno: curso._turno,
      profesor: curso._profesor,
    });
  }

  manejarSeleccionTurnos(event) {
    this.setState({ turno: event.target.value });
  }
  manejarSeleccionNivel(event) {
    this.setState({ nivel: event.target.value })
  }


  desplegar(collect) {
    return collect.map(c => (
      <option key={c} value={c}>
        {c}
      </option>
    ));
  }

  render() {
    return (
      <div className="content">
        <Grid fluid>
          <Row>
            <Col md={8}>
              <Card
                title="New Course"
                content={
                  <form>
                    <FormInputs
                      ncols={["col-md-5"]}
                      properties={[
                        {
                          label: "Name",
                          type: "text",
                          bsClass: "form-control",
                          placeholder: "name",
                          value: this.state.nombre,
                          onChange: event => this.setState({nombre: event.target.value}),
                          defaultValue: "Course name",
                          disabled: false
                        }
                      ]}
                    />
                    <div className="col-md-5">
                    <label htmlFor="level"> Level: </label>
                      <select
                          label= "nivel"
                          className="form-control"
                          onChange={this.manejarSeleccionNivel.bind(this)}
                          id="niveles"
                        >
                          {this.desplegar(this.state.niveles)}
                      </select>
                    </div>
                    <div className="col-md-5">
                    <label htmlFor="turno"> Duty: </label>
                      <select
                          label= "turno"
                          className="form-control"
                          onChange={this.manejarSeleccionTurnos.bind(this)}
                          id="turno"
                        >
                          {this.desplegar(this.state.turnos)}
                      </select>
                    </div>
                    <div className="col-md-5">
                    <label htmlFor="turno"> Teacher: </label>
                      <select
                          label= "turno"
                          value={this.state.turnos}
                          className="form-control"
                          //onChange={this.manejarSeleccion.bind(this,this.state.turnos)}
                          id="turno"
                        >
                          {this.desplegar(this.state.turnos)}
                      </select>
                      </div>
                    <Button bsStyle="info" pullRight fill type="submit">
                      Save
                    </Button>
                    <div className="clearfix" />
                  </form>
                }
              />
            </Col>
            <Col md={4}>
            </Col>
          </Row>
        </Grid>
      </div>
    );
  }
}

export default NewCourse;
