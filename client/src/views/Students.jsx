import React, { Component } from "react";
import { Grid, Row, Col, Table } from "react-bootstrap";
import Card from "components/Card/Card.jsx";
import axios from "axios";
import InfoAlumno from "views/InfoAlumno";
const titulosArray = ["Surname", "Name", "Phone", ""];

class FilaStudent extends React.Component {
  /** --- Link para Info del Student ---  */
  render() {
    const student = this.props.student;
    return (
      <tr id="infoAlum" key={student.id}>
        <td>{student.surname}</td>
        <td>{student.name}</td>
        <td>{student.tel_principal}</td>
        <td >{this.props.children}</td>
      </tr>
    );
  }
}


class Students extends Component {
  constructor(props) {
    super(props);
    this.state = {
      students: [],
      mostrarPanelDeAlumno: false,
      alumnoActual: null,
      paymentsAlumnoActual: [],
      agregaPayment: false,
      panelAlumnos: true,
      tamanioPanel: "col-md-12"
    }
  }

  componentDidMount() {
    this.getStudents();
  }
  recargado() {
    this.getStudents();
  }
  getStudents() {
    let self = this;
    return axios
      .get("/student/findAll")
      .then(function (response) {
        console.log(response.data[0]);
        const listStudent = response.data;
        self.setState({
          students: listStudent
        })
        return Promise.resolve(listStudent);
      })
      .catch(function (error) {
        console.log(error);
      });
  }
  getPayments(student) { }


  botones(estudiante) {
    return (

      <div class="btn-group"
        style={{
          marginRight: "10px",
          textAlign: "center"
        }}>
        {this.botonAddPago(estudiante)}
        {this.botonDetalle(estudiante)}
      </div>
    );
  }
  botonStandard(label, accion, clasesAdicionales, glyphIcon) {
    return (
      <button
        className={"btn btn-fill " + clasesAdicionales}
        style={{
          marginRight: "4px",
          paddingRight: "100px",
          textAlign: "center"
        }}
        onClick={() => accion()}
      >
        <span className={"fa " + glyphIcon}> {label} </span>
      </button>
    );
  }
  mostrarAddPago(student) {
  }
  mostrarDatosAlumno(student) {
    this.setState({
      mostrarPanelDeAlumno: true,
      alumnoActual: student,
      agregarPayment: false,
      tamanioPanel: "col-md-6"
    });
    this.getPayments(student)
  }

  botonAddPago(estudiante) {
    return this.botonStandard(
      "Add Payment ",
      () => this.mostrarAddPago(estudiante),
      "btn-primary btn-xs",
      "fa-money"
    );
  }
  botonDetalle(estudiante) {
    return this.botonStandard(
      "Info ",
      () => this.mostrarDatosAlumno(estudiante),
      "btn-info btn-xs",
      "fa-info"
    );
  }
  mostrarAlumnos(panelInfo) {
    return (
      <div>
        <div class="row">
          <div class={this.state.tamanioPanel}>
            <Card
              title="Complete list of students"
              ctTableFullWidth
              ctTableResponsive
              content={
                <Table striped hover>
                  <thead>
                    <tr>
                      {titulosArray.map((prop, key) => {
                        return <th key={key}>{prop}</th>;
                      })}
                    </tr>
                  </thead>
                  <tbody>
                    {this.state.students.map(stu => (
                      <FilaStudent student={stu}>{this.botones(stu)}</FilaStudent>
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
      </div>
    )
  }

  cerrarInfoAlumno() {
    this.setState({
      mostrarPanelDeAlumno: false,
      agregarNota: false,
      tamanioPanel: "col-md-12"
    });
  }

  render() {
    let panelInfo = null;
    if (this.state.mostrarPanelDeAlumno) {
      if (this.state.agregarPayment) {
        // panelInfo = (
        //   <div id="AddMark">
        //     <AddMark
        //       idCourse={this.curso.id}
        //       data={this.state.alumnoActual}
        //       screen={() => this.cerrarInfoAlumno()}
        //       agregarNota={this.state.agregarNota}
        //       recargado={() => this.recargadoNotas()}
        //       volver={(estudiante) => this.mostrarDatosAlumno(estudiante)}
        //     />
        //   </div>
        // );
      }
      else {
        panelInfo = (
          <div id="InfoAlumno">
            <InfoAlumno
              //idCourse={this.curso.id}
              data={this.state.alumnoActual}
              screen={() => this.cerrarInfoAlumno()}
              agregarNota={this.state.agregarNota}
              recargado={() => this.recargado()}
              
              //modificar esto por listado con los pagos...
              //guardarMarks={() => this.guardarMarks()}
              payments={[]}
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
              {this.mostrarAlumnos(panelInfo)}
            </div>{" "}
          </div>{" "}
        </div>{" "}
      </div>
    );
  }
}

export default Students;
