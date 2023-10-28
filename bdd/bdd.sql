-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-10-02 02:38:04.448

-- tables
-- Table: Administrador

--USUARIO, TIPO USUARIO, EVALUADOR, INSTITUCION EMPRESA, ADMINISTRADOR Y ESTUDIANTE

CREATE TABLE Administrador (
    AdministradorID int  NOT NULL,
    Cargo varchar(30)  NOT NULL,
    InstitucionEmpresa_EmpresaID int  NOT NULL,
    Usuario_UsuarioID int  NOT NULL,
    TipoUsuario_TipoID int  NOT NULL,
    CONSTRAINT Administrador_pk PRIMARY KEY (AdministradorID)
);

-- Table: ConvocatoriaPractica
CREATE TABLE ConvocatoriaPractica (
    ConvocatoriaID int  NOT NULL,
    Titulo_convocatoria varchar(50)  NOT NULL,
    Descripcion_convocatoria varchar(50)  NOT NULL,
    Fecha_publicacion date  NOT NULL,
    Estado_aprobacion boolean  NOT NULL,
    InstitucionEmpresa_EmpresaID int  NOT NULL,
    Usei_UsuarioID int  NOT NULL,
    CONSTRAINT ConvocatoriaPractica_pk PRIMARY KEY (ConvocatoriaID)
);

-- Table: DocumentoElectronico
CREATE TABLE DocumentoElectronico (
    DocumentoID int  NOT NULL,
    Tipo_documento varchar(30)  NOT NULL,
    Nombre_documento varchar(50)  NOT NULL,
    Contenido_documento bytea  NOT NULL,
    FormularioSolicitud_SolicitudID int  NOT NULL,
    CONSTRAINT DocumentoElectronico_pk PRIMARY KEY (DocumentoID)
);

-- Table: Estudiante
CREATE TABLE Estudiante (
    EstudianteID int  NOT NULL,
    Semestre varchar(50)  NOT NULL,
    Carrera varchar(50)  NOT NULL,
    Usuario_UsuarioID int  NOT NULL,
    TipoUsuario_TipoID int  NOT NULL,
    CONSTRAINT Estudiante_pk PRIMARY KEY (EstudianteID)
);

-- Table: EvaluacionPasantia
CREATE TABLE EvaluacionPasantia (
    EvaluacionID int  NOT NULL,
    Evaluacion_desempenio decimal(10,2)  NOT NULL,
    Comentario_evaluacion varchar(70)  NOT NULL,
    PracticaRealizada_PracticaID int  NOT NULL,
    Evaluador_EvaluadorID int  NOT NULL,
    CONSTRAINT EvaluacionPasantia_pk PRIMARY KEY (EvaluacionID)
);

-- Table: Evaluador
CREATE TABLE Evaluador (
    EvaluadorID int  NOT NULL,
    Usuario_UsuarioID int  NOT NULL,
    TipoUsuario_TipoID int  NOT NULL,
    CONSTRAINT Evaluador_pk PRIMARY KEY (EvaluadorID)
);

-- Table: EventosPasantia
CREATE TABLE EventosPasantia (
    EventoID int  NOT NULL,
    Tipo_evento varchar(30)  NOT NULL,
    Fecha_hora_evento timestamp  NOT NULL,
    Descripcion_evento varchar(50)  NOT NULL,
    PracticaRealizada_PracticaID int  NOT NULL,
    ConvocatoriaPractica_ConvocatoriaID int  NOT NULL,
    CONSTRAINT EventosPasantia_pk PRIMARY KEY (EventoID)
);

-- Table: FormularioSolicitud
CREATE TABLE FormularioSolicitud (
    SolicitudID int  NOT NULL,
    Fecha_solicitud date  NOT NULL,
    Estado_solicitud boolean  NOT NULL,
    Documento_adjunto varchar(255)  NOT NULL,
    Estudiante_EstudianteID int  NOT NULL,
    CONSTRAINT FormularioSolicitud_pk PRIMARY KEY (SolicitudID)
);

