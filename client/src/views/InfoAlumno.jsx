import Card from "components/Card/Card.jsx";
const React = require('react')
const { Alert } = require("react-alert");

class InfoAlumno extends React.Component {
    constructor(props) {
        super(props)
        this.screen = this.props.screen    // con esto seteo la pantalla padre
    }

    alum() {
        return this.props.data
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
                                        {//this.datoEnFila("D.N.I. :  ", this.alum().nombre, anchoLabel)}
                                            //{this.datoEnFila("Teléfono Ppal. :  ", this.alum()._telPrincipal, anchoLabel)}
                                            //{this.datoEnFila("Fecha Nac. :  ", this.alum()._fechaNac.substring(0,10), anchoLabel)}
                                            //{this.datoEnFila("Comentarios :  ", this.alum()._comentario, 12)
                                        }
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div className="card-bg-info" style={{
                            marginTop: "20px", marginLeft: "30px", marginBottom: "20px"
                        }}>
                            {this.botonStandard(
                                "Close ",
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
