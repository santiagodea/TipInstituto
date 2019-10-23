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

class NewStudent extends Component {
    constructor(props) {
        super(props);
        this._curso = this.props.curso;
        this.student = this.props.student;
        this.state = {
            dni: 0,
            surname: "",
            name: "",
            mail: "",
            tel_principal: 0,
            tel_secundario: 0
        };
    }

    componentDidMount() {

    }

    llenarStudent(student) {
        this.setState({
            dni: student.dni,
            surname: student.surname,
            name: student.name,
            mail: student.mail,
            tel_principal: student.tel_principal,
            tel_secundario: student.tel_secundario
        });
    }

    guardarStudent(alert) {
        // let self = this;
        // const course = {
        //   name: this.state.name,
        //   level: this.state.level,
        //   shift: this.state.shift,
        //   teacher: this.state.teacher,
        //   startTime: this.state.startTime
        // };
        // axios
        //   .post("/course", course)
        //   .then(function (res) {
        //     console.log("The new Course was successfully created.");
        //     self.props.recargado();
        //   })
        //   .catch(function (error) {
        //     console.log("ERROR - " + error);
        //   });
        //   self.props.onCancel();
      }

      cancelarAgregado() {
        this.props.onCancel();
      }
    
      cancelar() {
        this.props.onCancel();
      }

    render() {
        return (
            <div className="content">
                <Grid fluid>
                    <Row>
                        <Col md={8}>
                            <Card
                                title="New Student"
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
                                        <div className="clearfix" />
                                    </form>
                                }
                            />
                            <AceptarYCancelar
                                acceptText={"Save Course"}
                                cancelText={"Calcel"}
                                cancelar={() => this.cancelar()}
                                //aceptar={() => this.guardarCurso()}
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


export default NewStudent;