-- Table: InstitucionEmpresa
CREATE TABLE InstitucionEmpresa (
    EmpresaID int  NOT NULL,
    Nombre_empresa varchar(50)  NOT NULL,
    Tipo_convenio varchar(30)  NOT NULL,
    Requisitos_convenio varchar(50)  NOT NULL,
    Telefono varchar(20)  NOT NULL,
    Correo varchar(50)  NOT NULL,
    CONSTRAINT InstitucionEmpresa_pk PRIMARY KEY (EmpresaID)
);

-- Table: Mensaje
CREATE TABLE Mensaje (
    MensajeID int  NOT NULL,
    contenido_mensaje varchar(70)  NOT NULL,
    fecha_envio date  NOT NULL,
    Usuario_UsuarioID_Emisor int  NOT NULL,
    Usuario_UsuarioID_Receptor int  NOT NULL,
    CONSTRAINT Mensaje_pk PRIMARY KEY (MensajeID)
);

-- Table: PracticaRealizada
CREATE TABLE PracticaRealizada (
    PracticaID int  NOT NULL,
    Fecha_inicio date  NOT NULL,
    Fecha_finalizacion date  NOT NULL,
    Estado_practica boolean  NOT NULL,
    CONSTRAINT PracticaRealizada_pk PRIMARY KEY (PracticaID)
);

-- Table: TipoUsuario
CREATE TABLE TipoUsuario (
    TipoID int  NOT NULL,
    Tipo_usuario varchar(20)  NOT NULL,
    CONSTRAINT TipoUsuario_pk PRIMARY KEY (TipoID)
);

-- Table: Usei
CREATE TABLE Usei (
    UseiID int  NOT NULL,
    Usuario_UsuarioID int  NOT NULL,
    TipoUsuario_TipoID int  NOT NULL,
    CONSTRAINT Usei_pk PRIMARY KEY (UseiID)
);

-- Table: Usuario
CREATE TABLE Usuario (
    UsuarioID int  NOT NULL,
    Contrasenia varchar(20)  NOT NULL,
    Nombre varchar(50)  NOT NULL,
    Apellido varchar(50)  NOT NULL,
    Carnet varchar(30)  NOT NULL,
    Correo varchar(50)  NOT NULL,
    Telefono varchar(20)  NOT NULL,
    Direccion varchar(50)  NOT NULL,
    CONSTRAINT Usuario_pk PRIMARY KEY (UsuarioID)
);

