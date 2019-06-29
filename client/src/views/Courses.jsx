import React, { Component } from "react";
import { Grid, Row, Col } from "react-bootstrap";
import { StatsCard } from "components/StatsCard/StatsCard.jsx";
import NewCourse from "views/NewCourse";
import OneCourse from "views/OneCourse";

const log = require('chalk');




class Courses extends Component {
  constructor(props) {
    super(props);
    const curso = {
      nombre: "",
      nivel: "",
      turno: "",
      profesor: ""
    };
    this.state = {
      cursoSeleccionado: null,
      tarjetaDeCursos: true,
      nuevocursoActivo: false,
      activarUnCurso: false,
      cursos: []
    }
  }

  componentDidMount() {
    this.cargarCursos();
  }

  createLegend(json) {
    var legend = [];
    for (var i = 0; i < json["names"].length; i++) {
      var type = "fa fa-circle text-" + json["types"][i];
      legend.push(<i className={type} key={i} />);
      legend.push(" ");
      legend.push(json["names"][i]);
    }
    return legend;
  }

  cargarCursos() {
    var curso1 = {
      nombre: "Pre-Kinder",
      nivel: 1,
      turno: "Morning",
      profesor: "Ana"
    }
    var curso2 = {
      nombre: "Pre-Kinder",
      nivel: 2,
      turno: "Afternoon",
      profesor: "Juan"
    }
    var curso3 = {
      nombre: "Kids",
      nivel: 3,
      turno: "Afternoon",
      profesor: "Ana"
    }
    var curso4 = {
      nombre: "Kids",
      nivel: 2,
      turno: "Evening",
      profesor: "Maria"
    }
    var curso5 = {
      nombre: "Teens",
      nivel: 1,
      turno: "Afternoon",
      profesor: "Juan"
    }
    var curso6 = {
      nombre: "Teens",
      nivel: 2,
      turno: "Afternoon",
      profesor: "Ana"
    }
    var curso7 = {
      nombre: "Advanced",
      nivel: 1,
      turno: "Evening",
      profesor: "Maria"
    }
    var curso8 = {
      nombre: "Advanced",
      nivel: 2,
      turno: "Morning",
      profesor: "Ana"
    }
    var cursos_aux = [curso1, curso2, curso3, curso4, curso5, curso6, curso7, curso8];

    this.setState({ cursos: cursos_aux }); // AGREGAR VARIOS CURSOS A LA COLLECCION
  }

  tarjetaCursos(curso) {
    return (
      <div onClick={() => this.activarMostrarUnCurso(curso)} style={{ cursor: "pointer" }}>
        <Col lg={3} sm={6}>
          <div>
            <StatsCard
              //bigIcon={<i className="pe-7s-cash text-danger" />}
              statsText={curso.nombre}
              statsValue={curso.nivel}
              //statsIcon={<i className="fa fa-refresh" />}
              statsIconText={curso.turno + " - " + curso.profesor}
            />
          </div>
        </Col>
      </div>
    )
  }

  activarMostrarUnCurso(curso) {
    this.setState({
      cursoSeleccionado: curso,
      tarjetaDeCursos: false,
      nuevocursoActivo: false,
      activarUnCurso: true
    });
  }

  mostrarCursos() {
    console.log("CURSOS" + this.state.cursos.length)
    if (this.state.tarjetaDeCursos) {
      return (
        <div className="content">
          <Grid fluid>
            <Row>

              {this.state.cursos.map(c => this.tarjetaCursos(c))}

            </Row>

          </Grid>
          <a class="btn btn-fill btn-warning btn-block" onClick={() => this.accionOnClick()}>New Course</a>
        </div>
      );
    }
  }

  accionOnClick() {
    this.setState({
      tarjetaDeCursos: false,
      nuevocursoActivo: true
    });
  }

  mostrarNuevoCurso() {
    if (this.state.nuevocursoActivo) {
      return (
        <div>
          <NewCourse
            onCancel={() => this.cancelarNuevoCurso()}
          />
        </div>
      )
    }
  }

  mostrarUnCurso() {
    if (this.state.activarUnCurso) {
      return (
        <div>
          <OneCourse
            curso={this.state.cursoSeleccionado}
            onCancel={() => this.cancelarNuevoCurso()}
          />
        </div>
      )
    }
  }

  cancelarNuevoCurso() {
    this.setState({
      tarjetaDeCursos: true,
      nuevocursoActivo: false,
      activarUnCurso: false
    });
  }
  tarjetasOUnCurso() {
    console.log("LOG" + this.state.tarjetaDeCursos)
    if (this.state.tarjetaDeCursos) {
      return this.mostrarCursos();
    } else {
      return this.mostrarUnCurso();
    }
  }

  render() {
    return (
      <div>
        {this.tarjetasOUnCurso()}

        {this.mostrarNuevoCurso()}

      </div>
    )
  }
}

export default Courses;
