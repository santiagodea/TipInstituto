import React, { Component } from "react";
import { Grid, Row, Col, Table } from "react-bootstrap";
import Card from "components/Card/Card.jsx";

const { AceptarYCancelar } = require("../components/Varios/botones.jsx");
const thArray = ["ID", "Name", "Salary", "Country", "City"];
    const tdArray = [
      ["1", "Dakota Rice", "$36,738", "Niger", "Oud-Turnhout"],
      ["2", "Minerva Hooper", "$23,789", "Curaçao", "Sinaai-Waas"],
      ["3", "Sage Rodriguez", "$56,142", "Netherlands", "Baileux"],
      ["4", "Philip Chaney", "$38,735", "Korea, South", "Overland Park"],
      ["5", "Doris Greene", "$63,542", "Malawi", "Feldkirchen in Kärnten"],
      ["6", "Mason Porter", "$78,615", "Chile", "Gloucester"]
    ];

class OneCourse
  extends Component {

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
      turnos: ["maniana", "tarde", "noche"]
    };
  }

  componentDidMount() {
    this.llenarCurso(this.curso)
    console.log(this.curso)
  }

  llenarCurso(curso) {
    this.setState({
      curso: curso,
      id: curso.id,
      nombre: curso.nombre,
      nivel: curso.nivel,
      turno: curso.turno,
      profesor: curso.profesor,
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

  confirmar() {

  }

  cancelar() {
    this.props.onCancel();
  }


  render() {
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
                      {tdArray.map((prop, key) => {
                        return (
                          <tr key={key}>
                            {prop.map((prop, key) => {
                              return <td key={key}>{prop}</td>;
                            })}
                          </tr>
                        );
                      })}
                    </tbody>
                  </Table>
                }
              />


            </div>{" "}
            <AceptarYCancelar
              acceptText={"Aceptar"}
              cancelText={"Volver"}
              cancelar={() => this.cancelar()}
              aceptar={() => this.confirmar}
            />{" "}
          </div>{" "}
        </div>{" "}
      </div>
    );
  }
}

export default OneCourse;
