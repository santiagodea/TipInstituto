import React from "react";
import Card from "components/Card/Card.jsx";
import { FormInputs } from "components/FormInputs/FormInputs.jsx";
import axios from "axios";


class AddPayment extends React.Component {
    constructor(props) {
        super(props)
        this.screen = this.props.screen    // con esto seteo la pantalla padre
        this.state = {
            agregarPago: this.props.agregarPago,
            alumno: this.props.data,
            amount: 0,
            months: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
            month: ""
        }
    }

    alum() {
        return this.props.data
    }

    mostrarInfo() {

    }

    savePayment() {
        let self = this;
        const newPayment = {
            month: this.state.month,
            date: new Date(),
            amount: this.state.amount,
            idStudent: this.props.data.id
        };
        axios
            .post("/payment", newPayment)
            .then(function (res) {
                console.log("A new payment has been added.");
            })
            .then(function (res) {
                self.props.volver(self.alum());
            })
            .catch(function (error) {
                console.log("ERROR - " + error);
            });
    }

    manejarSeleccionDeMes(event) {
        this.setState({ month: event.target.value })
    }
    desplegar(collect) {
        return collect.map(c => (
            <option key={c} value={c}>
                {c}
            </option>
        ));
    }



    recuadroInfoAlumno() {
        const anchoLabel = 5
        return (
            <Card
                title="Add a new payment"
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
                            <div class="col-xs-6">
                                <div className="col-md-7">
                                    <label htmlFor="month"> Month: </label>
                                    <select
                                        label="Month"
                                        className="form-control"
                                        onChange={this.manejarSeleccionDeMes.bind(this)}
                                        defaultValue=" "
                                        id="meses"
                                    >
                                        {this.desplegar(this.state.months)}
                                    </select>
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <FormInputs
                                    ncols={["col-xs-7"]}
                                    properties={[
                                        {
                                            label: "amount",
                                            type: "number",
                                            bsClass: "form-control",
                                            placeholder: "$100",
                                            value: this.state.amount,
                                            onChange: event => this.setState({ amount: event.target.value }),
                                            defaultValue: "000",
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
                                () => this.savePayment(),
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

    // Botón -  parámetros Label , Acción, Clases Adicionales, Icono (GlypIcon)
    botonStandard(label, accion, clasesAdicionales, glyphIcon) {
        return (
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
export default AddPayment;