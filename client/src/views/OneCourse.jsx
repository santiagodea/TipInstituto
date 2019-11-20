import React, { Component } from "react";
import { Grid, Row, Col, Table } from "react-bootstrap";
import Card from "components/Card/Card.jsx";


//const infoAlumno = require("views/InfoAlumno");
import InfoAlumno from "views/InfoAlumno";
import NewStudent from "views/NewStudent";
import AddMark from "views/AddMark";
//import { addListener } from "cluster";
const axios = require("axios");

const { Alert } = require("react-alert");
const { AceptarYCancelar } = require("../components/Varios/botones.jsx");
const thArray = ["Surname", "Name", " "];


class FilaAlumno extends React.Component {
  /** --- Link para Info del Alumno ---  */
  render() {
    const alumno = this.props.alumno;
    return (
      <tr id="infoAlum" key={alumno._dni}>
        <td>{alumno.surname}</td>
        <td>{alumno.name}</td>
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
      scId:"",
      nombre: "",
      nivel: "",
      turno: "",
      profesor: "",
      formErrors: {},
      niveles: [1, 2, 3, 4, 5],
      turnos: ["maniana", "tarde", "noche"],
      students: [],
      mostrarPanelDeAlumno: false,
      alumnoActual: null,
      marksAlumnoActual: [],
      agregaNota: false,
      panelAlumnos: true,
      panelNuevoAlumno: false,
      tamanioPanel:"col-md-12"
    };
  }

  componentDidMount() {
    this.llenarCurso(this.curso);
    this.getDataCourse();
  }

  getDataCourse() {
    let self = this;
    return axios
      .get("/course/findByIdWithStudents/" + this.curso.id)
      .then(function (response) {
        const listaDeS = response.data.studentListDTO;
        self.setState({
          students: listaDeS
        })
        return Promise.resolve(listaDeS);
      })
      .catch(function (error) {
        console.log(error);
      });
  }


  recargado() {
    this.getDataCourse();
    this.setState({
      agregaNota: false,
      panelAlumnos: true,
      panelNuevoAlumno: false
    })

  }

  llenarCurso(curso) {
    this.setState({
      curso: curso,
      id: curso.id,
      nombre: curso.name,
      nivel: curso.level,
      turno: curso.shift,
      profesor: curso.teacher,
      panelAlumnos: true,
      panelNuevoAlumno: false
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
          marginRight: "6px",
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
              marginRight: "4px",
              paddingRight: "50px",
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
    this.setState({
      panelAlumnos: false,
      panelNuevoAlumno: true
    });
  }
  cancelarNuevoAlumno() {
    this.setState({
      panelAlumnos: true,
      panelNuevoAlumno: false
    });
  }
  mostrarNuevoStudent() {
    if (this.state.panelNuevoAlumno) {
      return (
        <div>
          <NewStudent
            onCancel={() => this.cancelarNuevoAlumno()}
            recargado={() => this.recargado()}
            course={this.curso}
          />
        </div>
      )
    }
  }
  mostrarAlumnos(panelInfo) {
    // if (this.state.tarjetaDeCursos) {

    return (
      <div>
        <div class="row">
          <div class= {this.state.tamanioPanel}>
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
                    {this.state.students.map(alum => (
                      <FilaAlumno alumno={alum}>{this.botones(alum)}</FilaAlumno>
                    ))}
                  </tbody>
                </Table>
              }
            />
          </div>

          <div class="col-md-6">
            {panelInfo}
          </div>

        </div>

        <div class="row">
          <div class="col-xs-6 col-md-4">
            <a class="btn btn-fill btn-danger" onClick={() => this.cancelar()}>Back</a>
          </div>
          <div class="col-xs-6 col-md-4">
            <a class="btn btn-fill btn-success" onClick={() => this.agregarEstudiante()}>Add Student</a>
          </div>
          <div class="col-xs-6 col-md-4">
            <a class="btn btn-fill btn-primary" onClick={() => this.imprimirListado()}>Print List</a>
          </div>
        </div>

      </div>
    );
    // }
  }


  alumnosONuevoAlumno(panelInfo) {
    if (this.state.panelAlumnos) {
      return this.mostrarAlumnos(panelInfo);
    } else {
      return this.mostrarNuevoStudent();
    }
  }

  mostrarListado() {

  }


  imprimirListado() {

  }

  cancelar() {
    this.props.onCancel();
  }

  eliminarAlumno(estudiante, alert) {

  }
  mostrarDatosAlumno(estudiante) {
    this.setState({
      mostrarPanelDeAlumno: true,
      alumnoActual: estudiante,
      agregarNota: false,
      tamanioPanel:"col-md-6"
    });
  }
  agregarNota(estudiante) {
    this.setState({
      mostrarPanelDeAlumno: true,
      alumnoActual: estudiante,
      agregarNota: true,
      tamanioPanel:"col-md-6"
    });
  }
  cerrarInfoAlumno() {
    this.setState({
      mostrarPanelDeAlumno: false,
      agregarNota: false,
      tamanioPanel:"col-md-12"
    });
  }
  guardarMarks(marks){
    this.setState({marksAlumnoActual: marks});
  }

  render() {
    let panelInfo = null;
    if (this.state.mostrarPanelDeAlumno) {
      // acá le paso el Alumno a la pantalla de InfoPersona
      if (this.state.agregarNota) {
        panelInfo = (
          <div id="AddMark">
            <AddMark
              idCourse={this.curso.id}
              data={this.state.alumnoActual}
              screen={() => this.cerrarInfoAlumno()}
              agregarNota={this.state.agregarNota}
              recargado={() => this.recargado()}
            />
          </div>
        );
      }
      else {
        panelInfo = (
          <div id="InfoAlumno">
            <InfoAlumno
              idCourse={this.curso.id}
              data={this.state.alumnoActual}
              screen={() => this.cerrarInfoAlumno()}
              agregarNota={this.state.agregarNota}
              recargado={() => this.recargado()}
              guardarMarks={() => this.guardarMarks()}
              marksAA={this.state.marksAlumnoActual}
            />
          </div>
        );
      }
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

              {this.alumnosONuevoAlumno(panelInfo)}

            </div>{" "}

          </div>{" "}
        </div>{" "}
      </div>
    );
  }
}

export default OneCourse;
