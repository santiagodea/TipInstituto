import React, { Component } from "react";
import { Grid, Row, Col, Table } from "react-bootstrap";
import Card from "components/Card/Card.jsx";
import axios from "axios";
const titulosArray = ["Surname", "Name", "Phone", "Course", "Payment"];

class FilaStudent extends React.Component {
  /** --- Link para Info del Student ---  */
  render() {
    const student = this.props.student;
    return (
      <tr id="infoAlum" key={student.id}>
        <td>{student.surname}</td>
        <td>{student.name}</td>
        <td>{student.tel_principal}</td>
        <td>{}</td>
        <td >{this.props.children}</td>
      </tr>
    );
  }
}


class Students extends Component {
  constructor(props) {
    super(props);
    this.state = {
      students: []
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
              marginRight: "5px",
              paddingRight: "100px",
              textAlign: "center"
            }}
            onClick={() => accion()}
          >
            <span className={"fa " + glyphIcon}> {label} </span>
          </button>
    );
  }
  mostrarAddPago(estudiante){}
  mostrarDatosAlumno(student){}

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

  render() {
    return (
      <div className="content">
        <Grid fluid>
          <Row>
            <Col md={12}>
              <Card
                title="Complete list of students"
                category=""
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
            </Col>

          </Row>
        </Grid>
      </div>
    );
  }
}

export default Students;
