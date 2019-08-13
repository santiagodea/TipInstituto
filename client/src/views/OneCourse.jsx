import React, { Component } from "react";
import { Grid, Row, Col, Table } from "react-bootstrap";
import Card from "components/Card/Card.jsx";


//const infoAlumno = require("views/InfoAlumno");
import InfoAlumno from "views/InfoAlumno";

const { Alert } = require("react-alert");
const { AceptarYCancelar } = require("../components/Varios/botones.jsx");
const thArray = ["Surname", "Name", " "];



class FilaAlumno extends React.Component {
  /** --- Link para Info del Alumno ---  */
  render() {
    const alumno = this.props.alumno;
    return (
      <tr id="infoAlum" key={alumno._dni}>
        <td>{alumno.apellido}</td>
        <td>{alumno.nombre}</td>
        <td >{this.props.children}</td>
      </tr>
    );
  }
}

class OneCourse extends Component {

  constructor(props) {
    super(props);
    this.curso = this.props.curso;
    this.state = {
      nombre: "",
      nivel: "",
      turno: "",
      profesor: "",
      formErrors: {},
      niveles: [1, 2, 3, 4, 5],
      turnos: ["maniana", "tarde", "noche"],
      listaDeAlumnos: [],
      mostrarPanelDeAbajo: false,
      alumnoActual: null,
      agregaNota: false
    };
  }

  componentDidMount() {
    this.llenarCurso(this.curso)
  }

  llenarCurso(curso) {
    var a1 = {
      nombre: "Lucas",
      apellido: "Pratto",
    }
    var a2 = {
      nombre: "Leonardo",
      apellido: "Ponzio",
    }
    var a3 = {
      nombre: "Pity",
      apellido: "Martinez",
    }
    var a4 = {
      nombre: "Javier",
      apellido: "Pinola",
    }
    var a5 = {
      nombre: "Juan Fernando",
      apellido: "Quintero",
    }
    var a6 = {
      nombre: "Enzo",
      apellido: "Perez",
    }
    var a7 = {
      nombre: "Franco",
      apellido: "Armani",
    }
    var a8 = {
      nombre: "Lucas",
      apellido: "Martinez Quarta",
    }
    var alumnos_aux = [a1, a2, a3, a4, a5, a6, a7, a8];

    this.setState({
      curso: curso,
      id: curso.id,
      nombre: curso.nombre,
      nivel: curso.nivel,
      turno: curso.turno,
      profesor: curso.profesor,
      listaDeAlumnos: alumnos_aux
    });
  }

  manejarSeleccionTurnos(event) {
    this.setState({ turno: event.target.value });
  }
  manejarSeleccionNivel(event) {
    this.setState({ nivel: event.target.value })
  }

  /** ---   Botones   --- */
  botones(estudiante) {
    return (

      <div class="btn-group"
        style={{
          marginRight: "10px",
          textAlign: "center"
        }}>
        {this.botonDetalle(estudiante)}
        {this.botonNota(estudiante)}
        {this.botonEliminar(estudiante)}
      </div>
    );
  }
  botonDetalle(estudiante) {
    return this.botonStandard(
      "Info ",
      () => this.mostrarDatosAlumno(estudiante),
      "btn-primary btn-xs",
      "fa-info"
    );
  }

  botonEliminar(estudiante) {
    return this.botonStandard(
      "Delete",
      alert => this.eliminarAlumno(estudiante, alert),
      "btn-danger btn-xs",
      "fa-close"
    );
  }

  botonNota(estudiante) {
    return this.botonStandard(
      "Add Mark",
      () => this.agregarNota(estudiante),
      "btn-success btn-xs",
      "fa-plus"
    );
  }
  botonStandard(label, accion, clasesAdicionales, glyphIcon) {
    return (
      <Alert>
        {alert => (
          <button
            className={"btn btn-fill " + clasesAdicionales}
            style={{
              marginRight: "5px",
              paddingRight: "100px",
              textAlign: "center"
            }}
            onClick={() => accion(alert)}
          >
            <span className={"fa " + glyphIcon}> {label} </span>
          </button>
        )}
      </Alert>
    );
  }

  agregarEstudiante() {

  }
  imprimirListado() {

  }
  agregarNota(estudiante) {
    this.setState({
      mostrarPanelDeAbajo: true,
      alumnoActual: estudiante,
      agregarNota : true
    });
  }

  cancelar() {
    this.props.onCancel();
  }

  eliminarAlumno(estudiante, alert) {

  }
  mostrarDatosAlumno(estudiante) {
    this.setState({
      mostrarPanelDeAbajo: true,
      alumnoActual: estudiante,
      agregarNota : false
    });
  }
  cerrarInfoAlumno() {
    this.setState({ mostrarPanelDeAbajo: false });
  }


  render() {
    let panelDeAbajo = null;
    if (this.state.mostrarPanelDeAbajo) {
      // acá le paso el Alumno a la pantalla de InfoPersona
      panelDeAbajo = (
        <div id="InfoAlumno">
          <InfoAlumno
            data={this.state.alumnoActual}
            screen={() => this.cerrarInfoAlumno()}
            agregarNota={this.state.agregarNota}
          />
        </div>
      );
    }


    return (
      <div>
        <div className="card mb-8 mt-2">
          <div className="form-group">
            <div className="col-md-12">
              <h1>
                {" "}
                <b> {this.state.nombre}</b>
                {" "}
              </h1>{" "}
              <div class="row">
                <div class="col-xs-6 col-md-4"><h4>Level: <b> {this.state.nivel}</b></h4></div>
                <div class="col-xs-6 col-md-4"><h4>Duty: <b> {this.state.turno}</b></h4></div>
                <div class="col-xs-6 col-md-4"><h4>Teacher: <b> {this.state.profesor} </b></h4></div>
              </div>

              <div class="row">
                <div class="col-md-8">
                  <Card
                    title="List of students"
                    ctTableFullWidth
                    ctTableResponsive
                    content={
                      <Table striped hover>
                        <thead>
                          <tr>
                            {thArray.map((prop, key) => {
                              return <th key={key}>{prop}</th>;
                            })}
                          </tr>
                        </thead>
                        <tbody>
                          {this.state.listaDeAlumnos.map(alum => (
                            <FilaAlumno alumno={alum}>{this.botones(alum)}</FilaAlumno>
                          ))}
                        </tbody>

                      </Table>
                    }
                  />
                </div>

                <div class="col-md-4">
                  {panelDeAbajo}
                </div>
              </div>

            </div>{" "}

            <div class="col-xs-6 col-md-4">
              <a class="btn btn-fill btn-danger" onClick={() => this.cancelar()}>Back</a>
            </div>
            <div class="col-xs-6 col-md-4">
              <a class="btn btn-fill btn-success" onClick={() => this.agregarEstudiante()}>Add Student</a>
            </div>
            <div class="col-xs-6 col-md-4">
              <a class="btn btn-fill btn-primary" onClick={() => this.imprimirListado()}>Print List</a>
            </div>
          </div>{" "}
        </div>{" "}
      </div>
    );
  }
}

export default OneCourse;
