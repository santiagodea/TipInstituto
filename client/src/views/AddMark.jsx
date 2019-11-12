import Card from "components/Card/Card.jsx";
import { FormInputs } from "components/FormInputs/FormInputs.jsx";
const axios = require("axios");

const React = require('react')
const { Alert } = require("react-alert");
class InfoAlumno extends React.Component {
    constructor(props) {
        super(props)
        this.screen = this.props.screen    // con esto seteo la pantalla padre
        this.state = {
            agregarNota: this.props.agregarNota,
            mark: 0,
            description: ""
        }
    }

    alum() {
        return this.props.data
    }

    saveMark() {
        let self = this;
        const newMark = {
            idCourse: this.props.idCourse,
            idStudent: this.props.data.id,
            description: this.state.description,
            mark: this.state.mark,
            date: new Date().getDate()
        };
        axios
            .post("/mark/addMark", newMark)
            .then(function (res) {
                console.log("A new mark has been added.");
                self.props.recargado();
            })
            .catch(function (error) {
                console.log("ERROR - " + error);
            });
    }

    recuadroInfoAlumno() {
        const anchoLabel = 5
        return (
            <Card
                title="Student's Information"
                ctTableFullWidth
                ctTableResponsive
                content={
                    <div>
                        <div className="row ">
                            <div className="align-self-center card-bg-info col-md-8" style={{
                                marginTop: "20px", marginLeft: "30px", marginBottom: "20px",
                                borderStyle: "solid", borderWidth: "2px", borderColor: "#e9ecef", borderRadius: "6px",
                                paddingTop: "6px", paddingBottom: "10px", paddingLeft: "40px", paddingRight: "20px"
                            }}>
                                <div className="row">
                                    <div className="card-body ">
                                        {this.datoEnFila("Surname: ", this.alum().surname, anchoLabel)}
                                        {this.datoEnFila("Name :  ", this.alum().name, anchoLabel)}
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row" style={{ margin: "2px" }}>
                            <div class="col-xs-12">
                                <FormInputs
                                    ncols={["col-xs-12"]}
                                    properties={[
                                        {
                                            label: "Description:",
                                            type: "text",
                                            bsClass: "form-control",
                                            placeholder: "add a description",
                                            value: this.state.description,
                                            onChange: event => this.setState({ description: event.target.value }),
                                            defaultValue: "without description",
                                            disabled: false
                                        }
                                    ]}
                                />
                            </div>
                            <div class="col-xs-6">
                                <FormInputs
                                    ncols={["col-xs-4"]}
                                    properties={[
                                        {
                                            label: "Mark",
                                            type: "text",
                                            bsClass: "form-control",
                                            placeholder: "10",
                                            value: this.state.mark,
                                            onChange: event => this.setState({ mark: event.target.value }),
                                            defaultValue: "0",
                                            disabled: false
                                        }
                                    ]}
                                />
                            </div>
                        </div>

                        <div className="card-bg-info" style={{
                            marginTop: "10px", marginLeft: "10px", marginBottom: "20px"
                        }}>
                            {this.botonStandard(
                                "Confirm ",
                                () => this.saveMark(),
                                "btn-primary btn-xs",
                                "fa-"
                            )}
                            {this.botonStandard(
                                "Cancel ",
                                this.screen,
                                "btn-primary btn-xs",
                                "fa-"
                            )}
                        </div>
                    </div>
                }
            />

        )
    }

    datoEnFila(label, valor, anchoLabel = 3) {
        return (
            <div className="row" style={{ marginBottom: "6px" }}>
                <div className={"col-md-" + anchoLabel} style={{ fontWeight: "bold" }}>{label}</div>
                <div className={"col-md-" + (12 - anchoLabel)}>{valor}</div>
            </div>
        )
    }

    panelNota() {
        return (
            <div class="row" style={{ margin: "6px" }}>
                <div class="col-xs-6">
                    <FormInputs
                        ncols={["col-md-12"]}
                        properties={[
                            {
                                label: "Mark",
                                type: "text",
                                bsClass: "form-control",
                                placeholder: "10",
                                value: this.state.mark,
                                onChange: event => this.setState({ mark: event.target.value }),
                                defaultValue: "0",
                                disabled: false
                            }
                        ]}
                    />
                </div>
                <div class="col-xs-6">
                    <label htmlFor="unit"> Unit: </label>
                    <select
                        label="unit"
                        className="form-control"
                        onChange={this.manejarSeleccionUnit.bind(this)}
                        id="units"
                    >
                        {this.desplegar(this.state.unit)}
                    </select>
                </div>
                <div>
                    {this.botonStandard(
                        "Confirm ",
                        this.screen,
                        "btn-primary btn",
                        "fa-"
                    )}
                    {this.botonStandard(
                        "Cancel ",
                        this.screen,
                        "btn-primary btn",
                        "fa-"
                    )}
                </div>
            </div>
        )
    }

    // Botón -  parámetros Label , Acción, Clases Adicionales, Icono (GlypIcon)
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
    render() {
        return (
            <div className="col-md-12">
                <div className="card text-dark">
                    {this.recuadroInfoAlumno()}
                </div>
            </div>
        )
    }


}
export default InfoAlumno;
