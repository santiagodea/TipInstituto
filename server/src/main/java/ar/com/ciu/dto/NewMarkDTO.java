package ar.com.ciu.dto;

import java.time.LocalDate;

public class NewMarkDTO {
	idCourse: this.props.idCourse,
    idStudent: this.props.data.id,
    description: this.state.description,
    mark: this.state.mark,
    date: new Date().getDate()
    
    private Long id;
	private Long idCourse;
	private Long idStudent;
	private String description;
	private double mark;
	private LocalDate date;
}