-- foreign keys
-- Reference: Administrador_InstitucionEmpresa (table: Administrador)
ALTER TABLE Administrador ADD CONSTRAINT Administrador_InstitucionEmpresa
    FOREIGN KEY (InstitucionEmpresa_EmpresaID)
    REFERENCES InstitucionEmpresa (EmpresaID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Administrador_TipoUsuario (table: Administrador)
ALTER TABLE Administrador ADD CONSTRAINT Administrador_TipoUsuario
    FOREIGN KEY (TipoUsuario_TipoID)
    REFERENCES TipoUsuario (TipoID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Administrador_Usuario (table: Administrador)
ALTER TABLE Administrador ADD CONSTRAINT Administrador_Usuario
    FOREIGN KEY (Usuario_UsuarioID)
    REFERENCES Usuario (UsuarioID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: CalendarioPasantia_ConvocatoriaPractica (table: EventosPasantia)
ALTER TABLE EventosPasantia ADD CONSTRAINT CalendarioPasantia_ConvocatoriaPractica
    FOREIGN KEY (ConvocatoriaPractica_ConvocatoriaID)
    REFERENCES ConvocatoriaPractica (ConvocatoriaID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: CalendarioPasantia_PracticaRealizada (table: EventosPasantia)
ALTER TABLE EventosPasantia ADD CONSTRAINT CalendarioPasantia_PracticaRealizada
    FOREIGN KEY (PracticaRealizada_PracticaID)
    REFERENCES PracticaRealizada (PracticaID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: ConvocatoriaPractica_InstitucionEmpresa (table: ConvocatoriaPractica)
ALTER TABLE ConvocatoriaPractica ADD CONSTRAINT ConvocatoriaPractica_InstitucionEmpresa
    FOREIGN KEY (InstitucionEmpresa_EmpresaID)
    REFERENCES InstitucionEmpresa (EmpresaID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: ConvocatoriaPractica_Usei (table: ConvocatoriaPractica)
ALTER TABLE ConvocatoriaPractica ADD CONSTRAINT ConvocatoriaPractica_Usei
    FOREIGN KEY (Usei_UsuarioID)
    REFERENCES Usei (UseiID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: DocumentoElectronico_FormularioSolicitud (table: DocumentoElectronico)
ALTER TABLE DocumentoElectronico ADD CONSTRAINT DocumentoElectronico_FormularioSolicitud
    FOREIGN KEY (FormularioSolicitud_SolicitudID)
    REFERENCES FormularioSolicitud (SolicitudID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Estudiante_TipoUsuario (table: Estudiante)
ALTER TABLE Estudiante ADD CONSTRAINT Estudiante_TipoUsuario
    FOREIGN KEY (TipoUsuario_TipoID)
    REFERENCES TipoUsuario (TipoID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Estudiante_Usuario (table: Estudiante)
ALTER TABLE Estudiante ADD CONSTRAINT Estudiante_Usuario
    FOREIGN KEY (Usuario_UsuarioID)
    REFERENCES Usuario (UsuarioID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: EvaluacionPasantia_Evaluador (table: EvaluacionPasantia)
ALTER TABLE EvaluacionPasantia ADD CONSTRAINT EvaluacionPasantia_Evaluador
    FOREIGN KEY (Evaluador_EvaluadorID)
    REFERENCES Evaluador (EvaluadorID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: EvaluacionPasantia_PracticaRealizada (table: EvaluacionPasantia)
ALTER TABLE EvaluacionPasantia ADD CONSTRAINT EvaluacionPasantia_PracticaRealizada
    FOREIGN KEY (PracticaRealizada_PracticaID)
    REFERENCES PracticaRealizada (PracticaID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Evaluador_TipoUsuario (table: Evaluador)
ALTER TABLE Evaluador ADD CONSTRAINT Evaluador_TipoUsuario
    FOREIGN KEY (TipoUsuario_TipoID)
    REFERENCES TipoUsuario (TipoID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Evaluador_Usuario (table: Evaluador)
ALTER TABLE Evaluador ADD CONSTRAINT Evaluador_Usuario
    FOREIGN KEY (Usuario_UsuarioID)
    REFERENCES Usuario (UsuarioID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FormularioSolicitud_Estudiante (table: FormularioSolicitud)
ALTER TABLE FormularioSolicitud ADD CONSTRAINT FormularioSolicitud_Estudiante
    FOREIGN KEY (Estudiante_EstudianteID)
    REFERENCES Estudiante (EstudianteID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Mensaje_Usuario (table: Mensaje)
ALTER TABLE Mensaje ADD CONSTRAINT Mensaje_Usuario
    FOREIGN KEY (Usuario_UsuarioID_Emisor)
    REFERENCES Usuario (UsuarioID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Usei_TipoUsuario (table: Usei)
ALTER TABLE Usei ADD CONSTRAINT Usei_TipoUsuario
    FOREIGN KEY (TipoUsuario_TipoID)
    REFERENCES TipoUsuario (TipoID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Usei_Usuario (table: Usei)
ALTER TABLE Usei ADD CONSTRAINT Usei_Usuario
    FOREIGN KEY (Usuario_UsuarioID)
    REFERENCES Usuario (UsuarioID)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- sequences
-- Sequence: Administrador_seq
CREATE SEQUENCE Administrador_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: ConvocatoriaPractica_seq
CREATE SEQUENCE ConvocatoriaPractica_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: DocumentoElectronico_seq
CREATE SEQUENCE DocumentoElectronico_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: Estudiante_seq
CREATE SEQUENCE Estudiante_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: EvaluacionPasantia_seq
CREATE SEQUENCE EvaluacionPasantia_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: Evaluador_seq
CREATE SEQUENCE Evaluador_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: EventosPasantia_seq
CREATE SEQUENCE EventosPasantia_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: FormularioSolicitud_seq
CREATE SEQUENCE FormularioSolicitud_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: InstitucionEmpresa_seq
CREATE SEQUENCE InstitucionEmpresa_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: Mensaje_seq
CREATE SEQUENCE Mensaje_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: PracticaRealizada_seq
CREATE SEQUENCE PracticaRealizada_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: Usei_seq
CREATE SEQUENCE Usei_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: Usuario_seq
CREATE SEQUENCE Usuario_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- End of file.
