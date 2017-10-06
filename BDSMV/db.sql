CREATE TABLE Automovil (
  idAutomovil INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Marca VARCHAR(25) NOT NULL,
  Modelo VARCHAR(25) NOT NULL,
  Anio INTEGER UNSIGNED NOT NULL,
  Desc_Extra TEXT NOT NULL,
  Kilometraje_Actual FLOAT NOT NULL,
  Kilometraje_Recorrido FLOAT NOT NULL,
  Combustible_Actual FLOAT NOT NULL,
  Combustible_Gastado FLOAT NOT NULL,
  PRIMARY KEY(idAutomovil)
);

CREATE TABLE Mantenimiento (
  idMantenimiento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Automovil_idAutomovil INTEGER UNSIGNED NOT NULL,
  Tipo VARCHAR(25) NOT NULL,
  Fecha DATE NOT NULL,
  Estado INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idMantenimiento),
  INDEX Mantenimiento_FKIndex1(Automovil_idAutomovil)
);

CREATE TABLE Rendimiento (
  idRendimiento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Automovil_idAutomovil INTEGER UNSIGNED NOT NULL,
  Rendimiento FLOAT NOT NULL,
  PRIMARY KEY(idRendimiento),
  INDEX Rendimiento_FKIndex1(Automovil_idAutomovil)
);


