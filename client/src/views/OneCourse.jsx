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


const { AceptarYCancelar } = require("../components/Varios/botones.jsx");

class OneCourse
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

  confirmar(){

  }

  cancelar(){
    this.props.onCancel(); 
  }


  render() {
    return (
      <div className="content">
        <Grid fluid>
          <Row>
            <Col md={8}>
              <AceptarYCancelar
                      acceptText={"Guardar Cursada"}
                      cancelText={"Cancelar"}
                      cancelar={() => this.cancelar()}
                      aceptar={() => this.confirmar()}
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

export default OneCourse;
