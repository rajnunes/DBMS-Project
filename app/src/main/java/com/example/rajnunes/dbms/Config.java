package com.example.rajnunes.dbms;

/**
 * Created by rajnunes on 5/4/17.
 */

public class Config {

    //Address of our scripts of the CRUD
    public static final String URL_ADD = "http://192.168.43.81/android/addEmp.php";
    public static final String URL_ADD_DOC = "http://192.168.43.81/android/addDoctor.php";
    public static final String URL_ADD_NURSE = "http://192.168.43.81/android/addNurse.php";
    public static final String URL_ADD_DIAGNOSIS = "http://192.168.43.81/android/addDiagnosis.php";

    public static final String URL_GET_ALL = "http://192.168.43.81/android/getAllEmp.php";
    public static final String URL_GET_ALL_DOCTOR = "http://192.168.43.81/android/getAllEmpDoctor.php";
    public static final String URL_GET_ALL_NURSE = "http://192.168.43.81/android/getAllEmpNurse.php";
    public static final String URL_GET_ALL_DIAGNOSIS = "http://192.168.43.81/android/getAllEmpDiagnosis.php";

    public static final String URL_GET_EMP = "http://192.168.43.81/android/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.43.81/android/updateEmp.php";
    public static final String URL_DELETE_EMP = "http://192.168.43.81/android/deleteEmp.php";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "name";
    public static final String KEY_EMP_PHONE = "phone";
    public static final String KEY_EMP_GEN = "gender";
    public static final String KEY_EMP_ADD="address";
    public static final String KEY_EMP_AGE="age";
    public static final String KEY_EMP_DESIGNATION="designation";

    //JSON Tags
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_PHONE = "phone";
    public static final String TAG_SAL = "salary";

    //employee id to pass with intent
    public static final String EMP_ID = "id";
}
