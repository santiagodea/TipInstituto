package ar.com.ciu.dto;

public class ScidDTO {
		// ATRIBUTOS
		private Long idStudent;
		private Long idCourse;

		public ScidDTO() {
			super();
		}

		public ScidDTO(Long idStudent, Long idCourse) {
			super();
			this.idCourse = idCourse;
			this.idStudent = idStudent;
		}

		public Long getIdStudent() {
			return idStudent;
		}

		public void setIdStudent(Long idStudent) {
			this.idStudent = idStudent;
		}

		public Long getIdCourse() {
			return idCourse;
		}

		public void setIdCourse(Long idCourse) {
			this.idCourse = idCourse;
		}
		
	}