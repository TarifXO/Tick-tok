package com.example.medix.data.remote

import com.example.medix.data.authentication.Resource
import com.example.medix.domain.model.AppointmentResponse
import com.example.medix.domain.model.Doctor
import com.example.medix.domain.model.LoginResponse
import com.example.medix.domain.model.Patient
import com.example.medix.domain.model.PatientAppointmentsResponse
import com.example.medix.domain.model.PatientUpdateResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface MedixApi {


    //Doctors
    @GET("/api/Doctors")
    suspend fun getDoctors(
    ): List<Doctor>

    @GET("/api/Doctors/{id}")
    fun getDoctorById(@Path("id") id: Int): Call<Doctor>

    @GET("/api/Doctors/SearchDoctor/{Name}")
    suspend fun searchDoctor(
        @Path("Name") name: String
    ): List<Doctor>

    @GET("/api/Doctors/GetDoctor/{specilization}")
    suspend fun getDoctorBySpeciality(
        @Path("specilization") specialization: String
    ): List<Doctor>

    @Multipart
    @PUT("api/Doctors/{id}")
    suspend fun updateDoctor(
        @Path("id") id: Int,
        @Part("name") name: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("email") email: RequestBody,
        @Part("dateOfBirth") dateOfBirth: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("speciality") speciality: RequestBody,
        @Part("bio") bio: RequestBody,
        @Part("address") address: RequestBody,
        @Part("wage") wage: RequestBody,
        @Part image: MultipartBody.Part?
    ): Resource<Unit>


    //Authentication
    @Multipart
    @POST("/api/Authentication/login")
    suspend fun logIn(
        @Part("Email") email: RequestBody,
        @Part("Password") password: RequestBody
    ) : LoginResponse

    @Multipart
    @POST("/api/Authentication/ForgotPassword")
    suspend fun forgotPassword(
        @Part("email") email: RequestBody
    ): Resource<Unit>

    @Multipart
    @POST("/api/Authentication/ResetPassword")
    suspend fun resetPassword(
        @Part("Password") password: RequestBody,
        @Part("ConfirmPassword") confirmPassword: RequestBody,
        @Part("Email") email: RequestBody,
        @Part("token") token: RequestBody
    ): Resource<Unit>

    @Multipart
    @POST("api/Authentication/Register")
    suspend fun register(
        @Part("Username") username: RequestBody,
        @Part("Email") email: RequestBody,
        @Part("Password") password: RequestBody,
        @Part("IsPatient") isPatient: RequestBody,
        @Part("IsDoctor") isDoctor: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("Date_Of_birth") dateOfBirth: RequestBody,
        @Part("Gender") gender: RequestBody,
        @Part image: MultipartBody.Part?,
        @Part("Speciality") speciality: RequestBody?,
        @Part("bio") bio: RequestBody?,
        @Part("Address") address: RequestBody?,
        @Part("Wage") wage: RequestBody?
    )


    // Patients
    @GET("/api/Patients/{id}")
    fun getPatientById(@Path("id") id: Int): Call<Patient>

    @Multipart
    @PUT("api/Patients/{id}")
    suspend fun updatePatient(
        @Path("id") id: Int,
        @Part("Name") name: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("Email") email: RequestBody,
        @Part("Date_Of_birth") dateOfBirth: RequestBody,
        @Part("Gender") gender: RequestBody,
        @Part image: MultipartBody.Part?
    ): PatientUpdateResponse


    //Appointments
    @Multipart
    @POST("/api/Appointments")
    suspend fun createAppointment(
        @Part("DoctorId") doctorId: RequestBody,
        @Part("PatientId") patientId: RequestBody,
        @Part("Year") year: RequestBody,
        @Part("Month") month: RequestBody,
        @Part("Day") day: RequestBody,
        @Part("Hour") hour: RequestBody,
        @Part("Minute") minute: RequestBody
    ): AppointmentResponse

    @GET("/api/Appointments/patient")
    suspend fun getPatientAppointments(
        @Query("patient_id") patientId: Int
    ) : List<PatientAppointmentsResponse>
}