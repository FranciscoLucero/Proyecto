package com.example.germa.proyecto.OpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper{
    public static final String DB = "inasistencias.db";
    public static final int DB_VERSION = 1;


    //Declaración de tablas
    public static final String tableCargo = "cargo";
    public static final String tablePersonas = "personas";
    public static final String tableUsuarios = "usuarios";
    public static final String tableAlumnos = "alumnos";
    public static final String tableMaterias = "materias";
    public static final String tableGrupos = "grupos";
    public static final String tableListas = "listas";
    public static final String tableHorarios = "horarios";


    //Creación de columnas tabla cargo
    public static final String columna_id_cargo = "id_cargo";
    public static final String columna_cargo = "cargo";

    //Creación de columnas tabla personas
    public static final String columna_id_per = "id_persona";
    public static final String columna_id_cargo_per = "id_cargo";
    public static final String columna_nombre_persona = "nombre";
    public static final String columna_ap_pat = "apellido_pat";
    public static final String columna_ap_mat = "apellido_mat";


    //creación de columnas tabla usuarios
    public static final String columna_id_usuario = "id_usuario";
    public static final String columna_usuario = "usuario";
    public static final String columna_contraseña = "contraseña";
    public static final String columna_estado ="estado";
    public static final String columna_id_persona ="id_persona";


    //creación de columnas tabla alumnos
    public static final String columna_id_alumnos = "id_alumno";
    public static final String columna_nombre = "nombre";
    public static final String columna_apellido_pat = "apellido_pat";
    public static final String columna_apellido_mat = "apellido_mat";
    public static final String columna_domicilio = "domicilio";
    public static final String columna_numero_contacto = "numero_contacto";



    //creación de columnas tabla materias
    public static final String column_id_materia_mat = "id_materia";
    public static final String columna_materia = "materia";


    //creacion de columnas tabla grupos
    public static final String columna_id_grupos = "id_grupo";
    public static final String columna_id_alumno = "id_alumno";
    public static final String columna_id_materia_grupo = "id_materia";



    //creacion de columnas tabla lista
    public static final String columna_id_lista = "id_lista";
    public static final String columna_fecha = "fecha";
    public static final String columna_id_cargo_lista = "id_cargo";
    public static final String getColumna_id_persona_lista = "id_persona";



    //creacion de columnas tabla horario
    public static final String columna_id_horario = "id_horario";
    public static final String columna_hora = "hora";
    public static final String columna_id_materia_hora = "id_materia";
    public static final String columna_id_grupo_hora = "id_grupo";




    //declaración de la tabla cargo
    public static final String SQL_CREATE_TABLE_CARGO =
            " create table " +tableCargo + " (" +
                   columna_id_cargo + " integer primary key autoincrement," +
                    columna_cargo + " varchar(20) not null);";

    //Declaración de la tabla personas
    public static final String SQL_CREATE_TABLE_PERSONAS =
            " create table " +tablePersonas + " (" +
                    columna_id_per + " integer primary key autoincrement," +
                    columna_id_cargo_per + " integer," +
                    columna_nombre_persona + " varchar(30) not null," +
                    columna_ap_pat + " varchar(30) not null," +
                    columna_ap_mat + " varchar(30) not null,"
             +"foreign key (" +columna_id_cargo_per + ") references " + tableCargo + "(id_cargo)" +")";



    //declaracion de la tabla usuarios
    public static final String  SQL_CREATE_TABLE_USUARIOS =
            " create table " +tableUsuarios + " (" +
                    columna_id_usuario + " integer primary key autoincrement," +
                    columna_usuario + " varchar(50) not null," +
                    columna_contraseña + " varchar(8) not null," +
                    columna_estado + " varchar(15)  not null," +
                    columna_id_persona + " int(4) not null,"
            +"foreign key (" + columna_id_per + ") references " + tablePersonas + "(id_persona)" + ")";


    //declaracion de la tabla alumnos
    public static final String  SQL_CREATE_TABLE_ALUMNOS =
            " create table " +tableAlumnos + " (" +
                    columna_id_alumnos + " integer primary key autoincrement, " +
                    columna_nombre + " varchar(30) not null," +
                    columna_apellido_pat + " varchar(30) not null," +
                    columna_apellido_mat + " varchar(30) not null," +
                    columna_domicilio + " varchar(100) not null," +
                    columna_numero_contacto + " varchar(15) not null);";


    //declaracion de la tabla materias
    public static final String SQL_CREATE_TABLE_MATERIAS =
            " create table " +tableMaterias + " (" +
                    column_id_materia_mat + " integer primary key autoincrement," +
                    columna_materia + " varchar(15) not null);";


    //declaración de tabla grupos
    public static final String SQL_CREATE_TABLE_GRUPOS =
            " create table " +tableGrupos + " (" +
                    columna_id_grupos + " integer," +
                    columna_id_alumno + " integer not null," +
                    columna_id_materia_grupo + " integer not null,"
            +"foreign key (" + columna_id_alumno + ") references " +tableAlumnos + "(id_alumno),"
            +"foreign key (" + columna_id_materia_grupo +") references " +tableMaterias + "(id_materia)" +")";



    //declaración de tabla listas
    public static final String SQL_CREATE_TABLE_LISTA =
            " create table " +tableListas + " (" +
                    columna_id_lista + " integer," +
                    columna_fecha + " date not null," +
                    columna_id_cargo_lista + " integer not null," +
                    getColumna_id_persona_lista + " integer not null,"
            +"foreign key (" + columna_id_cargo_lista + ") references " +tableCargo + "(id_cargo),"
            +"foreign key (" + getColumna_id_persona_lista +") references " +tablePersonas + "(id_persona)" +")";


    //declaracion de tabla horarios
    public static final String SQL_CREATE_TABLE_HORARIOS =
            " create table " +tableHorarios + " (" +
                    columna_id_horario + " integer," +
                    columna_hora + " date not null," +
                    columna_id_materia_hora + " integer not null," +
                    columna_id_grupo_hora + " integer not null,"
            +"foreign key (" + columna_id_materia_hora + ") references " +tableMaterias + "(id_materia),"
            +"foreign key (" + columna_id_grupo_hora +") references " +tableGrupos + "(id_grupo)" +")";






    public DBHelper(Context context) {
        super(context, DB, null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_CARGO);
        db.execSQL(SQL_CREATE_TABLE_PERSONAS);
        db.execSQL(SQL_CREATE_TABLE_USUARIOS);

        db.execSQL(SQL_CREATE_TABLE_ALUMNOS);
        db.execSQL(SQL_CREATE_TABLE_MATERIAS);

        db.execSQL(SQL_CREATE_TABLE_GRUPOS);
        db.execSQL(SQL_CREATE_TABLE_LISTA);
        db.execSQL(SQL_CREATE_TABLE_HORARIOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
