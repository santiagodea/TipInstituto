import Card from "components/Card/Card.jsx";
import { FormInputs } from "components/FormInputs/FormInputs.jsx";


const React = require('react')
const { Alert } = require("react-alert");




class InfoAlumno extends React.Component {
    constructor(props) {
        super(props)
        this.screen = this.props.screen    // con esto seteo la pantalla padre
        this.state = {
            agregarNota: this.props.agregarNota,
            mark: 0,
            unit: [1, 2, 3, 4, 5, 7, 8, 9, 10],
            unitSelect: 0
        }
    }

    alum() {
        return this.props.data
    }

    manejarSeleccionUnit(event) {
        this.setState({ unitSelect: event.target.value })
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
                                        {this.datoEnFila("Apellido  : ", this.alum().apellido, anchoLabel)}
                                        {this.datoEnFila("Nombre :  ", this.alum().nombre, anchoLabel)}
                                        {//this.datoEnFila("D.N.I. :  ", this.alum().nombre, anchoLabel)}
                                            //{this.datoEnFila("Teléfono Ppal. :  ", this.alum()._telPrincipal, anchoLabel)}
                                            //{this.datoEnFila("Fecha Nac. :  ", this.alum()._fechaNac.substring(0,10), anchoLabel)}
                                            //{this.datoEnFila("Comentarios :  ", this.alum()._comentario, 12)
                                        }
                                    </div>
                                </div>
                            </div>

                        </div>
                        {this.panelNota()}

                        <div className="card-bg-info" style={{
                            marginTop: "20px", marginLeft: "30px", marginBottom: "20px"
                        }}>
                            {this.botonStandard(
                                "Cerrar ",
                                this.screen,
                                "btn-primary btn",
                                "fa-"
                            )
                            }
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
        if (this.state.agregarNota) {
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
                </div>



            )
        }
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
