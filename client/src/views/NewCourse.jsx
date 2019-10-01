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
const axios = require("axios");


const { AceptarYCancelar } = require("../components/Varios/botones.jsx");

class NewCourse
  extends Component {

  constructor(props) {
    super(props);
    this._curso = this.props.curso;
    this.state = {
      name: "",
      level: 1,
      shift: "tomorrow",
      teacher: "",
      startTime: 8.00,
      formErrors: {},
      niveles: [1, 2, 3, 4, 5],
      turnos: ["tomorrow", "afternoon", "night"],
      //la idea es dependiendo del turno que ponga desplegar una lista con posibles horarios de entrada al cuerso.
      horariosMan: [8.00, 8.30, 9.00, 9.30, 10.00, 10.30, 11.00, 11.30, 12.00, 12.30],
      horariosTar: [13.00, 13.30, 14.00, 14.30, 15.00, 16.30, 17.00, 17.30, 18.00, 18.30, 19.00, 19.30],
      horariosNoch: [20.00, 20.30, 21.00, 21.30, 22.00, 22.30, 23.00, 23.30]
    };
  }

  llenarCurso(curso) {
    this.setState({
      _curso: curso,
      id: curso._id,
      name: curso._name,
      level: curso._level,
      shift: curso._shift,
      teacher: curso._teacher,
    });
  }

  guardarCurso(alert) {
    let self = this;
    const course = {
      name: this.state.name,
      level: this.state.level,
      shift: this.state.shift,
      teacher: this.state.teacher,
      startTime: this.state.startTime
    };
    axios
      .post("/course", course)
      .then(function (res) {
        console.log("The new Course was successfully created.");
        self.props.recargado();
      })
      .catch(function (error) {
        console.log("ERROR - " + error);
      });
      self.props.onCancel();
  }

  cancelarAgregado() {
    this.props.onCancel();
  }

  cancelar() {
    this.props.onCancel();
  }

  manejarSeleccionTurnos(event) {
    this.setState({ shift: event.target.value });
  }
  manejarSeleccionNivel(event) {
    this.setState({ level: event.target.value })
  }
  manejarSeleccionHorarios(event) {
    this.setState({ startTime: event.target.value });
  }


  desplegar(collect) {
    return collect.map(c => (
      <option key={c} value={c}>
        {c}
      </option>
    ));
  }

  desplegarHoras(string) {
    let collect = [];
    if (string == "tomorrow"){collect = this.state.horariosMan}
    else if (string == "afternoon"){collect = this.state.horariosTar}
    else {{collect = this.state.horariosNoch}}
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
                          placeholder: "Name Course",
                          value: this.state.nombre,
                          onChange: event => this.setState({ name: event.target.value }),
                          defaultValue: " ",
                          disabled: false
                        }
                      ]}
                    />
                    <div className="col-md-5">
                      <label htmlFor="level"> Level: </label>
                      <select
                        label="nivel"
                        className="form-control"
                        onChange={this.manejarSeleccionNivel.bind(this)}
                        defaultValue="1"
                        id="niveles"
                      >
                        {this.desplegar(this.state.niveles)}
                      </select>
                    </div>
                    <div className="col-md-5">
                      <label htmlFor="turno"> Duty: </label>
                      <select
                        label="turno"
                        className="form-control"
                        onChange={this.manejarSeleccionTurnos.bind(this)}
                        id="turno"
                      >
                        {this.desplegar(this.state.turnos)}
                      </select>
                    </div>
                    <div className="col-md-8">
                      <FormInputs
                        ncols={["col-md-10"]}
                        properties={[
                          {
                            label: "Teacher",
                            type: "text",
                            bsClass: "form-control",
                            placeholder: "Name Teacher",
                            value: this.state.profesor,
                            onChange: event => this.setState({ teacher: event.target.value }),
                            defaultValue: "",
                            disabled: false
                          }
                        ]}
                      />
                    </div>
                    <div className="col-md-2">
                      <label htmlFor="turno"> Start Time: </label>
                      <select
                        label="starttime"
                        className="form-control"
                        onChange={this.manejarSeleccionHorarios.bind(this)}
                        id="starttime"
                      >
                        {this.desplegarHoras(this.state.shift)}
                      </select>
                    </div>
                    <div className="clearfix" />
                  </form>
                }
              />
              <AceptarYCancelar
                acceptText={"Save Course"}
                cancelText={"Calcel"}
                cancelar={() => this.cancelar()}
                aceptar={() => this.guardarCurso()}
              >
              </AceptarYCancelar>
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

//export  default EditCourse;
